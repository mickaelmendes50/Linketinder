package co.mesquita.linketinder.crud

import co.mesquita.linketinder.entity.Pessoa
import co.mesquita.linketinder.entity.PessoaFisica
import co.mesquita.linketinder.entity.PessoaJuridica

class CreatePessoa {
    static Pessoa createPessoa(type) {
        if (type)
            println "Adicionar novo Candidato"
        else
            println "Adicionar nova Empresa"

        print "Nome: "
        def name = System.in.newReader().readLine()
        print "Email: "
        def email = System.in.newReader().readLine()
        if (type)
            print "CPF: "
        else
            print "CNPJ: "
        def id = System.in.newReader().readLine()
        if (type)
            print "Idade: "
        else
            print "Pa�s: "
        def var = System.in.newReader().readLine()
        print "Estado: "
        def estate = System.in.newReader().readLine()
        print "CEP: "
        def cep = System.in.newReader().readLine()
        print "Descriç�o: "
        def description = System.in.newReader().readLine()

        if (type)
            return new PessoaFisica(name, email, id, var, estate, cep, description)
        else
            return new PessoaJuridica(name, email, id, var, estate, cep, description)
    }
}
