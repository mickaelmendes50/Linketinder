package co.mesquita.linketinder.controller

import co.mesquita.linketinder.interfaces.IEntityController

import static co.mesquita.linketinder.utils.Constants.*

class ControllerFactory {
    static IEntityController getController(String controller) {
        if (controller.equals(CANDIDATO))
            return new CandidatoController()
        if (controller.equals(COMPETENCIA))
            return new CompetenciaController()
        if (controller.equals(VAGA))
            return new VagaController()
        if (controller.equals(EMPRESA))
            return new EmpresaController()
        return null
    }
}
