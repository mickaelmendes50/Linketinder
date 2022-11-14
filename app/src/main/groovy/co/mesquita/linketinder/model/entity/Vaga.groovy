package co.mesquita.linketinder.model.entity

class Vaga {
    private id
    private id_empresa
    private nome
    private descricao
    private local

    Vaga(id, id_empresa, nome, descricao, local) {
        this.id = id
        this.id_empresa = id_empresa
        this.nome = nome
        this.descricao = descricao
        this.local = local
    }

    Vaga(id_empresa, nome, descricao, local) {
        this.id_empresa = id_empresa
        this.nome = nome
        this.descricao = descricao
        this.local = local
    }

    Vaga() {}

    int getId() {
        return id
    }

    int getIdEmpresa() {
        return id_empresa
    }

    String getNome() {
        return nome
    }

    String getDescricao() {
        return descricao
    }

    String getLocal() {
        return local
    }

    void setId(id) {
        this.id = id
    }

    void setIdEmpresa(id_empresa) {
        this.id_empresa = id_empresa
    }

    void setNome(nome) {
        this.nome = nome
    }

    void setDescricao(descricao) {
        this.descricao = descricao
    }

    void setLocal(local) {
        this.local = local
    }

    String toString() {
        return "------------------------------------------" +
               "\nEmpresa (ID): " + getIdEmpresa() +
               "\nNome: " + getNome() +
               "\nDescricao: " + getDescricao() +
               "\nLocal: " + getLocal()
    }
}
