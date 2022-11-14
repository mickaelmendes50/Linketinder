package co.mesquita.linketinder.controller

import co.mesquita.linketinder.model.dao.VagaDAO
import co.mesquita.linketinder.model.entity.Vaga

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static co.mesquita.linketinder.view.View.askId
import static co.mesquita.linketinder.view.View.viewVaga

@WebServlet(urlPatterns = "/vagas")
class VagaController extends HttpServlet {
    @Override
    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idempresa = Integer.parseInt(request.getParameter("idempresa"))
        Vaga vaga = new Vaga(idempresa, request.getParameter("nome"), request.getParameter("descricao"), request.getParameter("local"))

        if (VagaDAO.inserir(vaga) != -1){
            PrintWriter out = response.getWriter();
            out.println("\nInserida com sucesso!")
        }
    }

    @Override
    void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        List<Vaga> vagas = VagaDAO.listar()
        if (vagas) {
            for (vaga in vagas) {
                out.println(vaga.getId() + ". " + vaga.getNome())
            }
        }
    }

    void update() {
        int id = askId()
        Vaga vaga = viewVaga()
        VagaDAO.alterar(vaga, id)
    }

    void delete() {
        int id = askId()
        VagaDAO.remover(id)
    }
}
