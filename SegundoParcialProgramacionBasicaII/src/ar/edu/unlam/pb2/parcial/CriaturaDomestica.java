package ar.edu.unlam.pb2.parcial;

public class CriaturaDomestica extends Criatura {

	public CriaturaDomestica(String nombre, Integer nivelDeEnergia, String afinidadElemental) {
		super(nombre, nivelDeEnergia, afinidadElemental);
		// TODO Auto-generated constructor stub
	}


	public void entrenar(Integer intensidad) {
	    entrenar(intensidad, 1); 
	}

	public void entrenar(Integer intensidad, int multiplicador) {
	    this.nivelDeEnergia += intensidad * multiplicador;
	}

	@Override
	public void esPacifico(Boolean inestable) {
		this.inestable = false;
	}

}
