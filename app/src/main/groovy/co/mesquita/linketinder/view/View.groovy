package co.mesquita.linketinder.view

import co.mesquita.linketinder.model.entity.Candidato
import co.mesquita.linketinder.model.entity.Competencia
import co.mesquita.linketinder.model.entity.Empresa
import co.mesquita.linketinder.model.entity.Vaga

class View {
    static Candidato viewCandidato() {
        println "Dados do Candidato"

        print "Nome: "
        def name = System.in.newReader().readLine()
        print "Sobrenome: "
        def sobrenome = System.in.newReader().readLine()
        print "Email: "
        def senha = System.in.newReader().readLine()
        print "senha: "
        def email = System.in.newReader().readLine()
        print "CPF: "
        def documento = System.in.newReader().readLine()
        print "Data de Nacimento: "
        def nascimento = System.in.newReader().readLine()
        print "País: "
        def estate = System.in.newReader().readLine()
        print "CEP: "
        def cep = System.in.newReader().readLine()
        print "Descriçao: "
        def description = System.in.newReader().readLine()

        return new Candidato(name, sobrenome, email, senha, documento, nascimento, estate, cep, description)
    }

    static Empresa viewEmpresa() {
        println "Dados da Empresa"

        print "Nome: "
        def name = System.in.newReader().readLine()
        print "Email: "
        def senha = System.in.newReader().readLine()
        print "senha: "
        def email = System.in.newReader().readLine()
        print "CNPJ: "
        def documento = System.in.newReader().readLine()
        print "Pais: "
        def country = System.in.newReader().readLine()
        print "CEP: "
        def cep = System.in.newReader().readLine()
        print "Descriçao: "
        def description = System.in.newReader().readLine()

        return new Empresa(name, email, senha, documento, country, cep, description)
    }

    static Vaga viewVaga() {
        println "Dados da Vaga"

        print "ID da Empresa: "
        int id_empresa = Integer.parseInt(System.in.newReader().readLine())
        print "Nome: "
        def nome = System.in.newReader().readLine()
        print "Pais: "
        def local = System.in.newReader().readLine()
        print "Descriçao: "
        def descricao = System.in.newReader().readLine()

        return new Vaga(id_empresa, nome, descricao, local)
    }

    static viewCompetencia() {
        println "Dados da Competencia"

        print "Nome: "
        def nome = System.in.newReader().readLine()

        return new Competencia(nome)
    }

    static int askId() {
        print "Digite o ID: "
        int id = Integer.parseInt(System.in.newReader().readLine())
        return id
    }
}
