package co.mesquita.linketinder.controller

import co.mesquita.linketinder.dao.VagaDAO
import co.mesquita.linketinder.dao.VagasCompetenciasDAO
import co.mesquita.linketinder.entity.Vaga

import static co.mesquita.linketinder.view.View.viewVaga

class VagaController {
    static void createVaga() {
        Vaga vaga = viewVaga()
        int new_id = VagaDAO.inserir(vaga)

        int id = 0
        while (id != -1) {
            println "Digite o ID da Competencia para a vaga: (Para finalizar digite -1)"
            id = Integer.parseInt(System.in.newReader().readLine())
            if (id > 0) {
                boolean isCreated = VagasCompetenciasDAO.inserir(new_id, id)
                if (isCreated)
                    println "Adicionada com sucesso"
            }
        }
    }

    static void listVagas() {
        List<Vaga> vagas = VagaDAO.listar()
        for (Vaga vaga : vagas)
            System.out.println(vaga)
    }

    static void updateVaga() {
        print "Digite o ID da vaga: "
        int id = Integer.parseInt(System.in.newReader().readLine())

        Vaga vaga = viewVaga()
        VagaDAO.alterar(vaga, id)
    }

    static void deleteVaga() {
        print "Digite o ID da vaga: "
        int id = Integer.parseInt(System.in.newReader().readLine())

        VagaDAO.remover(id)
    }
}
