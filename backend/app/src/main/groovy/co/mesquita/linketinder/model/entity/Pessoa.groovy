package co.mesquita.linketinder.model.entity

abstract class Pessoa {
    private id
    private name
    private email
    private senha

    Pessoa(id, name, email, senha) {
        this.id = id
        this.name = name
        this.email = email
        this.senha = senha
    }

    Pessoa(name, email, senha) {
        this.name = name
        this.email = email
        this.senha = senha
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

    String toString() {
        return  "ID: " + getId() +
                "\nNome: " + getName() +
                "\nEmail: " + getEmail()
    }
}
