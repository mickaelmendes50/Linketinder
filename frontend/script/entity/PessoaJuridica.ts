class PessoaJuridica extends Pessoa {
    private _country: String
    private _estate: String
    private _cep: String
    private _description: String

    constructor(name: String, email: String, id: String, country: String, estate: String, cep: String, description: String) {
        super(name, email, id)
        this._country = country
        this._estate = estate
        this._cep = cep
        this._description = description  
    }

    get country(): String {
        return this._country
    }

    set country(country: String) {
        this._country = country
    }

    get estate(): String {
        return this._estate
    }

    set estate(estate: String) {
        this._estate = estate
    }

    get cep(): String {
        return this._cep
    }

    set cep(cep: String) {
        this._cep = cep
    }

    get description(): String {
        return this._description
    }

    set description(description: String) {
        this._description = description
    }
}
