package co.mesquita.linketinder.controller

import co.mesquita.linketinder.dao.CompetenciaDAO
import co.mesquita.linketinder.entity.Competencia

import static co.mesquita.linketinder.view.View.viewCompetencia

class CompetenciaController {
    static void createCompetencia() {
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

    static void listCompetencias() {
        List<Competencia> competencias = CompetenciaDAO.listar()
        for (Competencia competencia : competencias)
            System.out.println(competencia)
    }

    static void updateCompetencia() {
        print "Digite o ID da competencia: "
        int id = Integer.parseInt(System.in.newReader().readLine())

        Competencia competencia = viewCompetencia()
        CompetenciaDAO.alterar(competencia, id)
    }

    static void deleteCompetencia() {
        print "Digite o ID da competencia: "
        int id = Integer.parseInt(System.in.newReader().readLine())

        CompetenciaDAO.remover(id)
    }
}
