package ar.edu.unlam.pb2;

public abstract class Criatura {

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
	
	public abstract void entrenar(Integer intensidad);
	public abstract void esPacifico(Boolean inestable);

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
