package co.mesquita.linketinder

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

    Pessoa p = new PessoaFisica("João", "joao@worker.com", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido")
    p.addSkill("Java")
    p.addSkill("Groovy")
    workers.add(p);
    p = new PessoaFisica("Maria", "maria@worker.com", "456.789.101-11", 32, "São Paulo", "86551-785", "Chata e introvertida")
    p.addSkill("Kotlin")
    p.addSkill("Apache")
    workers.add(p);
    p = new PessoaFisica("Pedro", "pedro@worker.com", "789.101.112-13", 25, "Pernambuco", "95125-532", "Sábio e inteligente")
    p.addSkill("Ruby")
    p.addSkill("Node")
    workers.add(p);
    p = new PessoaFisica("Marta", "marta@worker.com", "101.112.131-41", 20, "Ceará", "75369-159", "Educada e amorosa")
    p.addSkill("Python")
    p.addSkill("Spring")
    workers.add(p);
    p = new PessoaFisica("José", "jose@worker.com", "112.131.415-01", 40, "Bahia", "96325-452", "Triste e dramático")
    p.addSkill("C#")
    p.addSkill(".NET")
    workers.add(p);    

    p = new PessoaJuridica("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa")
    p.addSkill("Liderança")
    p.addSkill("Experiencia")
    employers.add(p)
    p = new PessoaJuridica("Google", "google@employer.com", "12.345.678/0001-10", "Estados Unidos", "Califórnia", "75369-159", "Tecnologia")
    p.addSkill("Formação superior")
    p.addSkill("Gestão")
    employers.add(p)
    p = new PessoaJuridica("Ford", "ford@employer.com", "12.345.678/0001-10", "Estados Unidos", "Dearborn", "86551-785", "Carros")
    p.addSkill("Experiencia")
    p.addSkill("Vendas")
    employers.add(p)
    p = new PessoaJuridica("Xiaomi", "xiaomi@employer.com", "12.345.678/0001-10", "China", "Haidian", "74659-156", "Celulares")
    p.addSkill("Formacao superior")
    p.addSkill("Vendas")
    employers.add(p)
    p = new PessoaJuridica("Polishop", "polishop@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "95125-532", "Eletrodomesticos")
    p.addSkill("Experiencia")
    p.addSkill("Vendas")
    employers.add(p)
    
    def option = -1
    do {
        printMenu()
        option = System.in.newReader().readLine() as Integer
        switch(option) {
            case 1:
                printInfo(employers)
                break
            case 2:
                printInfo(workers)
                break
            case 3:
                employers.add(createPessoa(0))
                break
            case 4:
                workers.add(createPessoa(1))
                break
            case 0:
                break
            default:
                println "Opção inválida!"
        }
    } while (option != 0)
}
