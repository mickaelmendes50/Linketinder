package co.mesquita.linketinder.crud

import co.mesquita.linketinder.entity.Pessoa
import co.mesquita.linketinder.entity.Candidato
import co.mesquita.linketinder.entity.Empresa

class CreatePessoa {
    static Pessoa createPessoa(type, name, sobrenome, email, senha, documento, var, estate, cep, description) {
        if (type)
            return new Candidato(name, sobrenome, email, senha, documento, var, estate, cep, description)
        else
            return new Empresa(name, email, documento, var, estate, cep, description)
    }
}
