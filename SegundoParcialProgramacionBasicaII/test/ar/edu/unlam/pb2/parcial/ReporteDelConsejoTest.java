package ar.edu.unlam.pb2.parcial;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

class ReporteDelConsejoTest {

	@Test
	void queSePuedanAgregarALaListaLasCriaturasDeLosMaestros() {
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
	void queSePuedanVerLaCriaturaConMasEnergiaDeLosMaestros() {
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
	
	
}
