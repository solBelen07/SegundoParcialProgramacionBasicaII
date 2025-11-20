package ar.edu.unlam.pb2.parcial;

import java.util.ArrayList;
import java.util.List;

public class ReporteDelConsejo {

	private List<MaestroElemental> listaMaestros = new ArrayList<>();

	public ReporteDelConsejo(List<MaestroElemental> maestros) {
		this.listaMaestros = maestros;
	}

	// Listar todas las criaturas registradas por todos los maestros.
	public List<Criatura> getListaDeCriaturas() {
		List<Criatura> listaDeCriaturas = new ArrayList<>();
		for (MaestroElemental maestro : listaMaestros) {
			listaDeCriaturas.addAll(maestro.listarCriaturas().values());
			// addAll agrega a la lista de criaturas los valores del hashmap de la coleccion
			// de cada maestro
		}

		return listaDeCriaturas;
	}

	// Obtener la criatura con mayor energía total.
	public Criatura getCriaturaConMayorEnergia() {
		Criatura criaturaConMayorEnergia = null;

		for (Criatura criatura : getListaDeCriaturas()) {
			if (criaturaConMayorEnergia == null
					|| criaturaConMayorEnergia.getNivelDeEnergia() < criatura.getNivelDeEnergia())
				criaturaConMayorEnergia = criatura;
		}

		return criaturaConMayorEnergia;
	}
	
	// Determinar qué maestro tiene más criaturas transformadas.
	public MaestroElemental getMaestroConMasCriaturasTransformadas() {
		MaestroElemental maestroConMasTransformaciones = null; 
		
		Integer cantidad = 0;
		
		for (MaestroElemental maestro : listaMaestros) {
			cantidad = (maestro.contarCriaturasTransformadas());
		
		}
		
		return maestroConMasTransformaciones;
	}
}
