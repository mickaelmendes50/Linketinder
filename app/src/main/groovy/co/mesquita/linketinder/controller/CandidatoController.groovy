package co.mesquita.linketinder.controller

import co.mesquita.linketinder.model.dao.CandidatoDAO
import co.mesquita.linketinder.model.dao.CandidatosCompetenciasDAO
import co.mesquita.linketinder.model.entity.Candidato

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static co.mesquita.linketinder.view.View.*

@WebServlet(urlPatterns = "/candidatos")
class CandidatoController extends HttpServlet {

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

    @Override
    void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        List<Candidato> candidatos = CandidatoDAO.listar()
        if (candidatos) {
            for (candidato in candidatos) {
                out.println(candidato.getName())
            }
        }
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
