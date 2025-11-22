package ar.edu.unlam.pb2.parcial;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransformacionTest {

	@Test
	public void queSePuedaCrearUnaTransformacionBendicionDelRio() throws EnergiaExcedidaException {
		Criatura criatura = new CriaturaDomestica("Luna", 50, "AGUA");
		Transformacion transformacion = new BendicionDelRio(criatura);

		assertEquals(Integer.valueOf(100), transformacion.getNivelDeEnergia());

		transformacion.entrenar(10);
		assertTrue(transformacion.getNivelDeEnergia() >= 110);
	}

	@Test
	public void queSePuedaCrearUnaTransformacionLlamaInternaConAfinidadFuego() throws EnergiaExcedidaException {
		Criatura criatura = new CriaturaDomestica("Fenix", 50, "FUEGO");
		Transformacion transformacion = new LlamaInterna(criatura);

		assertEquals(Integer.valueOf(80), transformacion.getNivelDeEnergia());

		transformacion.entrenar(10);
		assertTrue(transformacion.getNivelDeEnergia() >= 90);
		assertFalse(transformacion.getInestable());
	}

	@Test
	public void queSePuedaCrearUnaTransformacionLlamaInternaConOtraAfinidad() throws EnergiaExcedidaException {
		Criatura criatura = new CriaturaDomestica("Luna", 50, "AGUA");
		Transformacion transformacion = new LlamaInterna(criatura);

		assertTrue(transformacion.getInestable());
	}

	@Test
	public void queSePuedaCrearUnaTransformacionVinculoTerrestreConEnergiaMenor() throws EnergiaExcedidaException {
		Criatura criatura = new CriaturaDomestica("Luna", 40, "TIERRA");
		Transformacion transformacion = new VinculoTerrestre(criatura);

		assertEquals(Integer.valueOf(50), transformacion.getNivelDeEnergia());

		transformacion.entrenar(5);
		assertTrue(transformacion.getNivelDeEnergia() >= 50);
	}

	@Test
	public void queSePuedaCrearUnaTransformacionAscensoDelViento() throws EnergiaExcedidaException {
		Criatura criatura = new CriaturaDomestica("Luna", 50, "AGUA");
		Transformacion transformacion = new AscensoDelViento(criatura);

		assertTrue(transformacion.getAfinidadElemental().contains("AIRE"));

		transformacion.entrenar(10);
		assertTrue(transformacion.getNivelDeEnergia() >= 60);
	}

	@Test
	public void queSePuedaEncadenarVariasTransformaciones() throws EnergiaExcedidaException {
		Criatura criatura = new CriaturaDomestica("Luna", 40, "AGUA");

		criatura = new BendicionDelRio(criatura);
		criatura = new LlamaInterna(criatura);
		criatura = new VinculoTerrestre(criatura);
		criatura = new AscensoDelViento(criatura);

		assertTrue(criatura.getNivelDeEnergia() >= 50);
		assertTrue(criatura.getAfinidadElemental().contains("AIRE"));
		assertTrue(criatura.getInestable());
	}

	@Test
	public void queUnaCriaturaPuedaRecibirVariasTransformaciones() throws EnergiaExcedidaException {
		Criatura criatura = new CriaturaDomestica("Luna", 40, "AGUA");

		criatura = new BendicionDelRio(criatura);
		criatura = new LlamaInterna(criatura);
		criatura = new VinculoTerrestre(criatura);
		criatura = new AscensoDelViento(criatura);

		criatura.entrenar(10);

		assertTrue(criatura.getNivelDeEnergia() >= 50);
		assertTrue(criatura.getAfinidadElemental().contains("AIRE"));
	}

	
}
