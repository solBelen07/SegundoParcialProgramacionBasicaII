package ar.edu.unlam.pb2.parcial;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class InteraccionTest {

	@Test
	public void queDosCriaturasConMismaAfinidadInteractuen() {
		Criatura nueva = new CriaturaSalvaje("salvaje", 90, "TIERRA");
		Criatura otra = new CriaturaDomestica("pikachu", 70, "TIERRA");
		Integer energiaInicialNueva = nueva.getNivelDeEnergia();
		Integer energiaInicialOtra = otra.getNivelDeEnergia();
		
		nueva.interactuar(otra);
		
		assertEquals(nueva.getNivelDeEnergia(), (energiaInicialNueva + 10), 0);
		assertEquals(otra.getNivelDeEnergia(), (energiaInicialOtra + 10), 0);
		
	}
	
	@Test
	public void queDosCriaturasConDistintaAfinidadSeVuelvanInestables() {
		Criatura nueva = new CriaturaSalvaje("salvaje", 90, "TIERRA");
		Criatura otra = new CriaturaDomestica("pikachu", 70, "AIRE");
		
		nueva.interactuar(otra);
		
		assertEquals(nueva.getInestable(), true);
		assertEquals(otra.getInestable(), true);
		
	}
	
	@Test
	public void queDosCriaturasConDistintaAfinidadSeVuelvanInestables2() {
		Criatura nueva = new CriaturaSalvaje("salvaje", 90, "Agua");
		Criatura otra = new CriaturaDomestica("pikachu", 70, "fuego");
		
		nueva.interactuar(otra);
		
		assertEquals(nueva.getInestable(), true);
		assertEquals(otra.getInestable(), true);
		//testeo que el toUpperCase funcione
	}
	
	@Test
	public void queDosCriaturasInteractuenSiendoLaPrimeraAncestral() {
		Criatura nueva = new CriaturaAncestral("salvaje", 90, "Agua");
		Criatura otra = new CriaturaDomestica("pikachu", 70, "fuego");
		
		Integer energiaInicialNueva = nueva.getNivelDeEnergia();
		Integer energiaInicialOtra = otra.getNivelDeEnergia();
		
		nueva.interactuar(otra);
		
		assertEquals(nueva.getNivelDeEnergia(), (energiaInicialNueva + 20), 0);
		assertEquals(otra.getNivelDeEnergia(), (energiaInicialOtra - 15), 0);
	}
	
	@Test
	public void queDosCriaturasInteractuenSiendoLaSegundaAncestral() {
		Criatura nueva = new CriaturaDomestica("salvaje", 90, "Agua");
		Criatura otra = new CriaturaAncestral("pikachu", 70, "fuego");
		
		Integer energiaInicialNueva = nueva.getNivelDeEnergia();
		Integer energiaInicialOtra = otra.getNivelDeEnergia();
		
		nueva.interactuar(otra);
		
		assertEquals(otra.getNivelDeEnergia(), (energiaInicialOtra + 20), 0);
		assertEquals(nueva.getNivelDeEnergia(), (energiaInicialNueva - 15), 0);
	}
	
	@Test
	public void queDosCriaturasInteractuenUnaSiendoAncestralYAdemasSiendoIncompatibles() {
		Criatura nueva = new CriaturaAncestral("salvaje", 90, "Tierra");
		Criatura otra = new CriaturaDomestica("pikachu", 70, "Aire");
		
		Integer energiaInicialNueva = nueva.getNivelDeEnergia();
		Integer energiaInicialOtra = otra.getNivelDeEnergia();
		
		nueva.interactuar(otra);
		
		assertEquals(nueva.getNivelDeEnergia(), (energiaInicialNueva + 20), 0);
		assertEquals(otra.getNivelDeEnergia(), (energiaInicialOtra - 15), 0);
		
		assertEquals(nueva.getInestable(), true);
		assertEquals(otra.getInestable(), true);
	}
}
