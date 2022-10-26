package co.mesquita.linketinder.controller

import co.mesquita.linketinder.dao.CandidatoDAO
import co.mesquita.linketinder.dao.CandidatosCompetenciasDAO
import co.mesquita.linketinder.entity.Candidato

import static co.mesquita.linketinder.view.View.*

class CandidatoController {
    static void createCandidato() {
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

    static void listCandidatos() {
        List<Candidato> candidatos = CandidatoDAO.listar()
        for (Candidato candidato : candidatos)
            System.out.println(candidato)
    }

    static void updateCandidato() {
        print "Digite o ID do candidato: "
        int id = Integer.parseInt(System.in.newReader().readLine())

        Candidato candidato = viewCandidato()
        CandidatoDAO.alterar(candidato, id)
    }

    static void deleteCandidato() {
        print "Digite o ID do candidato: "
        int id = Integer.parseInt(System.in.newReader().readLine())

        CandidatoDAO.remover(id)
    }
}
