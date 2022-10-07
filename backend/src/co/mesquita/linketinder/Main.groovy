package co.mesquita.linketinder

import co.mesquita.linketinder.dao.CandidatoDAO

import static co.mesquita.linketinder.crud.CreatePessoa.createPessoa
import co.mesquita.linketinder.entity.*

static void main(args) {
    def workers = []
    def employers = []

    def printInfo = { x ->
        for (element in x) {
            println element.toString()
        }
    }

    def colectData = { type ->
        if (type)
            println "Adicionar novo Candidato"
        else
            println "Adicionar nova Empresa"

        print "Nome: "
        def name = System.in.newReader().readLine()
        print "Sobrenome: "
        def sobrenome = System.in.newReader().readLine()
        print "Email: "
        def senha = System.in.newReader().readLine()
        print "senha: "
        def email = System.in.newReader().readLine()
        if (type)
            print "CPF: "
        else
            print "CNPJ: "
        def documento = System.in.newReader().readLine()
        if (type)
            print "Idade: "
        else
            print "Pais: "
        def var = System.in.newReader().readLine()
        print "Estado: "
        def estate = System.in.newReader().readLine()
        print "CEP: "
        def cep = System.in.newReader().readLine()
        print "Descriçao: "
        def description = System.in.newReader().readLine()

        return createPessoa(type, name, sobrenome, email, senha, documento, var, estate, cep, description)
    }

    def printMenu = {
        println "------------------------------"
        println "-- Bem vindo ao Linketinder --"
        println "------------------------------"
        println "1. Listar empresas"
        println "2. Listar candidatos"
        println "3. Adicionar empresa"
        println "4. Adicionar candidado"
        println "0. Sair"
    }
    
    def option = -1
    do {
        printMenu()
        option = System.in.newReader().readLine() as Integer
        switch(option) {
            case 1:
                printInfo(employers)
                break
            case 2:
                CandidatoDAO candidatoDAO = new CandidatoDAO();
                List<Candidato> lista = candidatoDAO.listar();
                for (Candidato candidato : lista)
                    System.out.println(candidato);
                break
            case 3:
                employers.add(colectData(0))
                break
            case 4:
                Candidato candidato = colectData(1)
                CandidatoDAO candidatoDAO = new CandidatoDAO();
                candidatoDAO.inserir(candidato);
                break
            case 0:
                break
            default:
                println "Opção inválida!"
        }
    } while (option != 0)
}
