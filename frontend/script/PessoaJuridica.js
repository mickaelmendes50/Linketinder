"use strict";
class PessoaJuridica extends Pessoa {
    constructor(name, email, id, country, estate, cep, description) {
        super(name, email, id);
        this._country = country;
        this._estate = estate;
        this._cep = cep;
        this._description = description;
    }
    get country() {
        return this._country;
    }
    set country(country) {
        this._country = country;
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
