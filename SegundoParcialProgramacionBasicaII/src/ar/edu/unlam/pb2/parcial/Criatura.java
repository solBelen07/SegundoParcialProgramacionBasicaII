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
		// si comparten afinidad
		if (this.getAfinidadElemental().toUpperCase().equals(otra.getAfinidadElemental())) {
			this.setNivelDeEnergia(this.nivelDeEnergia += 10);
			otra.setNivelDeEnergia(otra.nivelDeEnergia += 10);
			return;
		}

		// si una es ancestral siempre domina la situacion, gana 20e y la otra pierde
		// 15e
		if (this instanceof CriaturaAncestral) {
			this.setNivelDeEnergia(this.nivelDeEnergia += 20);
			otra.setNivelDeEnergia(otra.nivelDeEnergia -= 15);
			
		} if (otra instanceof CriaturaAncestral) {
			otra.setNivelDeEnergia(otra.nivelDeEnergia += 20);
			this.setNivelDeEnergia(this.nivelDeEnergia -= 15);
			
		}
		// Si son opuestas (agua–fuego / aire–tierra)
		if ((this.getAfinidadElemental().toUpperCase().equals("AGUA")
				&& otra.getAfinidadElemental().toUpperCase().equals("FUEGO"))
				|| (this.getAfinidadElemental().toUpperCase().equals("AIRE")
						&& otra.getAfinidadElemental().toUpperCase().equals("TIERRA"))
				|| (otra.getAfinidadElemental().toUpperCase().equals("AGUA")
						&& this.getAfinidadElemental().toUpperCase().equals("FUEGO"))
				|| (otra.getAfinidadElemental().toUpperCase().equals("AIRE")
						&& this.getAfinidadElemental().toUpperCase().equals("TIERRA"))) {
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
