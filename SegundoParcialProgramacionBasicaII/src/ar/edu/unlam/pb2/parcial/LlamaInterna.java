package ar.edu.unlam.pb2.parcial;

public class LlamaInterna extends Transformacion {

	public LlamaInterna(Criatura criaturaBase) {
		super(criaturaBase);
		aplicarLlama();
	}

	private void aplicarLlama() {
		if ("FUEGO".equalsIgnoreCase(criaturaBase.getAfinidadElemental())) {
			criaturaBase.setNivelDeEnergia(criaturaBase.getNivelDeEnergia() + 30);
		} else {
			criaturaBase.setInestable(true);
		}
	}

	@Override
	public void entrenar(Integer intensidad) throws EnergiaExcedidaException {
		criaturaBase.entrenar(intensidad);
	}

	
}
