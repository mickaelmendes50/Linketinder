package co.mesquita.linketinder

import co.mesquita.linketinder.dao.CandidatoDAO
import co.mesquita.linketinder.dao.CandidatosCompetenciasDAO
import co.mesquita.linketinder.dao.CompetenciaDAO
import co.mesquita.linketinder.dao.EmpresaDAO
import co.mesquita.linketinder.dao.VagaDAO
import co.mesquita.linketinder.dao.VagasCompetenciasDAO

import static co.mesquita.linketinder.crud.Create.*
import co.mesquita.linketinder.entity.*

class App {

    static void main(String[] args) {
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
                    List<Empresa> empresas = EmpresaDAO.listar()
                    for (Empresa empresa : empresas)
                        System.out.println(empresa)
                    break
                case 2:
                    List<Candidato> candidatos = CandidatoDAO.listar()
                    for (Candidato candidato : candidatos)
                        System.out.println(candidato)
                    break
                case 3:
                    List<Vaga> vagas = VagaDAO.listar()
                    for (Vaga vaga : vagas)
                        System.out.println(vaga)
                    break
                case 4:
                    List<Competencia> competencias = CompetenciaDAO.listar()
                    for (Competencia competencia : competencias)
                        System.out.println(competencia)
                    break

                case 5:
                    Empresa empresa = createEmpresa()
                    EmpresaDAO.inserir(empresa)
                    break
                case 6:
                    Candidato candidato = createCandidato()
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

                    break
                case 7:
                    Vaga vaga = createVaga()
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

                    break
                case 8:
                    Competencia competencia = createCompetencia()
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
                    break
                case 9:
                    print "Digite o ID da empresa: "
                    int id = Integer.parseInt(System.in.newReader().readLine())

                    Empresa empresa = createEmpresa()
                    EmpresaDAO.alterar(empresa, id)
                    break
                case 10:
                    print "Digite o ID do candidato: "
                    int id = Integer.parseInt(System.in.newReader().readLine())

                    Candidato candidato = createCandidato()
                    CandidatoDAO.alterar(candidato, id)
                    break
                case 11:
                    print "Digite o ID da vaga: "
                    int id = Integer.parseInt(System.in.newReader().readLine())

                    Vaga vaga = createVaga()
                    VagaDAO.alterar(vaga, id)
                    break
                case 12:
                    print "Digite o ID da competencia: "
                    int id = Integer.parseInt(System.in.newReader().readLine())

                    Competencia competencia = createCompetencia()
                    CompetenciaDAO.alterar(competencia, id)
                    break
                case 13:
                    print "Digite o ID da empresa: "
                    int id = Integer.parseInt(System.in.newReader().readLine())

                    EmpresaDAO.remover(id)
                    break
                case 14:
                    print "Digite o ID do candidato: "
                    int id = Integer.parseInt(System.in.newReader().readLine())

                    CandidatoDAO.remover(id)
                    break
                case 15:
                    print "Digite o ID da vaga: "
                    int id = Integer.parseInt(System.in.newReader().readLine())

                    VagaDAO.remover(id)
                    break
                case 16:
                    print "Digite o ID da competencia: "
                    int id = Integer.parseInt(System.in.newReader().readLine())

                    CompetenciaDAO.remover(id)
                    break
                case 0:
                    break
                default:
                    println "Opção inválida!"
            }
        } while (option != 0)
    }
}
