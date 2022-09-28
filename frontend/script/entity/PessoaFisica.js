"use strict";
class PessoaFisica extends Pessoa {
    constructor(name, email, id, age, estate, cep, description) {
        super(name, email, id);
        this._skills = [];
        this._age = age;
        this._estate = estate;
        this._cep = cep;
        this._description = description;
    }
    get age() {
        return this._age;
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
