package ar.edu.unlam.pb2.parcial;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.edu.unlam.pb2.parcial.CriaturaSalvaje;
import ar.edu.unlam.pb2.parcial.EnergiaExcedidaException;

public class CriaturaTest {

	@Test
	public void queSePuedaCrearUnaCriatura() {
		Criatura nueva = new CriaturaSalvaje("salvaje", 90, "tierra");
		assertNotNull(nueva);
		assertTrue(nueva instanceof CriaturaSalvaje);
	}

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
	@Test
	public void queDosCriaturasConAfinidadIgualGanenEnergiaAlInteractuar() {
	    Criatura c1 = new CriaturaSalvaje("Roco", 100, "FUEGO");
	    Criatura c2 = new CriaturaDomestica("Luna", 80, "fuego");

	    Integer energiaInicial1 = c1.getNivelDeEnergia();
	    Integer energiaInicial2 = c2.getNivelDeEnergia();

	    c1.interactuar(c2);

	    assertTrue(c1.getNivelDeEnergia().equals(energiaInicial1 + 10));
	    assertTrue(c2.getNivelDeEnergia().equals(energiaInicial2 + 10));
	}
	@Test
	public void queDosCriaturasConAfinidadesOpuestasQuedenInestables() {
	    Criatura CriaturaAgua = new CriaturaSalvaje("Roco", 90, "AGUA");
	    Criatura CriaturaFuego = new CriaturaDomestica("Luna", 70, "FUEGO");

	    CriaturaAgua.interactuar(CriaturaFuego);

	    assertTrue(CriaturaAgua.getInestable());
	    assertTrue(CriaturaFuego.getInestable());
	}
	@Test
	public void queUnaCriaturaAncestralDomineLaSituacion() {
	    Criatura c1 = new CriaturaAncestral("Dragon", 150, "AIRE");
	    Criatura c2 = new CriaturaDomestica("Perro", 100, "TIERRA");

	    Integer energiaInicialAncestral = c1.getNivelDeEnergia();
	    Integer energiaInicialOtra = c2.getNivelDeEnergia();

	    c1.interactuar(c2);

	    assertTrue(c1.getNivelDeEnergia().equals(energiaInicialAncestral + 20));

	    assertTrue(c2.getNivelDeEnergia().equals(energiaInicialOtra - 15));
	}

	
	


}