"use strict";
let pfs = [];
let pjs = [];
function displayEnable(id) {
    const element = document.getElementById(id);
    if (element != null) {
        element.style.display = 'block';
    }
}
function displayDisable(id) {
    const element = document.getElementById(id);
    if (element != null) {
        element.style.display = 'none';
    }
}
function createAccount(type) {
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    if (type) {
        let id = document.getElementById("cpf").value;
        let age = document.getElementById("age").value;
        let estate = document.getElementById("pf_estate").value;
        let cep = document.getElementById("pf_cep").value;
        let description = document.getElementById("pf_description").value;
        let person = new PessoaFisica(name, email, id, age, estate, cep, description);
        pfs.push(person);
    }
    else {
        let id = document.getElementById("cnpj").value;
        let country = document.getElementById("country").value;
        let estate = document.getElementById("pj_estate").value;
        let cep = document.getElementById("pj_cep").value;
        let description = document.getElementById("pj_description").value;
        let person = new PessoaJuridica(name, email, id, country, estate, cep, description);
        pjs.push(person);
    }
}
