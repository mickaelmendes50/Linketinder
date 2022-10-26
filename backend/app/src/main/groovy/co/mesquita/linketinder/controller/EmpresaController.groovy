package co.mesquita.linketinder.controller

import co.mesquita.linketinder.dao.EmpresaDAO
import co.mesquita.linketinder.entity.Empresa

import static co.mesquita.linketinder.view.View.*

class EmpresaController {
    static void createEmpresa() {
        Empresa empresa = viewEmpresa()
        EmpresaDAO.inserir(empresa)
    }

    static void listEmpresas() {
        List<Empresa> empresas = EmpresaDAO.listar()
        for (Empresa empresa : empresas)
            System.out.println(empresa)
    }

    static void updateEmpresa() {
        print "Digite o ID da empresa: "
        int id = Integer.parseInt(System.in.newReader().readLine())

        Empresa empresa = viewEmpresa()
        EmpresaDAO.alterar(empresa, id)
    }

    static void deleteEmpresa() {
        print "Digite o ID da empresa: "
        int id = Integer.parseInt(System.in.newReader().readLine())

        EmpresaDAO.remover(id)
    }
}
