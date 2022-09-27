class PessoaFisica extends Pessoa {
    private _age: string
    private _estate: string
    private _cep: string
    private _description: string

    constructor(name: string, email: string, id: string, age: string, estate: string, cep: string, description: string) {
        super(name, email, id)
        this._age = age
        this._estate = estate
        this._cep = cep
        this._description = description  
    }

    get age(): string {
        return this._age
    }

    set age(age: string) {
        this._age = age
    }

    get estate(): string {
        return this._estate
    }

    set estate(estate: string) {
        this._estate = estate
    }

    get cep(): string {
        return this._cep
    }

    set cep(cep: string) {
        this._cep = cep
    }

    get description(): string {
        return this._description
    }

    set description(description: string) {
        this._description = description
    }
}
