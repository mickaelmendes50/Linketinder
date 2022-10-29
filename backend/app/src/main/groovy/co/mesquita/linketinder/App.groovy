package co.mesquita.linketinder

import co.mesquita.linketinder.controller.CandidatoController
import co.mesquita.linketinder.controller.CompetenciaController
import co.mesquita.linketinder.controller.EmpresaController
import co.mesquita.linketinder.controller.VagaController

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
                    EmpresaController emprCtrl = new EmpresaController()
                    emprCtrl.list()
                    break
                case 2:
                    CandidatoController candCtrl = new CandidatoController()
                    candCtrl.list()
                    break
                case 3:
                    VagaController vagaCtrl = new VagaController()
                    vagaCtrl.list()
                    break
                case 4:
                    CompetenciaController compCtrl = new CompetenciaController()
                    compCtrl.list()
                    break
                case 5:
                    EmpresaController emprCtrl = new EmpresaController()
                    emprCtrl.create()
                    break
                case 6:
                    CandidatoController candCtrl = new CandidatoController()
                    candCtrl.create()
                    break
                case 7:
                    VagaController vagaCtrl = new VagaController()
                    vagaCtrl.create()
                    break
                case 8:
                    CompetenciaController compCtrl = new CompetenciaController()
                    compCtrl.create()
                    break
                case 9:
                    EmpresaController emprCtrl = new EmpresaController()
                    emprCtrl.update()
                    break
                case 10:
                    CandidatoController candCtrl = new CandidatoController()
                    candCtrl.update()
                    break
                case 11:
                    VagaController vagaCtrl = new VagaController()
                    vagaCtrl.update()
                    break
                case 12:
                    CompetenciaController compCtrl = new CompetenciaController()
                    compCtrl.update()
                    break
                case 13:
                    EmpresaController emprCtrl = new EmpresaController()
                    emprCtrl.delete()
                    break
                case 14:
                    CandidatoController candCtrl = new CandidatoController()
                    candCtrl.delete()
                    break
                case 15:
                    VagaController vagaCtrl = new VagaController()
                    vagaCtrl.delete()
                    break
                case 16:
                    CompetenciaController compCtrl = new CompetenciaController()
                    compCtrl.delete()
                    break
                case 0:
                    break
                default:
                    println "Opção inválida!"
            }
        } while (option != 0)
    }
}
