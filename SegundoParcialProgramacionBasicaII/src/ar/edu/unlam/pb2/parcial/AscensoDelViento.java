package ar.edu.unlam.pb2.parcial;

public class AscensoDelViento extends Transformacion {

	public AscensoDelViento(Criatura criaturaBase) {
		super(criaturaBase);
		// Convierte temporalmente al tipo AIRE
		criaturaBase.setAfinidadElemental(criaturaBase.getAfinidadElemental() + ",AIRE");
	}

	@Override
	public void entrenar(Integer intensidad) throws EnergiaExcedidaException {
		criaturaBase.entrenar(intensidad);
	}
}
