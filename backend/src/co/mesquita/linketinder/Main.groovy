package co.mesquita.linketinder

import co.mesquita.linketinder.dao.CandidatoDAO
import co.mesquita.linketinder.dao.EmpresaDAO
import co.mesquita.linketinder.dao.VagaDAO

import static co.mesquita.linketinder.crud.Create.*
import co.mesquita.linketinder.entity.*

static void main(args) {

    def printMenu = {
        println "------------------------------"
        println "-- Bem vindo ao Linketinder --"
        println "------------------------------"
        println "1. Listar empresas"
        println "2. Listar candidatos"
        println "3. Adicionar empresa"
        println "4. Adicionar candidado"
        println "5. Atualizar empresa"
        println "6. Atualizar candidato"
        println "7. Deletar empresa"
        println "8. Deletar candidato"
        println "9. Listar vagas"
        println "0. Sair"
    }

    def printCandidato = {
        println "------------------------------"
        println "-- Bem vindo ao Linketinder --"
        println "------------------------------"
        println "1. Listar candidatos"
        println "2. Adicionar candidado"
        println "3. Atualizar candidato"
        println "4. Deletar candidato"
        println "0. Sair"
    }

    def printEmpresa = {
        println "------------------------------"
        println "-- Bem vindo ao Linketinder --"
        println "------------------------------"
        println "1. Listar empresas"
        println "2. Adicionar empresa"
        println "3. Atualizar empresa"
        println "4. Deletar empresa"
        println "0. Sair"
    }

    def printVaga = {
        println "------------------------------"
        println "-- Bem vindo ao Linketinder --"
        println "------------------------------"
        println "1. Listar vagas"
        println "2. Adicionar vaga"
        println "3. Atualizar vaga"
        println "4. Deletar vaga"
        println "0. Sair"
    }
    
    def option = -1
    do {
        printMenu()
        option = System.in.newReader().readLine() as Integer
        switch(option) {
            case 1:
                EmpresaDAO empresaDAO = new EmpresaDAO();
                List<Empresa> lista = empresaDAO.listar();
                for (Empresa empresa : lista)
                    System.out.println(empresa);
                break
            case 2:
                CandidatoDAO candidatoDAO = new CandidatoDAO();
                List<Candidato> lista = candidatoDAO.listar();
                for (Candidato candidato : lista)
                    System.out.println(candidato);
                break
            case 3:
                Empresa empresa = createEmpresa()
                EmpresaDAO empresaDAO = new EmpresaDAO();
                empresaDAO.inserir(empresa);
                break
            case 4:
                Candidato candidato = createCandidato()
                CandidatoDAO candidatoDAO = new CandidatoDAO();
                candidatoDAO.inserir(candidato);
                break
            case 5:
                print "Digite o ID da empresa: "
                int id = Integer.parseInt(System.in.newReader().readLine())

                Empresa empresa = createEmpresa()
                EmpresaDAO empresaDAO = new EmpresaDAO();
                empresaDAO.alterar(empresa, id);
                break
            case 6:
                print "Digite o ID do candidato: "
                int id = Integer.parseInt(System.in.newReader().readLine())

                Candidato candidato = createCandidato()
                CandidatoDAO candidatoDAO = new CandidatoDAO();
                candidatoDAO.alterar(candidato, id);
                break
            case 7:
                print "Digite o ID da empresa: "
                int id = Integer.parseInt(System.in.newReader().readLine())

                EmpresaDAO empresaDAO = new EmpresaDAO();
                empresaDAO.remover(id);
                break
            case 8:
                print "Digite o ID do candidato: "
                int id = Integer.parseInt(System.in.newReader().readLine())

                CandidatoDAO candidatoDAO = new CandidatoDAO();
                candidatoDAO.remover(id);
                break
            case 9:
                VagaDAO vagaDAO = new VagaDAO();
                List<Vaga> lista = vagaDAO.listar();
                for (Vaga vaga : lista)
                    System.out.println(vaga);
                break
            case 0:
                break
            default:
                println "Opção inválida!"
        }
    } while (option != 0)
}
