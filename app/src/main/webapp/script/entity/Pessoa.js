"use strict";
class Pessoa {
    constructor(name, email, id) {
        this._name = name;
        this._email = email;
        this._id = id;
    }
    get name() {
        return this._name;
    }
    set name(name) {
        this._name = name;
    }
    get email() {
        return this._email;
    }
    set email(email) {
        this._email = email;
    }
    get id() {
        return this._id;
    }
    set id(id) {
        this._id = id;
    }
}
