package co.mesquita.linketinder.model.entity

class Empresa extends Pessoa {
    private country
    private cep
    private description
    private documento

    Empresa(id, name, email, senha, documento, country, cep, description) {
        super(id, name, email, senha)
        this.country = country
        this.cep = cep
        this.description = description
        this.documento = documento
    }

    Empresa(name, email, senha, documento, country, cep, description) {
        super(name, email, senha)
        this.country = country
        this.cep = cep
        this.description = description
        this.documento = documento
    }

    Empresa() {
        super()
    }

    String getDocumento() {
        return this.documento
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

    void setCountry(country) {
        this.country = country
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
               "\nCNPJ: " + getDocumento() +
               "\nPaís: " + getCountry() +
               "\nCEP: " + getCep() +
               "\nDescrição: " + getDescription()
    }
}
