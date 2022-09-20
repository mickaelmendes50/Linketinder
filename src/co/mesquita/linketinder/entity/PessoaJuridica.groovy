package co.mesquita.linketinder.entity

class PessoaJuridica extends Pessoa {
    private country
    private estate
    private cep
    private description

    private def skills = []

    PessoaJuridica(name, email, id, country, estate, cep, description) {
        super(name, email, id)
        this.country = country
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

    String getCountry() {
        return this.country
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
               "\nPaís: " + getCountry() +
               "\nEstado: " + getEstate() +
               "\nCEP: " + getCep() +
               "\nDescrição: " + getDescription() +
               "\nCompetencias: " + getSkills()
    }
}
