package co.mesquita.linketinder.entity

abstract class Pessoa {
    private id
    private name
    private email
    private senha
    // CPF - CNPJ
    private documento

    Pessoa(id, name, email, senha, documento) {
        this.id = id
        this.name = name
        this.email = email
        this.senha = senha
        this.documento = documento
    }

    Pessoa(name, email, senha, documento) {
        this.name = name
        this.email = email
        this.senha = senha
        this.documento = documento
    }


    String getDocumento() {
        return documento
    }

    void setDocumento(documento) {
        this.documento = documento
    }

    String getSenha() {
        return senha
    }

    void setSenha(senha) {
        this.senha = senha
    }

    String getName() {
        return name
    }

    void setName(name) {
        this.name = name
    }

    String getEmail() {
        return email
    }

    void setEmail(email) {
        this.email = email
    }

    String getId() {
        return id
    }

    void setId(id) {
        this.id = id
    }

    // Tipo 1 = CPF
    // Tipo 0 = CNPJ
    String toString(type) {
        if (type)
            type = "CPF: "
        else
            type = "CNPJ: "

        return  "ID: " + getId() +
                "\nNome: " + getName() +
                "\nEmail: " + getEmail() +
                "\n" + type + getDocumento()

    }
}
