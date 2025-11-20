package ar.edu.unlam.pb2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CriaturaTest {

	@Test
	void queSePuedaCrearUnaCriatura() {
		Criatura nueva = new CriaturaSalvaje("salvaje", 90, "tierra");
		assertNotNull(nueva);
		assertTrue(nueva instanceof CriaturaSalvaje);
	}

	@Test
	void queLanceUnaExcepcionAlSuperarLos200DeEnrgia() {
		Criatura nueva = new CriaturaSalvaje("salvaje", 190, "tierra");
		boolean lanzoExcepcion = false;

		try {
			nueva.entrenar(20); // debería superar 200
		} catch (EnergiaExcedidaException e) {
			lanzoExcepcion = true; // marco que la lanzó
		}

		assertTrue(lanzoExcepcion);
	}

	@Test
	void queSePuedaEntrenarUnaCriaturaSalvaje() throws EnergiaExcedidaException {
		Criatura nueva = new CriaturaSalvaje("salvaje", 90, "tierra");
		Integer energiaInicial = nueva.getNivelDeEnergia();
			
		nueva.entrenar(10);
		
		assertTrue(nueva.getNivelDeEnergia() >= energiaInicial + 10);
		assertTrue(nueva.getNivelDeEnergia() <= energiaInicial + 20);
	}

	@Test
	void queSePuedaEntrenarUnaCriaturaDomesticaDeFormaEstable() throws EnergiaExcedidaException {
		Criatura nueva = new CriaturaDomestica("salvaje", 90, "tierra");
		Integer energiaInicial = nueva.getNivelDeEnergia();

		nueva.entrenar(10);

		assertTrue(nueva.getNivelDeEnergia() >= energiaInicial + 10);
		assertTrue(nueva.getNivelDeEnergia() <= energiaInicial + 20);
	}
	
	@Test
	void queUnaCriaturaDomesticaNuncaSeaInestable() {
	    Criatura nueva = new CriaturaDomestica("domestica", 100, "agua");

	    nueva.esPacifico(true);  // aunque le pases "true", debería quedar estable

	    assertFalse(nueva.getInestable());
	}

}
