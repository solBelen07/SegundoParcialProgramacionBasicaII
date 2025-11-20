
package ar.edu.unlam.pb2;

public abstract class Transformacion extends Criatura {
	protected Criatura criaturaBase;

	public Transformacion(Criatura criaturaBase) {
		super(criaturaBase.getNombre(), criaturaBase.getNivelDeEnergia(), criaturaBase.getAfinidadElemental());
		this.criaturaBase = criaturaBase;
	}

	public void setCriaturaBase(Criatura criaturaBase) {
		this.criaturaBase = criaturaBase;
	}

	@Override
	public abstract void entrenar(Integer intensidad) throws EnergiaExcedidaException;

	@Override
	public void esPacifico(Boolean inestable) {
		criaturaBase.esPacifico(inestable);
		this.inestable = criaturaBase.getInestable();
	}

	@Override
	public String getNombre() {
		return criaturaBase.getNombre();
	}

	@Override
	public Integer getNivelDeEnergia() {
		return criaturaBase.getNivelDeEnergia();
	}

	@Override
	public String getAfinidadElemental() {
		return criaturaBase.getAfinidadElemental();
	}

	@Override
	public Boolean getInestable() {
		return criaturaBase.getInestable();
	}

	@Override
	public void setNivelDeEnergia(Integer energia) {
		criaturaBase.setNivelDeEnergia(energia);
	}

	@Override
	public void setInestable(Boolean inestable) {
		criaturaBase.setInestable(inestable);
	}

	@Override
	public void setAfinidadElemental(String afinidad) {
		criaturaBase.setAfinidadElemental(afinidad);
	}
}
