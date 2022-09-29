package co.mesquita.linketinder.crud

import co.mesquita.linketinder.entity.Pessoa
import co.mesquita.linketinder.entity.PessoaFisica
import co.mesquita.linketinder.entity.PessoaJuridica

class CreatePessoa {
    static Pessoa createPessoa(type, name, email, id, var, estate, cep, description) {
        if (type)
            return new PessoaFisica(name, email, id, var, estate, cep, description)
        else
            return new PessoaJuridica(name, email, id, var, estate, cep, description)
    }
}
