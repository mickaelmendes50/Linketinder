package co.mesquita.linketinder.entity

abstract class Pessoa {
    private name
    private email
    // CPF - CNPJ
    private id

    Pessoa(name, email, id) {
        this.name = name
        this.email = email
        this.id = id
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

        return  "Nome: " + getName() +
                "\nEmail: " + getEmail() +
                "\n" + type + getId()

    }
}
