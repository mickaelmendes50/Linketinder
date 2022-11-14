package co.mesquita.linketinder.model.entity

class Candidato extends Pessoa {
    private sobrenome
    private nascimento
    private estate
    private cep
    private description
    private documento

    Candidato(id, name, sobrenome, email, senha, documento, nascimento, estate, cep, description) {
        super(id, name, email, senha)
        this.sobrenome = sobrenome
        this.nascimento = nascimento
        this.estate = estate
        this.cep = cep
        this.description = description
        this.documento = documento
    }

    Candidato(name, sobrenome, email, senha, documento, nascimento, estate, cep, description) {
        super(name, email, senha)
        this.sobrenome = sobrenome
        this.nascimento = nascimento
        this.estate = estate
        this.cep = cep
        this.description = description
        this.documento = documento
    }

    String getName() {
        return super.getName()
    }

    String getEmail() {
        return super.getEmail()
    }

    String getSobrenome() {
        return sobrenome
    }

    String getNascimento() {
        return nascimento
    }

    String getId() {
        return super.getId()
    }

    String getAge() {
        return this.nascimento
    }

    String getEstate() {
        return this.estate
    }

    String getCep() {
        return this.cep
    }

    String getDescription() {
        return this.description
    }

    String getDocumento() {
        return this.documento
    }

    void setSobrenome(sobrenome) {
        this.sobrenome = sobrenome
    }

    void setNascimento(nascimento) {
        this.nascimento = nascimento
    }

    void setEstate(estate) {
        this.estate = estate
    }

    void setCep(cep) {
        this.cep = cep
    }

    void setDescription(description) {
        this.description = description
    }

    void setDocumento(documento) {
        this.documento = documento
    }

    String toString() {
        return "-----------------------------------------------------\n" +
               super.toString() +
               "\nCPF: " + getDocumento() +
               "\nNascimento: " + getAge() +
               "\nEstado: " + getEstate() +
               "\nCEP: " + getCep() +
               "\nDescrição: " + getDescription()
    }
}
