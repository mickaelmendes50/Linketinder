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
        let skill = document.getElementById("pf_skills").value;
        let person = new PessoaFisica(name, email, id, age, estate, cep, description);
        let arr_skills = skill.split(',');
        for (let i = 0; i < arr_skills.length; i++) {
            person.addSkill(arr_skills[i]);
        }
        workers.push(person);
    }
    else {
        let id = document.getElementById("cnpj").value;
        let country = document.getElementById("country").value;
        let estate = document.getElementById("pj_estate").value;
        let cep = document.getElementById("pj_cep").value;
        let description = document.getElementById("pj_description").value;
        let skill = document.getElementById("pj_skills").value;
        let person = new PessoaJuridica(name, email, id, country, estate, cep, description);
        let arr_skills = skill.split(',');
        for (let i = 0; i < arr_skills.length; i++) {
            person.addSkill(arr_skills[i]);
        }
        employers.push(person);
    }
    sessionStorage.setItem("workersArray", JSON.stringify(workers));
    sessionStorage.setItem("employersArray", JSON.stringify(employers));
}
function initialize() {
    // Instâncias predefindias para testes
    let worker = new PessoaFisica("João", "joao@worker.com", "123.456.789-01", "23", "Goiás", "74659-156", "Legal e extrovertido");
    worker.addSkill("Java");
    worker.addSkill("C++");
    worker.addSkill("Python");
    workers.push(worker);
    worker = new PessoaFisica("Maria", "maria@worker.com", "456.789.101-11", "32", "São Paulo", "86551-785", "Chata e introvertida");
    worker.addSkill("Java");
    worker.addSkill("C#");
    worker.addSkill("Ruby");
    workers.push(worker);
    worker = new PessoaFisica("Pedro", "pedro@worker.com", "789.101.112-13", "25", "Pernambuco", "95125-532", "Sábio e inteligente");
    worker.addSkill("C#");
    worker.addSkill("Ruby");
    worker.addSkill("Python");
    workers.push(worker);
    worker = new PessoaFisica("Marta", "marta@worker.com", "101.112.131-41", "20", "Ceará", "75369-159", "Educada e amorosa");
    worker.addSkill("JavaScript");
    worker.addSkill("TypeScript");
    worker.addSkill("Java");
    workers.push(worker);
    worker = new PessoaFisica("José", "jose@worker.com", "112.131.415-01", "40", "Bahia", "96325-452", "Triste e dramático");
    worker.addSkill("Ruby");
    worker.addSkill("Python");
    worker.addSkill("JavaScript");
    workers.push(worker);
    // Instâncias predefindias para testes
    let employer = new PessoaJuridica("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa");
    employer.addSkill("Liderança");
    employer.addSkill("Experiencia");
    employers.push(employer);
    employer = new PessoaJuridica("Google", "google@employer.com", "12.345.678/0001-10", "Estados Unidos", "Califórnia", "75369-159", "Tecnologia");
    employer.addSkill("Formação superior");
    employer.addSkill("Gestão");
    employers.push(employer);
    employer = new PessoaJuridica("Ford", "ford@employer.com", "12.345.678/0001-10", "Estados Unidos", "Dearborn", "86551-785", "Carros");
    employer.addSkill("Experiencia");
    employer.addSkill("Vendas");
    employers.push(employer);
    employer = new PessoaJuridica("Xiaomi", "xiaomi@employer.com", "12.345.678/0001-10", "China", "Haidian", "74659-156", "Celulares");
    employer.addSkill("Formacao superior");
    employer.addSkill("Vendas");
    employers.push(employer);
    employer = new PessoaJuridica("Polishop", "polishop@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "95125-532", "Eletrodomesticos");
    employer.addSkill("Liderança");
    employer.addSkill("Gestão");
    employers.push(employer);
}
function restoreContent(type) {
    let storedWorkers = JSON.parse(sessionStorage.workersArray);
    for (let i = 0; i < storedWorkers.length; i++) {
        workers.push(storedWorkers[i]);
    }
    let storedEmployers = JSON.parse(sessionStorage.employersArray);
    for (let i = 0; i < storedEmployers.length; i++) {
        employers.push(storedEmployers[i]);
    }
    if (type) {
        const size = workers.length - 1;
        const accName = document.getElementById("acc-name");
        accName.innerHTML = workers[size]._name;
    }
    else {
        const size = employers.length - 1;
        const accName = document.getElementById("acc-name");
        accName.innerHTML = employers[5]._name;
    }
}
function showInfo(type) {
    let size;
    let arr = [];
    if (type) {
        size = workers.length - 1;
        arr = workers;
    }
    else {
        size = employers.length - 1;
        arr = employers;
    }
    document.getElementById("show-name").innerHTML = arr[size]._name;
    document.getElementById("show-email").innerHTML = arr[size]._email;
    document.getElementById("show-id").innerHTML = arr[size]._id;
    if (type) {
        document.getElementById("show-age").innerHTML = arr[size]._age;
    }
    else {
        document.getElementById("show-country").innerHTML = arr[size]._country;
    }
    document.getElementById("show-estate").innerHTML = arr[size]._estate;
    document.getElementById("show-cep").innerHTML = arr[size]._cep;
    document.getElementById("show-description").innerHTML = arr[size]._description;
}
function showList(type) {
    let arr = [];
    if (type) {
        arr = workers;
    }
    else {
        arr = employers;
    }
    const element_list = document.getElementById("list-values");
    for (let i = 0; i < arr.length; i++) {
        const p = document.createElement("p");
        const x = arr[i];
        let y;
        if (type) {
            y = "Idade: " + x._age + " anos. " + "Descrição: " + x._description + ". Local: CEP " + x._cep + ", " + x._estate;
        }
        else {
            y = "Descrição: " + x._description + ". Local: CEP " + x._cep + ", " + x._estate + " - " + x._country;
        }
        let z = "Habilidades: ";
        for (let j = 0; j < (x._skills).length; j++) {
            z += x._skills[j] + "; ";
        }
        let text = document.createTextNode(z + y);
        p.appendChild(text);
        let img = document.createElement("img");
        img.setAttribute("src", "assets/heart-icon.png");
        img.setAttribute("class", "heart-icon");
        element_list === null || element_list === void 0 ? void 0 : element_list.appendChild(p);
        element_list === null || element_list === void 0 ? void 0 : element_list.appendChild(img);
    }
}
