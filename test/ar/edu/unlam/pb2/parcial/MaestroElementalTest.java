package ar.edu.unlam.pb2.parcial;

import org.junit.Test;

import ar.edu.unlam.pb2.Criatura;
import ar.edu.unlam.pb2.CriaturaDomestica;
import ar.edu.unlam.pb2.CriaturaSalvaje;
import ar.edu.unlam.pb2.EnergiaExcedidaException;
import ar.edu.unlam.pb2.MaestriaInsuficienteException;
import ar.edu.unlam.pb2.MaestroElemental;
import ar.edu.unlam.pb2.Transformacion;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
public class MaestroElementalTest {
	

	private MaestroElemental maestro;
    private CriaturaSalvaje salvaje;
    private CriaturaDomestica domestica;

    @Before
    public void setUp() {
        maestro = new MaestroElemental("Gandalf", 20, "FUEGO");
        salvaje = new CriaturaSalvaje("Roco", 90, "TIERRA");
        domestica = new CriaturaDomestica("Luna", 50, "AGUA");
        maestro.agregarCriatura(salvaje);
        maestro.agregarCriatura(domestica);
    }

    @Test
    public void testEntrenarCriaturaConMaestriaSuficiente() throws MaestriaInsuficienteException, EnergiaExcedidaException {
        Integer energiaInicial = salvaje.getNivelDeEnergia();
        maestro.entrenarCriatura("Roco", 10);
        assertTrue(salvaje.getNivelDeEnergia() >= energiaInicial + 10);
        assertTrue(salvaje.getNivelDeEnergia() <= energiaInicial + 20);
    }

    @Test
    public void testEntrenarCriaturaConMaestriaInsuficiente() {
        MaestroElemental maestroDebil = new MaestroElemental("Novato", 5, "AGUA");
        maestroDebil.agregarCriatura(salvaje);
        salvaje.setNivelDeEnergia(50);

        try {
            maestroDebil.entrenarCriatura("Roco", 10);
            fail("Se esperaba MaestriaInsuficienteException");
        } catch (MaestriaInsuficienteException e) {
            
        } catch (EnergiaExcedidaException e) {
            fail("No se esperaba EnergiaExcedidaException");
        }
    }

    @Test
    public void testPacificarCriaturaExistente() {
        salvaje.setInestable(true);
        maestro.pacificarCriatura("Roco");
        assertEquals(Boolean.FALSE, salvaje.getInestable());

        domestica.setInestable(true);
        maestro.pacificarCriatura("Luna");
        assertEquals(Boolean.FALSE, domestica.getInestable()); 
    }

    @Test
    public void testTransformarCriaturaExistente() throws MaestriaInsuficienteException, EnergiaExcedidaException {
        Transformacion transformacion = new Transformacion(domestica) {
            @Override
            public void entrenar(Integer intensidad) throws EnergiaExcedidaException {
                criaturaBase.entrenar(intensidad);
                criaturaBase.setNivelDeEnergia(criaturaBase.getNivelDeEnergia() + 50);
            }
        };

        maestro.transformarCriatura("Luna", transformacion);
        maestro.entrenarCriatura("Luna", 10);
        assertEquals(Integer.valueOf(110), maestro.listarCriaturas().get("Luna").getNivelDeEnergia());
    }

    @Test
    public void testCriaturaConMayorEnergia() {
        assertEquals(salvaje, maestro.criaturaConMayorEnergia());
    }

    @Test
    public void testContarCriaturasTransformadas() {
        Transformacion transformacion = new Transformacion(domestica) {
            @Override
            public void entrenar(Integer intensidad) {
                criaturaBase.setNivelDeEnergia(criaturaBase.getNivelDeEnergia() + 10);
            }
        };
        maestro.transformarCriatura("Luna", transformacion);
        assertEquals(Integer.valueOf(1), maestro.contarCriaturasTransformadas());
    }

    @Test
    public void testCantidadPorAfinidad() {
        HashMap<String, Integer> mapa = maestro.cantidadPorAfinidad();
        assertEquals(Integer.valueOf(1), mapa.get("TIERRA"));
        assertEquals(Integer.valueOf(1), mapa.get("AGUA"));
    }

    @Test
    public void testListarCriaturas() {
        HashMap<String, Criatura> lista = maestro.listarCriaturas();
        assertTrue(lista.containsKey("Roco"));
        assertTrue(lista.containsKey("Luna"));
    }
}


