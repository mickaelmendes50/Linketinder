package co.mesquita.linketinder.entity

abstract class Pessoa {
    private id
    private name
    private sobrenome
    private email
    private senha
    // CPF - CNPJ
    private documento

    Pessoa(id, name, sobrenome, email, senha, documento) {
        this.id = id
        this.name = name
        this.sobrenome = sobrenome
        this.email = email
        this.senha = senha
        this.documento = documento
    }

    def getDocumento() {
        return documento
    }

    def getSobrenome() {
        return sobrenome
    }

    void setSobrenome(sobrenome) {
        this.sobrenome = sobrenome
    }

    void setDocumento(documento) {
        this.documento = documento
    }

    def getSenha() {
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
                "\nNome: " + getName() + " " + getSobrenome() +
                "\nEmail: " + getEmail() +
                "\n" + type + getDocumento()

    }
}
