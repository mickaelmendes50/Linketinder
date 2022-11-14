package co.mesquita.linketinder.controller

import co.mesquita.linketinder.model.dao.EmpresaDAO
import co.mesquita.linketinder.model.entity.Empresa

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static co.mesquita.linketinder.view.View.*

@WebServlet(urlPatterns = "/empresas")
class EmpresaController extends HttpServlet {
    @Override
    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Empresa empresa = new Empresa();
        empresa.setName(request.getParameter("nome"))
        empresa.setDocumento(request.getParameter("cnpj"))
        empresa.setEmail(request.getParameter("email"))
        empresa.setDescription(request.getParameter("descricao"))
        empresa.setCountry(request.getParameter("pais"))
        empresa.setCep(request.getParameter("cep"))
        empresa.setSenha(request.getParameter("senha"))

        if (EmpresaDAO.inserir(empresa)) {
            PrintWriter out = response.getWriter();
            out.println(empresa + "\nInserida com sucesso!")
        }
    }

    @Override
    void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        List<Empresa> empresas = EmpresaDAO.listar()
        if (empresas) {
            for (empresa in empresas) {
                out.println(empresa.getId())
                out.println(empresa.getName())
            }
        }
    }

    void update() {
        int id = askId()
        Empresa empresa = viewEmpresa()
        EmpresaDAO.alterar(empresa, id)
    }

    void delete() {
        int id = askId()
        EmpresaDAO.remover(id)
    }
}
