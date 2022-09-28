class PessoaFisica extends Pessoa {
    _age: string
    _estate: string
    _cep: string
    _description: string

    _skills: string[] = []

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

    get estate(): string {
        return this._estate
    }

    get cep(): string {
        return this._cep
    }

    get description(): string {
        return this._description
    }

    get skills(): string {
        let tmp = ""
        for (let i = 0; i < this._skills.length; i++) {
            tmp += this._skills[i] + ", "
        }
        return tmp
    }

    addSkill(skill: string): string {
        this._skills.push(skill)
        return skill + " sucess"
    }
}
