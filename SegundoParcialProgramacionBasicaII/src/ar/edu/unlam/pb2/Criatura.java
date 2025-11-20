package ar.edu.unlam.pb2;

public abstract class Criatura implements Interaccion{

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
		//si comparten afinidad
		if(this.getAfinidadElemental().toLowerCase().equals(otra.getAfinidadElemental())) {
			this.setNivelDeEnergia(this.nivelDeEnergia += 10);
			otra.setNivelDeEnergia(otra.nivelDeEnergia += 10);
			return;
		}
		// Si son opuestas (agua–fuego / aire–tierra)
		if((this.getAfinidadElemental().toLowerCase().equals("agua") && 
				otra.getAfinidadElemental().toLowerCase().equals("fuego")) || 
				(this.getAfinidadElemental().toLowerCase().equals("aire") && 
						otra.getAfinidadElemental().toLowerCase().equals("tierra"))){
			this.setInestable(true);
			otra.setInestable(true);
			return;
		}
		//si una es ancestral siempre domina la situacion, gana 20e y la otra pierde 15e
		if(this instanceof CriaturaAncestral) {
			this.setNivelDeEnergia(this.nivelDeEnergia += 20);
			otra.setNivelDeEnergia(otra.nivelDeEnergia -= 15);
			return;
		}
		if(otra instanceof CriaturaAncestral) {
			otra.setNivelDeEnergia(otra.nivelDeEnergia += 20);
			this.setNivelDeEnergia(this.nivelDeEnergia -= 15);
			return;
		}
	}

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
