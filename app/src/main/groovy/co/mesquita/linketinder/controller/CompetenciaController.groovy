package co.mesquita.linketinder.controller

import co.mesquita.linketinder.model.dao.CompetenciaDAO
import co.mesquita.linketinder.model.entity.Competencia
import co.mesquita.linketinder.interfaces.IEntityController

import static co.mesquita.linketinder.view.View.askId
import static co.mesquita.linketinder.view.View.viewCompetencia

class CompetenciaController implements IEntityController {
    void create() {
        Competencia competencia = viewCompetencia()
        List<Competencia> competencias = CompetenciaDAO.listar()

        def isCreated = false
        for (int i = 0; i < competencias.size(); i++) {
            if (competencias.get(i).getNome() == competencia.getNome()) {
                println "Competencia já cadastrada"
                isCreated = true
                break
            }
        }
        if (!isCreated)
            CompetenciaDAO.inserir(competencia)
    }

    void list() {
        List<Competencia> competencias = CompetenciaDAO.listar()
        for (Competencia competencia : competencias)
            System.out.println(competencia)
    }

    void update() {
        int id = askId()
        Competencia competencia = viewCompetencia()
        CompetenciaDAO.alterar(competencia, id)
    }

    void delete() {
        int id = askId()
        CompetenciaDAO.remover(id)
    }
}
