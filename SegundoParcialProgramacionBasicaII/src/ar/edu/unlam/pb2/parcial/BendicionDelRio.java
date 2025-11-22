package ar.edu.unlam.pb2.parcial;

public class BendicionDelRio extends Transformacion {

	public BendicionDelRio(Criatura criaturaBase) {
		super(criaturaBase);
		duplicarEnergia();
	}

	private void duplicarEnergia() {
		Integer nuevaEnergia = criaturaBase.getNivelDeEnergia() * 2;
		if (nuevaEnergia > 180) {
			nuevaEnergia = 180;
		}
		criaturaBase.setNivelDeEnergia(nuevaEnergia);
	}

	@Override
	public void entrenar(Integer intensidad) throws EnergiaExcedidaException {
		criaturaBase.entrenar(intensidad);
	}

}