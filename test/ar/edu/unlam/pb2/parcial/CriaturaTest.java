package ar.edu.unlam.pb2.parcial;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CriaturaTest {

	@Test
	public void queSePuedaCrearUnaCriatura() {
		Criatura nueva = new CriaturaSalvaje("salvaje", 90, "tierra");
		assertNotNull(nueva);
		assertTrue(nueva instanceof CriaturaSalvaje);
	}

	//
	@Test
	public void queLanceUnaExcepcionAlSuperarLos200DeEnrgia() {
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
	public void queSePuedaEntrenarUnaCriaturaSalvaje() throws EnergiaExcedidaException {
		Criatura nueva = new CriaturaSalvaje("salvaje", 90, "tierra");
		Integer energiaInicial = nueva.getNivelDeEnergia();

		nueva.entrenar(10);

		assertTrue(nueva.getNivelDeEnergia() >= energiaInicial + 10);
		assertTrue(nueva.getNivelDeEnergia() <= energiaInicial + 20);
	}

	@Test
	public void queSePuedaEntrenarUnaCriaturaDomesticaDeFormaEstable() throws EnergiaExcedidaException {
		Criatura nueva = new CriaturaDomestica("salvaje", 90, "tierra");
		Integer energiaInicial = nueva.getNivelDeEnergia();

		nueva.entrenar(10);

		assertTrue(nueva.getNivelDeEnergia() >= energiaInicial + 10);
		assertTrue(nueva.getNivelDeEnergia() <= energiaInicial + 20);
	}

	@Test
	public void queUnaCriaturaDomesticaNuncaSeaInestable() {
		Criatura nueva = new CriaturaDomestica("domestica", 100, "agua");

		nueva.esPacifico(true); // aunque le pases "true", debería quedar estable

		assertFalse(nueva.getInestable());
	}

}
