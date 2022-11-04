package co.mesquita.linketinder

import co.mesquita.linketinder.controller.ControllerFactory

import static co.mesquita.linketinder.utils.Constants.*

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
                    def controller = ControllerFactory.getController(EMPRESA)
                    controller.list()
                    break
                case 2:
                    def controller = ControllerFactory.getController(CANDIDATO)
                    controller.list()
                    break
                case 3:
                    def controller = ControllerFactory.getController(VAGA)
                    controller.list()
                    break
                case 4:
                    def controller = ControllerFactory.getController(COMPETENCIA)
                    controller.list()
                    break
                case 5:
                    def controller = ControllerFactory.getController(EMPRESA)
                    controller.create()
                    break
                case 6:
                    def controller = ControllerFactory.getController(CANDIDATO)
                    controller.create()
                    break
                case 7:
                    def controller = ControllerFactory.getController(VAGA)
                    controller.create()
                    break
                case 8:
                    def controller = ControllerFactory.getController(COMPETENCIA)
                    controller.create()
                    break
                case 9:
                    def controller = ControllerFactory.getController(EMPRESA)
                    controller.update()
                    break
                case 10:
                    def controller = ControllerFactory.getController(CANDIDATO)
                    controller.update()
                    break
                case 11:
                    def controller = ControllerFactory.getController(VAGA)
                    controller.update()
                    break
                case 12:
                    def controller = ControllerFactory.getController(COMPETENCIA)
                    controller.update()
                    break
                case 13:
                    def controller = ControllerFactory.getController(EMPRESA)
                    controller.delete()
                    break
                case 14:
                    def controller = ControllerFactory.getController(CANDIDATO)
                    controller.delete()
                    break
                case 15:
                    def controller = ControllerFactory.getController(VAGA)
                    controller.delete()
                    break
                case 16:
                    def controller = ControllerFactory.getController(COMPETENCIA)
                    controller.delete()
                    break
                case 0:
                    break
                default:
                    println "Opção inválida!"
            }
        } while (option != 0)
    }
}
