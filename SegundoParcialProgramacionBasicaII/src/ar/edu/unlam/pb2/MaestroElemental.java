package ar.edu.unlam.pb2;

import java.util.HashMap;

public class MaestroElemental {
	String nombre;
	Integer nivelMaestria; 
	String afinidadPrincipal;
	HashMap<String, Criatura> criaturasACargo = new HashMap<>();
	
	public MaestroElemental(String nombre, Integer nivelMaestria, String afinidadPrincipal) {
        this.nombre = nombre;
        this.nivelMaestria = nivelMaestria;
        this.afinidadPrincipal = afinidadPrincipal;
        this.criaturasACargo = new HashMap<>();
    }

    public void agregarCriatura(Criatura criatura) {
        criaturasACargo.put(criatura.getNombre(), criatura);
    }

    public void entrenarCriatura(String nombreCriatura, Integer intensidad) throws MaestriaInsuficienteException, EnergiaExcedidaException {
        if (nivelMaestria < 10) { // nivel mínimo para entrenar
            throw new MaestriaInsuficienteException("Nivel de maestría insuficiente para entrenar la criatura.");
        }
        

        Criatura criatura = criaturasACargo.get(nombreCriatura);
        if (criatura != null) {
            criatura.entrenar(intensidad);
        }
    }

    public void pacificarCriatura(String nombreCriatura) {
        Criatura criatura = criaturasACargo.get(nombreCriatura);
        if (criatura != null) {
            criatura.esPacifico(false); 
        }
    }

    public void transformarCriatura(String nombreCriatura, Transformacion transformacion) {
        Criatura criatura = criaturasACargo.get(nombreCriatura);
        if (criatura != null) {
            transformacion.setCriaturaBase(criatura);
            criaturasACargo.put(nombreCriatura, transformacion);
        }
    }


    public HashMap<String, Criatura> listarCriaturas() {
        return criaturasACargo;
    }

    public Criatura criaturaConMayorEnergia() {
        Criatura mayor = null;
        for (Criatura c : criaturasACargo.values()) {
            if (mayor == null || c.getNivelDeEnergia() > mayor.getNivelDeEnergia()) {
                mayor = c;
            }
        }
        return mayor;
    }

    public Integer contarCriaturasTransformadas() {
       Integer contador = 0;
        for (Criatura criatura : criaturasACargo.values()) {
            if (criatura instanceof Transformacion) {
                contador++;
            }
        }
        return contador;
    }

    public HashMap<String, Integer> cantidadPorAfinidad() {
        HashMap<String, Integer> mapa = new HashMap<>();
        for (Criatura criatura : criaturasACargo.values()) {
            String afinidad = criatura.getAfinidadElemental();
            mapa.put(afinidad, mapa.getOrDefault(afinidad, 0) + 1);
        }
        return mapa;
    }

    // 
    public String getNombre() {
        return nombre;
    }

    public Integer getNivelMaestria() {
        return nivelMaestria;
    }

    public String getAfinidadPrincipal() {
        return afinidadPrincipal;
    }


}
