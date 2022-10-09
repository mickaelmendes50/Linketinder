package co.mesquita.linketinder

import co.mesquita.linketinder.dao.CandidatoDAO
import co.mesquita.linketinder.dao.CompetenciaDAO
import co.mesquita.linketinder.dao.EmpresaDAO
import co.mesquita.linketinder.dao.VagaDAO
import co.mesquita.linketinder.dao.VagasCompetenciasDAO

import static co.mesquita.linketinder.crud.Create.*
import co.mesquita.linketinder.entity.*

static void main(args) {

    def printMenu = {
        println "------------------------------"
        println "-- Bem vindo ao Linketinder --"
        println "------------------------------"
        println "1. Listar empresas"
        println "2. Listar candidatos"
        println "3. Listar vagas"
        println "4. Listar competencias"
        println "5. Adicionar empresa"
        println "6. Adicionar candidado"
        println "7. Adicionar vaga"
        println "8. Adicionar competencia"
        println "9. Atualizar empresa"
        println "10. Atualizar candidato"
        println "11. Atualizar vaga"
        println "12. Atualizar competencia"
        println "13. Deletar empresa"
        println "14. Deletar candidato"
        println "15. Deletar vaga"
        println "16. Deletar competencia"
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
                VagaDAO vagaDAO = new VagaDAO();
                List<Vaga> lista = vagaDAO.listar();
                for (Vaga vaga : lista)
                    System.out.println(vaga);
                break
            case 4:
                CompetenciaDAO competenciaDAO = new CompetenciaDAO();
                List<Competencia> lista = competenciaDAO.listar();
                for (Competencia competencia : lista)
                    System.out.println(competencia);
                break

            case 5:
                Empresa empresa = createEmpresa()
                EmpresaDAO empresaDAO = new EmpresaDAO();
                empresaDAO.inserir(empresa);
                break
            case 6:
                Candidato candidato = createCandidato()
                CandidatoDAO candidatoDAO = new CandidatoDAO();
                candidatoDAO.inserir(candidato);
                break
            case 7:
                Vaga vaga = createVaga()
                VagaDAO vagaDAO = new VagaDAO();
                int new_id = vagaDAO.inserir(vaga);

                VagasCompetenciasDAO vcDAO = new VagasCompetenciasDAO()
                int id = 0
                while (id != -1) {
                    println "Digite o ID da Competencia para a vaga: (Para finalizar digite -1)"
                    id = Integer.parseInt(System.in.newReader().readLine())
                    if (id > 0) {
                        boolean tmp = vcDAO.inserir(new_id, id)
                        if (tmp) println "Adicionada com sucesso"
                    }
                }

                break
            case 8:
                Competencia competencia = createCompetencia()
                CompetenciaDAO competenciaDAO = new CompetenciaDAO();
                competenciaDAO.inserir(competencia);
                break
            case 9:
                print "Digite o ID da empresa: "
                int id = Integer.parseInt(System.in.newReader().readLine())

                Empresa empresa = createEmpresa()
                EmpresaDAO empresaDAO = new EmpresaDAO();
                empresaDAO.alterar(empresa, id);
                break
            case 10:
                print "Digite o ID do candidato: "
                int id = Integer.parseInt(System.in.newReader().readLine())

                Candidato candidato = createCandidato()
                CandidatoDAO candidatoDAO = new CandidatoDAO();
                candidatoDAO.alterar(candidato, id);
                break
            case 11:
                print "Digite o ID da vaga: "
                int id = Integer.parseInt(System.in.newReader().readLine())

                Vaga vaga = createVaga()
                VagaDAO vagaDAO = new VagaDAO();
                vagaDAO.alterar(vaga, id);
                break
            case 12:
                print "Digite o ID da competencia: "
                int id = Integer.parseInt(System.in.newReader().readLine())

                Competencia competencia = createCompetencia()
                CompetenciaDAO competenciaDAO = new CompetenciaDAO();
                competenciaDAO.alterar(competencia, id);
                break
            case 13:
                print "Digite o ID da empresa: "
                int id = Integer.parseInt(System.in.newReader().readLine())

                EmpresaDAO empresaDAO = new EmpresaDAO();
                empresaDAO.remover(id);
                break
            case 14:
                print "Digite o ID do candidato: "
                int id = Integer.parseInt(System.in.newReader().readLine())

                CandidatoDAO candidatoDAO = new CandidatoDAO();
                candidatoDAO.remover(id);
                break
            case 15:
                print "Digite o ID da vaga: "
                int id = Integer.parseInt(System.in.newReader().readLine())

                VagaDAO vagaDAO = new VagaDAO();
                vagaDAO.remover(id);
                break
            case 16:
                print "Digite o ID da competencia: "
                int id = Integer.parseInt(System.in.newReader().readLine())

                CompetenciaDAO competenciaDAO = new CompetenciaDAO();
                competenciaDAO.remover(id);
                break
            case 0:
                break
            default:
                println "Opção inválida!"
        }
    } while (option != 0)
}
