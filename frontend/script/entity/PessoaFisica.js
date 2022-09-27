"use strict";
class PessoaFisica extends Pessoa {
    constructor(name, email, id, age, estate, cep, description) {
        super(name, email, id);
        this._age = age;
        this._estate = estate;
        this._cep = cep;
        this._description = description;
    }
    get age() {
        return this._age;
    }
    set age(age) {
        this._age = age;
    }
    get estate() {
        return this._estate;
    }
    set estate(estate) {
        this._estate = estate;
    }
    get cep() {
        return this._cep;
    }
    set cep(cep) {
        this._cep = cep;
    }
    get description() {
        return this._description;
    }
    set description(description) {
        this._description = description;
    }
}
