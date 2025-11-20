package ar.edu.unlam.pb2.parcial;

public class VinculoTerrestre extends Transformacion {

	public VinculoTerrestre(Criatura criaturaBase) {
		super(criaturaBase);
		asegurarEnergiaMinima();
	}

	private void asegurarEnergiaMinima() {
		if (criaturaBase.getNivelDeEnergia() < 50) {
			criaturaBase.setNivelDeEnergia(50);
		}
	}

	@Override
	public void entrenar(Integer intensidad) throws EnergiaExcedidaException {
		criaturaBase.entrenar(intensidad);
	}

}
