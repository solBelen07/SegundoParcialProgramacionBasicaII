package ar.edu.unlam.pb2;

public class CriaturaSalvaje extends Criatura {

	public CriaturaSalvaje(String nombre, Integer nivelDeEnergia, String afinidadElemental) {
		super(nombre, nivelDeEnergia, afinidadElemental);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void entrenar(Integer intensidad) {
		Integer aumento = intensidad * (1 + (int) (Math.random() * 2));
		// el math random devuelve un numero entre 0 y 2, sin incluir al 2, se suma uno
		// para que nunca sea 0 el aumento cuando se castea con el int

		this.nivelDeEnergia += aumento;
	}
	
	@Override
	public void esPacifico(Boolean afinidadElemental) {
		this.inestable = true;
	}

}
