package ar.edu.unlam.pb2.parcial;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TransformacionTest {

	private CriaturaSalvaje criaturaUNO;
	private CriaturaDomestica criaturaDos;
	private CriaturaAncestral criaturaTres;

	@Before
	public void setup() {
		criaturaUNO = new CriaturaSalvaje("criaturaUNO", 100, "AGUA");
		criaturaDos = new CriaturaDomestica("criaturaDos", 120, "FUEGO");
		criaturaTres = new CriaturaAncestral("criaturaTres", 40, "TIERRA");
	}

	@Test
	public void bendicionDelRioDuplicaEnergiaPeroNoSupera180() {
		BendicionDelRio bendicion = new BendicionDelRio(criaturaUNO);
		assertEquals(Integer.valueOf(180), bendicion.getNivelDeEnergia());
		assertEquals(Integer.valueOf(180), criaturaUNO.getNivelDeEnergia());
	}

	@Test
	public void llamaInternaAumentaEnergiaSiEsFuego() {
		LlamaInterna llama = new LlamaInterna(criaturaDos);
		assertEquals(Integer.valueOf(150), llama.getNivelDeEnergia());
		assertEquals(Integer.valueOf(150), criaturaDos.getNivelDeEnergia());
		assertFalse(llama.getInestable());
	}

	@Test
	public void llamaInternaVuelveInestableSiNoEsFuego() {
		LlamaInterna llama = new LlamaInterna(criaturaUNO);
		assertTrue(llama.getInestable());
		assertTrue(criaturaUNO.getInestable());
	}

	@Test
	public void vinculoTerrestreNoPermiteEnergiaMenor50() {
		VinculoTerrestre vinculo = new VinculoTerrestre(criaturaTres);
		assertEquals(Integer.valueOf(50), vinculo.getNivelDeEnergia());
		assertEquals(Integer.valueOf(50), criaturaTres.getNivelDeEnergia());
	}

	@Test
	public void ascensoDelVientoAgregaAfinidadAIRE() {
		AscensoDelViento ascenso = new AscensoDelViento(criaturaUNO);
		assertTrue(ascenso.getAfinidadElemental().contains("AIRE"));
		assertTrue(criaturaUNO.getAfinidadElemental().contains("AIRE"));
		assertEquals("criaturaUNO", ascenso.getNombre());
		assertEquals(criaturaUNO.getNivelDeEnergia(), ascenso.getNivelDeEnergia());
	}

	@Test
	public void transformacionesReflejanEstadoDeCriaturaBase() {
		BendicionDelRio bendicion = new BendicionDelRio(criaturaDos);
		assertEquals(criaturaDos.getNombre(), bendicion.getNombre());
		assertEquals(criaturaDos.getNivelDeEnergia(), bendicion.getNivelDeEnergia());

		criaturaDos.setInestable(true);
		assertTrue(bendicion.getInestable());

		bendicion.esPacifico(false);
		assertFalse(bendicion.getInestable());
		assertFalse(criaturaDos.getInestable());
	}

	@Test
	public void transformacionesAcumuladasReflejanCambiosCorrectamente() {
		BendicionDelRio bendicion = new BendicionDelRio(criaturaUNO);
		AscensoDelViento ascenso = new AscensoDelViento(bendicion);

		assertEquals(Integer.valueOf(200 > 180 ? 180 : 200), ascenso.getNivelDeEnergia());
		assertTrue(ascenso.getAfinidadElemental().contains("AIRE"));
		assertEquals("criaturaUNO", ascenso.getNombre());
	}

	@Test
	public void multiplesTransformacionesConLlamaInternaPropaganInestable() {
		BendicionDelRio bendicion = new BendicionDelRio(criaturaUNO);
		LlamaInterna llama = new LlamaInterna(bendicion);

		assertTrue(llama.getInestable());
		assertTrue(criaturaUNO.getInestable());
		assertEquals(Integer.valueOf(180), llama.getNivelDeEnergia());
	}

	@Test
	public void entrenarTransformacionesAumentaEnergiaSegunBase() throws EnergiaExcedidaException {
		BendicionDelRio bendicion = new BendicionDelRio(criaturaDos);
		bendicion.entrenar(10);

		assertEquals(Integer.valueOf(190), bendicion.getNivelDeEnergia());
		assertEquals(criaturaDos.getNivelDeEnergia(), bendicion.getNivelDeEnergia());
	}

	@Test
	public void vinculoTerrestreNoBajaDe50InclusoConEntrenarNegativo() throws EnergiaExcedidaException {
		VinculoTerrestre vinculo = new VinculoTerrestre(criaturaTres);
		vinculo.entrenar(-20);

		assertEquals(Integer.valueOf(50), vinculo.getNivelDeEnergia());
	}

	@Test
	public void ascensoDelVientoMantieneNombreYEnergia() throws EnergiaExcedidaException {
		AscensoDelViento ascenso = new AscensoDelViento(criaturaDos);
		ascenso.entrenar(30);
		assertEquals("criaturaDos", ascenso.getNombre());
		assertEquals(criaturaDos.getNivelDeEnergia(), ascenso.getNivelDeEnergia());
	}
//
}
