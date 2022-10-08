package co.mesquita.linketinder.entity

class Empresa extends Pessoa {
    private country
    private cep
    private description

    private def skills = []

    Empresa(id, name, email, senha, documento, country, cep, description) {
        super(id, name, email, senha, documento)
        this.country = country
        this.cep = cep
        this.description = description
    }

    Empresa(name, email, senha, documento, country, cep, description) {
        super(name, email, senha, documento)
        this.country = country
        this.cep = cep
        this.description = description
    }

    String getDocumento() {
        return super.getDocumento()
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

    String getCountry() {
        return this.country
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
               "\nPaís: " + getCountry() +
               "\nCEP: " + getCep() +
               "\nDescrição: " + getDescription() +
               "\nCompetencias: " + getSkills()
    }
}
