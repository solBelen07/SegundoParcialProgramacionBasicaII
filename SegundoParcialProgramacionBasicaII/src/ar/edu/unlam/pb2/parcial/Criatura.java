package ar.edu.unlam.pb2.parcial;

import java.util.Objects;

public abstract class Criatura implements Interaccion {

	protected String nombre;
	protected Integer nivelDeEnergia;
	protected String afinidadElemental;
	protected Boolean inestable;

	public Criatura(String nombre, Integer nivelDeEnergia, String afinidadElemental) {
		this.nombre = nombre;
		this.nivelDeEnergia = nivelDeEnergia;
		this.afinidadElemental = afinidadElemental;
		this.inestable = false;
	}

	public abstract void entrenar(Integer intensidad) throws EnergiaExcedidaException;

	public abstract void esPacifico(Boolean inestable);

	public void interactuar(Criatura otra) {

		String afinidad = this.getAfinidadElemental().toUpperCase();
		String afinidadOtra = otra.getAfinidadElemental().toUpperCase();

		// Afinidad compartida
		if (afinidad.equals(afinidadOtra)) {
			this.setNivelDeEnergia(this.nivelDeEnergia + 10);
			otra.setNivelDeEnergia(otra.nivelDeEnergia + 10);
			return;
		}

		// Si una es ancestral domina la situación
		if (this instanceof CriaturaAncestral) {
			this.setNivelDeEnergia(this.nivelDeEnergia + 20);
			otra.setNivelDeEnergia(otra.nivelDeEnergia - 15);
			
		}

		if (otra instanceof CriaturaAncestral) {
			otra.setNivelDeEnergia(otra.nivelDeEnergia + 20);
			this.setNivelDeEnergia(this.nivelDeEnergia - 15);
		
		}

		// Elementos opuestos
		boolean sonOpuestos = (afinidad.equals("AGUA") && afinidadOtra.equals("FUEGO"))
				|| (afinidad.equals("FUEGO") && afinidadOtra.equals("AGUA"))
				|| (afinidad.equals("AIRE") && afinidadOtra.equals("TIERRA"))
				|| (afinidad.equals("TIERRA") && afinidadOtra.equals("AIRE"));

		if (sonOpuestos) {
			this.setInestable(true);
			otra.setInestable(true);
			return;
		}
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public Integer getNivelDeEnergia() {
		return nivelDeEnergia;
	}

	public void setNivelDeEnergia(Integer nivelDeEnergia) {
		this.nivelDeEnergia = nivelDeEnergia;
	}

	public String getAfinidadElemental() {
		return afinidadElemental;
	}

	public void setAfinidadElemental(String afinidadElemental) {
		this.afinidadElemental = afinidadElemental;
	}

	public Boolean getInestable() {
		return inestable;
	}

	public void setInestable(Boolean inestable) {
		this.inestable = inestable;
	}

}
