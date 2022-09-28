"use strict";
class PessoaJuridica extends Pessoa {
    constructor(name, email, id, country, estate, cep, description) {
        super(name, email, id);
        this._skills = [];
        this._country = country;
        this._estate = estate;
        this._cep = cep;
        this._description = description;
    }
    get country() {
        return this._country;
    }
    get estate() {
        return this._estate;
    }
    get cep() {
        return this._cep;
    }
    get description() {
        return this._description;
    }
    get skills() {
        let tmp = "";
        for (let i = 0; i < this._skills.length; i++) {
            tmp += this._skills[i] + ", ";
        }
        return tmp;
    }
    addSkill(skill) {
        this._skills.push(skill);
        return skill + " sucess";
    }
}
