package co.mesquita.linketinder.entity

class Candidato extends Pessoa {
    private nascimento
    private estate
    private cep
    private description

    private def skills = []

    Candidato(id, name, sobrenome, email, senha, documento, nascimento, estate, cep, description) {
        super(id, name, sobrenome, email, senha, documento)
        this.nascimento = nascimento
        this.estate = estate
        this.cep = cep
        this.description = description
    }

    Candidato(name, sobrenome, email, senha, documento, nascimento, estate, cep, description) {
        super(name, sobrenome, email, senha, documento)
        this.nascimento = nascimento
        this.estate = estate
        this.cep = cep
        this.description = description
    }

    String getName() {
        return super.getName()
    }

    String getEmail() {
        return super.getEmail()
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

    String getSkills () {
        def tmp = ""
        for (x in this.skills) {
            tmp += x + ", "
        }
        return tmp
    }

    void addSkill(skill) {
        this.skills.add(skill)
    }

    String toString() {
        return "-----------------------------------------------------\n" +
               super.toString(1) + 
               "\nNascimento: " + getAge() +
               "\nEstado: " + getEstate() +
               "\nCEP: " + getCep() +
               "\nDescrição: " + getDescription() +
               "\nCompetencias: " + getSkills()
    }
}
