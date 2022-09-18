package co.mesquita.linketinder.entity

abstract class Pessoa {
    private String name
    private String email
    // CPF - CNPJ
    private String id

    Pessoa(String name, String email, String id) {
        this.name = name
        this.email = email
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    // Tipo 1 = CPF
    // Tipo 0 = CNPJ
    String toString(def type) {
        if (type)
            type = "CPF: "
        else
            type = "CNPJ: "

        return  "Nome: " + getName() +
                "\nEmail: " + getEmail() +
                "\n" + type + getId()

    }
}
