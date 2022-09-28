"use strict";
let workers = [];
let employers = [];
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
        workers.push(person);
    }
    else {
        let id = document.getElementById("cnpj").value;
        let country = document.getElementById("country").value;
        let estate = document.getElementById("pj_estate").value;
        let cep = document.getElementById("pj_cep").value;
        let description = document.getElementById("pj_description").value;
        let person = new PessoaJuridica(name, email, id, country, estate, cep, description);
        employers.push(person);
    }
    sessionStorage.setItem("workersArray", JSON.stringify(workers));
    sessionStorage.setItem("employersArray", JSON.stringify(employers));
}
function initialize() {
    // Instâncias predefindias para testes
    let worker = new PessoaFisica("João", "joao@worker.com", "123.456.789-01", "23", "Goiás", "74659-156", "Legal e extrovertido");
    workers.push(worker);
    worker = new PessoaFisica("Maria", "maria@worker.com", "456.789.101-11", "32", "São Paulo", "86551-785", "Chata e introvertida");
    workers.push(worker);
    worker = new PessoaFisica("Pedro", "pedro@worker.com", "789.101.112-13", "25", "Pernambuco", "95125-532", "Sábio e inteligente");
    workers.push(worker);
    worker = new PessoaFisica("Marta", "marta@worker.com", "101.112.131-41", "20", "Ceará", "75369-159", "Educada e amorosa");
    workers.push(worker);
    worker = new PessoaFisica("José", "jose@worker.com", "112.131.415-01", "40", "Bahia", "96325-452", "Triste e dramático");
    workers.push(worker);
    // Instâncias predefindias para testes
    let employer = new PessoaJuridica("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa");
    employers.push(employer);
    employer = new PessoaJuridica("Google", "google@employer.com", "12.345.678/0001-10", "Estados Unidos", "Califórnia", "75369-159", "Tecnologia");
    employers.push(employer);
    employer = new PessoaJuridica("Ford", "ford@employer.com", "12.345.678/0001-10", "Estados Unidos", "Dearborn", "86551-785", "Carros");
    employers.push(employer);
    employer = new PessoaJuridica("Xiaomi", "xiaomi@employer.com", "12.345.678/0001-10", "China", "Haidian", "74659-156", "Celulares");
    employers.push(employer);
    employer = new PessoaJuridica("Polishop", "polishop@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "95125-532", "Eletrodomesticos");
    employers.push(employer);
}
