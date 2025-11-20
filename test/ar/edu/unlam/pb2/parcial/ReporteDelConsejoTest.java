package ar.edu.unlam.pb2.parcial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ReporteDelConsejoTest {
	
	

	@Test
	public void queSePuedanAgregarALaListaLasCriaturasDeLosMaestros() {
		MaestroElemental maestroUno = new MaestroElemental("Pablo", 300, "FUEGO");
		MaestroElemental maestroDos = new MaestroElemental("Lautaro", 200, "AIRE");

		Criatura criaturaUno = new CriaturaSalvaje("uno", 90, "AGUA");
		Criatura criaturaDos = new CriaturaDomestica("dos", 50, "FUEGO");
		Criatura criaturaTres = new CriaturaAncestral("tres", 100, "AIRE");
		Criatura criaturaCuatro = new CriaturaDomestica("cuatro", 20, "TIERRA");
		Criatura criaturaCinco = new CriaturaAncestral("cinco", 110, "TIERRA");
		Criatura criaturaSeis = new CriaturaSalvaje("seis", 70, "AGUA");

		maestroUno.agregarCriatura(criaturaUno);
		maestroDos.agregarCriatura(criaturaDos);
		maestroUno.agregarCriatura(criaturaTres);
		maestroDos.agregarCriatura(criaturaCuatro);
		maestroUno.agregarCriatura(criaturaCinco);
		maestroDos.agregarCriatura(criaturaSeis);

		List<MaestroElemental> maestros = new ArrayList<>();
		maestros.add(maestroUno);
		maestros.add(maestroDos);

		ReporteDelConsejo nuevoReporte = new ReporteDelConsejo(maestros);

		assertEquals(6, nuevoReporte.getListaDeCriaturas().size());
	}

	@Test
	public void queSePuedaVerLaCriaturaConMasEnergiaDeLosMaestros() {
		MaestroElemental maestroUno = new MaestroElemental("Pablo", 300, "FUEGO");
		MaestroElemental maestroDos = new MaestroElemental("Lautaro", 200, "AIRE");

		Criatura criaturaUno = new CriaturaSalvaje("uno", 90, "AGUA");
		Criatura criaturaDos = new CriaturaDomestica("dos", 50, "FUEGO");
		Criatura criaturaTres = new CriaturaAncestral("tres", 100, "AIRE");
		Criatura criaturaCuatro = new CriaturaDomestica("cuatro", 20, "TIERRA");
		Criatura criaturaCinco = new CriaturaAncestral("cinco", 110, "TIERRA");
		Criatura criaturaSeis = new CriaturaSalvaje("seis", 70, "AGUA");

		maestroUno.agregarCriatura(criaturaUno);
		maestroDos.agregarCriatura(criaturaDos);
		maestroUno.agregarCriatura(criaturaTres);
		maestroDos.agregarCriatura(criaturaCuatro);
		maestroUno.agregarCriatura(criaturaCinco);
		maestroDos.agregarCriatura(criaturaSeis);

		List<MaestroElemental> maestros = new ArrayList<>();
		maestros.add(maestroUno);
		maestros.add(maestroDos);

		ReporteDelConsejo nuevoReporte = new ReporteDelConsejo(maestros);

		assertEquals(criaturaCinco.getNombre(), nuevoReporte.getCriaturaConMayorEnergia().getNombre());
	}

	@Test
	public void queDevuelvaElMaestroConMasCriaturasTransformadas() {

		MaestroElemental maestroUno = new MaestroElemental("Pablo", 300, "FUEGO");
		MaestroElemental maestroDos = new MaestroElemental("Lautaro", 200, "AIRE");

		Criatura criaturaUno = new CriaturaDomestica("uno", 90, "FUEGO");
		Criatura criaturaDos = new CriaturaDomestica("dos", 50, "FUEGO");
		Criatura criaturaTres = new CriaturaDomestica("tres", 100, "AGUA");
		Criatura criaturaCuatro = new CriaturaDomestica("cuatro", 20, "TIERRA");

		maestroUno.agregarCriatura(criaturaUno);
		maestroUno.agregarCriatura(criaturaDos);
		maestroDos.agregarCriatura(criaturaTres);
		maestroDos.agregarCriatura(criaturaCuatro);

		maestroUno.transformarCriatura("uno", new BendicionDelRio(criaturaUno));
		maestroUno.transformarCriatura("dos", new LlamaInterna(criaturaDos));
		maestroDos.transformarCriatura("tres", new AscensoDelViento(criaturaTres));

		List<MaestroElemental> maestros = new ArrayList<>();
		maestros.add(maestroUno);
		maestros.add(maestroDos);

		ReporteDelConsejo reporte = new ReporteDelConsejo(maestros);

		assertEquals(maestroUno, reporte.getMaestroConMasCriaturasTransformadas());
	}

	@Test
	public void queSeCuenteCorrectamenteLaCantidadDeCriaturasPorAfinidad() {
		MaestroElemental maestroUno = new MaestroElemental("Pablo", 300, "AIRE");
		MaestroElemental maestroDos = new MaestroElemental("Lautaro", 200, "FUEGO");

		Criatura criaturaUno = new CriaturaSalvaje("uno", 90, "FUEGO");
		Criatura criaturaDos = new CriaturaDomestica("dos", 50, "FUEGO");
		Criatura criaturaTres = new CriaturaAncestral("tres", 100, "AGUA");
		Criatura criaturaCuatro = new CriaturaDomestica("cuatro", 20, "TIERRA");

		maestroUno.agregarCriatura(criaturaUno);
		maestroUno.agregarCriatura(criaturaTres);

		maestroDos.agregarCriatura(criaturaDos);
		maestroDos.agregarCriatura(criaturaCuatro);

		HashMap<String, Integer> mapa1 = maestroUno.cantidadPorAfinidad();
		HashMap<String, Integer> mapa2 = maestroDos.cantidadPorAfinidad();

		assertEquals(Integer.valueOf(1), mapa1.get("FUEGO"));
		assertEquals(Integer.valueOf(1), mapa1.get("AGUA"));

		assertEquals(Integer.valueOf(1), mapa2.get("FUEGO"));
		assertEquals(Integer.valueOf(1), mapa2.get("TIERRA"));
	}

	@Test
	public void queSumeCorrectamenteLasCriaturasConLaMismaAfinidadUsandoLosMismosNombres() {

		MaestroElemental maestroUno = new MaestroElemental("Pablo", 300, "FUEGO");

		Criatura criaturaUno = new CriaturaSalvaje("uno", 90, "AGUA");
		Criatura criaturaDos = new CriaturaDomestica("dos", 50, "AGUA");
		Criatura criaturaTres = new CriaturaAncestral("tres", 120, "AGUA");

		maestroUno.agregarCriatura(criaturaUno);
		maestroUno.agregarCriatura(criaturaDos);
		maestroUno.agregarCriatura(criaturaTres);

		HashMap<String, Integer> mapa = maestroUno.cantidadPorAfinidad();

		assertEquals(Integer.valueOf(3), mapa.get("AGUA"));
	}

	@Test
	public void queDevuelvaMapaVacioSiElMaestroNoTieneCriaturas() {

		MaestroElemental maestroVacio = new MaestroElemental("Lautaro", 200, "AIRE");

		HashMap<String, Integer> mapa = maestroVacio.cantidadPorAfinidad();

		assertTrue(mapa.isEmpty());
	}

	@Test
	public void queUnaCriaturaTransformadaSeCuentePorSuAfinidadOriginal() {

		MaestroElemental maestroUno = new MaestroElemental("Pablo", 300, "FUEGO");

		Criatura criaturaUno = new CriaturaDomestica("uno", 90, "FUEGO");
		maestroUno.agregarCriatura(criaturaUno);

		maestroUno.transformarCriatura("uno", new BendicionDelRio(criaturaUno));

		HashMap<String, Integer> mapa = maestroUno.cantidadPorAfinidad();

		assertEquals(Integer.valueOf(1), mapa.get("FUEGO"));
	}

	@Test
	public void queEntrenarCriaturaAumenteSuEnergia() throws MaestriaInsuficienteException, EnergiaExcedidaException {
		MaestroElemental maestroUno = new MaestroElemental("Pablo", 15, "FUEGO");

		Criatura criaturaUno = new CriaturaDomestica("uno", 50, "FUEGO");
		maestroUno.agregarCriatura(criaturaUno);

		maestroUno.entrenarCriatura("uno", 30);

		// VERIFICO QUE LA ENERGIA AUMENTO
		assertEquals(Integer.valueOf(110), criaturaUno.getNivelDeEnergia());
	}

	@Test(expected = MaestriaInsuficienteException.class)
	public void queEntrenarCriaturaConMaestriaBajaLanceExcepcion()
			throws MaestriaInsuficienteException, EnergiaExcedidaException {
		MaestroElemental maestroBajo = new MaestroElemental("Lautaro", 5, "AIRE");

		Criatura criaturaUno = new CriaturaDomestica("uno", 50, "FUEGO");
		maestroBajo.agregarCriatura(criaturaUno);

		maestroBajo.entrenarCriatura("uno", 20);
	}
//
	@Test
	public void quePacificarCriaturaLaVuelvaNoInestable() {
		MaestroElemental maestroUno = new MaestroElemental("Pablo", 15, "FUEGO");

		Criatura criaturaUno = new CriaturaDomestica("uno", 50, "FUEGO");
		criaturaUno.setInestable(true);
		maestroUno.agregarCriatura(criaturaUno);

		maestroUno.pacificarCriatura("uno");

		assertFalse(criaturaUno.getInestable());
	}

}