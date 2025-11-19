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
	void queSePuedaEntrenarUnaCriatura() {
		Criatura nueva = new CriaturaSalvaje("salvaje", 90, "tierra");
		Integer energiaInicial = nueva.getNivelDeEnergia();
		nueva.entrenar(10); 
		    
		assertTrue(nueva.getNivelDeEnergia() >= energiaInicial + 10);  
		assertTrue(nueva.getNivelDeEnergia() <= energiaInicial + 20);
	}

}
