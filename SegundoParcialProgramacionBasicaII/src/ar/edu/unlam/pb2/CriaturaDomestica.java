package ar.edu.unlam.pb2;

public class CriaturaDomestica extends Criatura {

	public CriaturaDomestica(String nombre, Integer nivelDeEnergia, String afinidadElemental) {
		super(nombre, nivelDeEnergia, afinidadElemental);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void entrenar(Integer intensidad) {

		Integer aumento = intensidad * (1 + (int) (Math.random() * 2));
		this.nivelDeEnergia += aumento;

	}

	@Override
	public void esPacifico(Boolean inestable) {
		this.inestable = false;
	}

}
