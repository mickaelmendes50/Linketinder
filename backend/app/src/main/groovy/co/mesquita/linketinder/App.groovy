package co.mesquita.linketinder

import static co.mesquita.linketinder.controller.CandidatoController.*
import static co.mesquita.linketinder.controller.CompetenciaController.*
import static co.mesquita.linketinder.controller.EmpresaController.*
import static co.mesquita.linketinder.controller.VagaController.*

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
                    listEmpresas()
                    break
                case 2:
                    listCandidatos()
                    break
                case 3:
                    listVagas()
                    break
                case 4:
                    listCompetencias()
                    break
                case 5:
                    createEmpresa()
                    break
                case 6:
                    createCandidato()
                    break
                case 7:
                    createVaga()
                    break
                case 8:
                    createCompetencia()
                    break
                case 9:
                    updateEmpresa()
                    break
                case 10:
                    updateCandidato()
                    break
                case 11:
                    updateVaga()
                    break
                case 12:
                    updateCompetencia()
                    break
                case 13:
                    deleteEmpresa()
                    break
                case 14:
                    deleteCandidato()
                    break
                case 15:
                    deleteVaga()
                    break
                case 16:
                    deleteCompetencia()
                    break
                case 0:
                    break
                default:
                    println "Opção inválida!"
            }
        } while (option != 0)
    }
}
