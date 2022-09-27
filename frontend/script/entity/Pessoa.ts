abstract class Pessoa {
    private _name: String
    private _email: String
    // CPF - CNPJ
    private _id: String

    constructor(name: String, email: String, id: String) {
        this._name = name
        this._email = email
        this._id = id        
    }

    get name(): String {
        return this._name
    }

    set name(name: String) {
        this._name = name
    }

    get email(): String {
        return this._email
    }

    set email(email: String) {
        this._email = email
    }

    get id(): String {
        return this._id
    }

    set id(id: String) {
        this._id = id
    }
}
