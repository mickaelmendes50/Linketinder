class Empresa extends Pessoa {
    _country: string
    _estate: string
    _cep: string
    _description: string
 
    _skills: string[] = []

    constructor(name: string, email: string, id: string, country: string, estate: string, cep: string, description: string) {
        super(name, email, id)
        this._country = country
        this._estate = estate
        this._cep = cep
        this._description = description  
    }

    get country(): string {
        return this._country
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

