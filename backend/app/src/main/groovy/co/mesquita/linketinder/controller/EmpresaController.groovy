package co.mesquita.linketinder.controller

import co.mesquita.linketinder.dao.EmpresaDAO
import co.mesquita.linketinder.entity.Empresa
import co.mesquita.linketinder.interfaces.IEntityController

import static co.mesquita.linketinder.view.View.*

class EmpresaController implements IEntityController {
    void create() {
        Empresa empresa = viewEmpresa()
        EmpresaDAO.inserir(empresa)
    }

    void list() {
        List<Empresa> empresas = EmpresaDAO.listar()
        for (Empresa empresa : empresas)
            System.out.println(empresa)
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
