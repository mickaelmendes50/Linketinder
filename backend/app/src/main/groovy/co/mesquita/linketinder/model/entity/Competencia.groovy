package co.mesquita.linketinder.model.entity

class Competencia {
    private id
    private nome

    Competencia(id, nome) {
        this.id = id
        this.nome = nome
    }

    Competencia(nome) {
        this.nome = nome
    }

    int getId() {
        return id
    }

    String getNome() {
        return nome
    }

    String toString() {
        return "ID: " + getId() +
                "\nNome: " + getNome()
    }
}
