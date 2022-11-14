package co.mesquita.linketinder.controller

import co.mesquita.linketinder.model.dao.CandidatoDAO
import co.mesquita.linketinder.model.entity.Candidato

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static co.mesquita.linketinder.view.View.*

@WebServlet(urlPatterns = "/candidatos")
class CandidatoController extends HttpServlet {

    @Override
    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Candidato candidato = new Candidato()
        candidato.setName(request.getParameter("nome"))
        candidato.setSobrenome(request.getParameter("sobrenome"))
        candidato.setDocumento(request.getParameter("cpf"))
        candidato.setNascimento(request.getParameter("nascimento"))
        candidato.setEmail(request.getParameter("email"))
        candidato.setSenha(request.getParameter("senha"))
        candidato.setEstate(request.getParameter("estado"))
        candidato.setCep(request.getParameter("cep"))
        candidato.setDescription(request.getParameter("descricao"))

        if (CandidatoDAO.inserir(candidato) != -1){
            PrintWriter out = response.getWriter();
            out.println("Inserido com sucesso!")
        }
    }

    @Override
    void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        List<Candidato> candidatos = CandidatoDAO.listar()
        if (candidatos) {
            for (candidato in candidatos) {
                out.println(candidato.getId() + ". " + candidato.getName())
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
