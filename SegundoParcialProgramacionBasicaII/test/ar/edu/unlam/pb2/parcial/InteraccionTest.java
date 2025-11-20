package ar.edu.unlam.pb2.parcial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InteraccionTest {

	@Test
	void queDosCriaturasConMismaAfinidadInteractuen() {
		Criatura nueva = new CriaturaSalvaje("salvaje", 90, "TIERRA");
		Criatura otra = new CriaturaDomestica("pikachu", 70, "TIERRA");
		Integer energiaInicialNueva = nueva.getNivelDeEnergia();
		Integer energiaInicialOtra = otra.getNivelDeEnergia();
		
		nueva.interactuar(otra);
		
		assertEquals(nueva.getNivelDeEnergia(), (energiaInicialNueva + 10));
		assertEquals(otra.getNivelDeEnergia(), (energiaInicialOtra + 10));
		
	}
	
	@Test
	void queDosCriaturasConDistintaAfinidadSeVuelvanInestables() {
		Criatura nueva = new CriaturaSalvaje("salvaje", 90, "TIERRA");
		Criatura otra = new CriaturaDomestica("pikachu", 70, "AIRE");
		
		nueva.interactuar(otra);
		
		assertEquals(nueva.getInestable(), true);
		assertEquals(otra.getInestable(), true);
		
	}
	
	@Test
	void queDosCriaturasConDistintaAfinidadSeVuelvanInestables2() {
		Criatura nueva = new CriaturaSalvaje("salvaje", 90, "Agua");
		Criatura otra = new CriaturaDomestica("pikachu", 70, "fuego");
		
		nueva.interactuar(otra);
		
		assertEquals(nueva.getInestable(), true);
		assertEquals(otra.getInestable(), true);
		//testeo que el toUpperCase funcione
	}
	
	@Test
	void queDosCriaturasInteractuenSiendoLaPrimeraAncestral() {
		Criatura nueva = new CriaturaAncestral("salvaje", 90, "Agua");
		Criatura otra = new CriaturaDomestica("pikachu", 70, "fuego");
		
		Integer energiaInicialNueva = nueva.getNivelDeEnergia();
		Integer energiaInicialOtra = otra.getNivelDeEnergia();
		
		nueva.interactuar(otra);
		
		assertEquals(nueva.getNivelDeEnergia(), (energiaInicialNueva + 20));
		assertEquals(otra.getNivelDeEnergia(), (energiaInicialOtra - 15));
	}
	
	@Test
	void queDosCriaturasInteractuenSiendoLaSegundaAncestral() {
		Criatura nueva = new CriaturaDomestica("salvaje", 90, "Agua");
		Criatura otra = new CriaturaAncestral("pikachu", 70, "fuego");
		
		Integer energiaInicialNueva = nueva.getNivelDeEnergia();
		Integer energiaInicialOtra = otra.getNivelDeEnergia();
		
		nueva.interactuar(otra);
		
		assertEquals(otra.getNivelDeEnergia(), (energiaInicialOtra + 20));
		assertEquals(nueva.getNivelDeEnergia(), (energiaInicialNueva - 15));
	}
	
	@Test
	void queDosCriaturasInteractuenUnaSiendoAncestralYAdemasSiendoIncompatibles() {
		Criatura nueva = new CriaturaAncestral("salvaje", 90, "Agua");
		Criatura otra = new CriaturaDomestica("pikachu", 70, "fuego");
		
		Integer energiaInicialNueva = nueva.getNivelDeEnergia();
		Integer energiaInicialOtra = otra.getNivelDeEnergia();
		
		nueva.interactuar(otra);
		
		assertEquals(nueva.getNivelDeEnergia(), (energiaInicialNueva + 20));
		assertEquals(otra.getNivelDeEnergia(), (energiaInicialOtra - 15));
		
		assertEquals(nueva.getInestable(), true);
		assertEquals(otra.getInestable(), true);
	}
}
