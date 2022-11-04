package co.mesquita.linketinder.controller

import co.mesquita.linketinder.model.dao.CandidatoDAO
import co.mesquita.linketinder.model.dao.CandidatosCompetenciasDAO
import co.mesquita.linketinder.model.entity.Candidato
import co.mesquita.linketinder.interfaces.IEntityController

import static co.mesquita.linketinder.view.View.*

class CandidatoController implements IEntityController {
    void create() {
        Candidato candidato = viewCandidato()
        int new_id = CandidatoDAO.inserir(candidato)

        int id = 0
        while (id != -1) {
            println "Digite o ID da Competencia para o Candidato: (Para finalizar digite -1)"
            id = Integer.parseInt(System.in.newReader().readLine())
            if (id > 0) {
                boolean isCreated = CandidatosCompetenciasDAO.inserir(new_id, id)
                if (isCreated)
                    println "Adicionada com sucesso"
            }
        }
    }

    void list() {
        List<Candidato> candidatos = CandidatoDAO.listar()
        for (Candidato candidato : candidatos)
            System.out.println(candidato)
    }

    void update() {
        int id = askId()
        Candidato candidato = viewCandidato()
        CandidatoDAO.alterar(candidato, id)
    }

    void delete() {
        int id = askId()
        CandidatoDAO.remover(id)
    }
}
