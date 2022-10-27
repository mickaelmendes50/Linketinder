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
    if (name.match(/[a-zA-Z\u00C0-\u00FF ]+/gi) == null || name.match(/\d/g) != null || name == "") {
        document.getElementById("return-info").innerHTML = "Nome inválido!";
        document.getElementById("return-info").style.color = "red";
        return;
    }
    let email = document.getElementById("email").value;
    if ((email.match(/\S+@\w+\.\w{2,6}(\.\w{2})?/g)) == null) {
        document.getElementById("return-info").innerHTML = "Email inválido!";
        document.getElementById("return-info").style.color = "red";
        return;
    }
    let id, age = "", country = "";
    if (type) {
        id = document.getElementById("cpf").value;
        if ((id.match(/([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/)) == null) {
            document.getElementById("return-info").innerHTML = "CPF inválido!";
            document.getElementById("return-info").style.color = "red";
            return;
        }
        age = document.getElementById("age").value;
        if (age == "" || age.match(/\d{1,2}/) == null || age.length > 2) {
            document.getElementById("return-info").innerHTML = "Idade inválida!";
            document.getElementById("return-info").style.color = "red";
            return;
        }
    }
    else {
        id = document.getElementById("cnpj").value;
        if ((id.match(/([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})/)) == null) {
            document.getElementById("return-info").innerHTML = "CNPJ inválido!";
            document.getElementById("return-info").style.color = "red";
            return;
        }
        country = document.getElementById("country").value;
        if (country.match(/[a-zA-Z\u00C0-\u00FF ]+/gi) == null || country.match(/\d/g) != null || country == "") {
            document.getElementById("return-info").innerHTML = "País inválido!";
            document.getElementById("return-info").style.color = "red";
            return;
        }
    }
    let estate, cep, description, skill;
    if (type) {
        estate = document.getElementById("pf_estate").value;
        cep = document.getElementById("pf_cep").value;
        description = document.getElementById("pf_description").value;
        skill = document.getElementById("pf_skills").value;
    }
    else {
        estate = document.getElementById("pj_estate").value;
        cep = document.getElementById("pj_cep").value;
        description = document.getElementById("pj_description").value;
        skill = document.getElementById("pj_skills").value;
    }
    if (estate.match(/[a-zA-Z\u00C0-\u00FF ]+/gi) == null || estate.match(/\d/g) != null || estate == "") {
        document.getElementById("return-info").innerHTML = "Estado inválido!";
        document.getElementById("return-info").style.color = "red";
        return;
    }
    if ((cep.match(/\d{5}-?\d{3}/)) == null) {
        document.getElementById("return-info").innerHTML = "CEP inválido!";
        document.getElementById("return-info").style.color = "red";
        return;
    }
    if (description == "") {
        document.getElementById("return-info").innerHTML = "Descrição inválida!";
        document.getElementById("return-info").style.color = "red";
        return;
    }
    if (skill.match(/\D+/g) == null || skill == "") {
        document.getElementById("return-info").innerHTML = "Habilidades inválidas!";
        document.getElementById("return-info").style.color = "red";
        return;
    }
    let person;
    if (type) {
        person = new Candidato(name, email, id, age, estate, cep, description);
    }
    else {
        person = new Empresa(name, email, id, country, estate, cep, description);
    }
    let arr_skills = skill.split(',');
    for (let i = 0; i < arr_skills.length; i++) {
        person.addSkill(arr_skills[i]);
    }
    if (type) {
        workers.push(person);
    }
    else {
        employers.push(person);
    }
    sessionStorage.setItem("workersArray", JSON.stringify(workers));
    sessionStorage.setItem("employersArray", JSON.stringify(employers));
    if (type) {
        window.location.href = 'candidate.html';
    }
    else {
        window.location.href = 'business.html';
    }
}
function initialize() {
    // Instâncias predefindias para testes
    let worker = new Candidato("João", "joao@worker.com", "123.456.789-01", "23", "Goiás", "74659-156", "Legal e extrovertido");
    worker.addSkill("Java");
    worker.addSkill("C++");
    worker.addSkill("Python");
    workers.push(worker);
    worker = new Candidato("Maria", "maria@worker.com", "456.789.101-11", "32", "São Paulo", "86551-785", "Chata e introvertida");
    worker.addSkill("Java");
    worker.addSkill("C#");
    worker.addSkill("Ruby");
    workers.push(worker);
    worker = new Candidato("Pedro", "pedro@worker.com", "789.101.112-13", "25", "Pernambuco", "95125-532", "Sábio e inteligente");
    worker.addSkill("C#");
    worker.addSkill("Ruby");
    worker.addSkill("Python");
    workers.push(worker);
    worker = new Candidato("Marta", "marta@worker.com", "101.112.131-41", "20", "Ceará", "75369-159", "Educada e amorosa");
    worker.addSkill("JavaScript");
    worker.addSkill("TypeScript");
    worker.addSkill("Java");
    workers.push(worker);
    worker = new Candidato("José", "jose@worker.com", "112.131.415-01", "40", "Bahia", "96325-452", "Triste e dramático");
    worker.addSkill("Ruby");
    worker.addSkill("Python");
    worker.addSkill("JavaScript");
    workers.push(worker);
    // Instâncias predefindias para testes
    let employer = new Empresa("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa");
    employer.addSkill("Liderança");
    employer.addSkill("Experiencia");
    employers.push(employer);
    employer = new Empresa("Google", "google@employer.com", "12.345.678/0001-10", "Estados Unidos", "Califórnia", "75369-159", "Tecnologia");
    employer.addSkill("Formação superior");
    employer.addSkill("Gestão");
    employers.push(employer);
    employer = new Empresa("Ford", "ford@employer.com", "12.345.678/0001-10", "Estados Unidos", "Dearborn", "86551-785", "Carros");
    employer.addSkill("Experiencia");
    employer.addSkill("Vendas");
    employers.push(employer);
    employer = new Empresa("Xiaomi", "xiaomi@employer.com", "12.345.678/0001-10", "China", "Haidian", "74659-156", "Celulares");
    employer.addSkill("Formacao superior");
    employer.addSkill("Vendas");
    employers.push(employer);
    employer = new Empresa("Polishop", "polishop@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "95125-532", "Eletrodomesticos");
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
