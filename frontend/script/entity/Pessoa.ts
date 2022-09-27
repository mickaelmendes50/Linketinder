abstract class Pessoa {
    private _name: string
    private _email: string
    // CPF - CNPJ
    private _id: string

    constructor(name: string, email: string, id: string) {
        this._name = name
        this._email = email
        this._id = id        
    }

    get name(): string {
        return this._name
    }

    set name(name: string) {
        this._name = name
    }

    get email(): string {
        return this._email
    }

    set email(email: string) {
        this._email = email
    }

    get id(): string {
        return this._id
    }

    set id(id: string) {
        this._id = id
    }
}
