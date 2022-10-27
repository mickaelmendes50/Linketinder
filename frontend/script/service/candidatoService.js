"use strict";
function getDataCandidato() {
    nome = document.getElementById("name").value;
    email = document.getElementById("email").value;
    id = document.getElementById("cpf").value;
    age = document.getElementById("age").value;
    estate = document.getElementById("pf_estate").value;
    cep = document.getElementById("pf_cep").value;
    description = document.getElementById("pf_description").value;
    skill = document.getElementById("pf_skills").value;
}
function checkDataCandidato() {
    if (nome.match(/[a-zA-Z\u00C0-\u00FF ]+/gi) == null || nome.match(/\d/g) != null || nome == "") {
        document.getElementById("return-info").innerHTML = "Nome inválido!";
        document.getElementById("return-info").style.color = "red";
        return false;
    }
    if ((email.match(/\S+@\w+\.\w{2,6}(\.\w{2})?/g)) == null) {
        document.getElementById("return-info").innerHTML = "Email inválido!";
        document.getElementById("return-info").style.color = "red";
        return false;
    }
    if ((id.match(/([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/)) == null) {
        document.getElementById("return-info").innerHTML = "CPF inválido!";
        document.getElementById("return-info").style.color = "red";
        return false;
    }
    if (age == "" || age.match(/\d{1,2}/) == null || age.length > 2) {
        document.getElementById("return-info").innerHTML = "Idade inválida!";
        document.getElementById("return-info").style.color = "red";
        return false;
    }
    if (estate.match(/[a-zA-Z\u00C0-\u00FF ]+/gi) == null || estate.match(/\d/g) != null || estate == "") {
        document.getElementById("return-info").innerHTML = "Estado inválido!";
        document.getElementById("return-info").style.color = "red";
        return false;
    }
    if ((cep.match(/\d{5}-?\d{3}/)) == null) {
        document.getElementById("return-info").innerHTML = "CEP inválido!";
        document.getElementById("return-info").style.color = "red";
        return false;
    }
    if (description == "") {
        document.getElementById("return-info").innerHTML = "Descrição inválida!";
        document.getElementById("return-info").style.color = "red";
        return false;
    }
    if (skill.match(/\D+/g) == null || skill == "") {
        document.getElementById("return-info").innerHTML = "Habilidades inválidas!";
        document.getElementById("return-info").style.color = "red";
        return false;
    }
    return true;
}
function createCandidato() {
    getDataCandidato();
    if (!checkDataCandidato()) {
        return;
    }
    let person = new Candidato(nome, email, id, age, estate, cep, description);
    let arr_skills = skill.split(',');
    for (let i = 0; i < arr_skills.length; i++) {
        person.addSkill(arr_skills[i]);
    }
    workers.push(person);
    sessionStorage.setItem("workersArray", JSON.stringify(workers));
    sessionStorage.setItem("employersArray", JSON.stringify(employers));
    window.location.href = 'candidate.html';
}
function showCandidatoInfo(type) {
    let size = workers.length - 1;
    let arr = workers;
    document.getElementById("show-name").innerHTML = arr[size]._name;
    document.getElementById("show-email").innerHTML = arr[size]._email;
    document.getElementById("show-id").innerHTML = arr[size]._id;
    document.getElementById("show-age").innerHTML = arr[size]._age;
    document.getElementById("show-estate").innerHTML = arr[size]._estate;
    document.getElementById("show-cep").innerHTML = arr[size]._cep;
    document.getElementById("show-description").innerHTML = arr[size]._description;
}
function showCandidatosList(type) {
    let arr = workers;
    const element_list = document.getElementById("list-values");
    for (let i = 0; i < arr.length; i++) {
        const p = document.createElement("p");
        const x = arr[i];
        let y = "Idade: " + x._age + " anos. " + "Descrição: " + x._description + ". Local: CEP " + x._cep + ", " + x._estate;
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
