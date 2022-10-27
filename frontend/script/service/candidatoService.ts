function createAccount(type: number): void {
    let name: string = (document.getElementById("name") as HTMLInputElement).value;
    if (name.match(/[a-zA-Z\u00C0-\u00FF ]+/gi) == null || name.match(/\d/g) != null  || name == "" ) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "Nome inválido!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return
    }

    let email: string = (document.getElementById("email") as HTMLInputElement).value
    if ((email.match(/\S+@\w+\.\w{2,6}(\.\w{2})?/g)) == null) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "Email inválido!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return
    }

    let id: string, age: string = "", country: string = ""
    if (type) {
        id = (document.getElementById("cpf") as HTMLInputElement).value
        if ((id.match(/([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/)) == null) {
            (document.getElementById("return-info") as HTMLInputElement).innerHTML = "CPF inválido!";
            (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
            return
        }

        age = (document.getElementById("age") as HTMLInputElement).value
        if (age == "" || age.match(/\d{1,2}/) == null || age.length > 2) {
            (document.getElementById("return-info") as HTMLInputElement).innerHTML = "Idade inválida!";
            (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
            return
        }
    } else {
        id = (document.getElementById("cnpj") as HTMLInputElement).value
        if ((id.match(/([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})/)) == null) {
            (document.getElementById("return-info") as HTMLInputElement).innerHTML = "CNPJ inválido!";
            (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
            return
        }
        
        country = (document.getElementById("country") as HTMLInputElement).value
        if (country.match(/[a-zA-Z\u00C0-\u00FF ]+/gi) == null || country.match(/\d/g) != null  || country == "" ) {
            (document.getElementById("return-info") as HTMLInputElement).innerHTML = "País inválido!";
            (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
            return
        }
    }

    let estate: string, cep: string, description: string, skill: string
    if (type) {
        estate = (document.getElementById("pf_estate") as HTMLInputElement).value
        cep = (document.getElementById("pf_cep") as HTMLInputElement).value
        description = (document.getElementById("pf_description") as HTMLInputElement).value
        skill = (document.getElementById("pf_skills") as HTMLInputElement).value
    } else {
        estate = (document.getElementById("pj_estate") as HTMLInputElement).value
        cep = (document.getElementById("pj_cep") as HTMLInputElement).value
        description = (document.getElementById("pj_description") as HTMLInputElement).value
        skill = (document.getElementById("pj_skills") as HTMLInputElement).value
    }

    if (estate.match(/[a-zA-Z\u00C0-\u00FF ]+/gi) == null || estate.match(/\d/g) != null  || estate == "" ) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "Estado inválido!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return
    }

    if ((cep.match(/\d{5}-?\d{3}/)) == null) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "CEP inválido!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return
    }

    if (description == "" ) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "Descrição inválida!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return
    }

    if (skill.match(/\D+/g) == null || skill == "" ) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "Habilidades inválidas!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return
    }
    
    let person
    if (type) {
        person = new Candidato(name, email, id, age, estate, cep, description);
    } else {
        person = new Empresa(name, email, id, country, estate, cep, description);
    }
    let arr_skills = skill.split(',')
    for (let i = 0; i < arr_skills.length; i++) {
        person.addSkill(arr_skills[i])
    }

    if (type) {
        workers.push(person)
    } else {
        employers.push(person)
    }
    sessionStorage.setItem("workersArray", JSON.stringify(workers))
    sessionStorage.setItem("employersArray", JSON.stringify(employers))
    if (type) {
        window.location.href = 'candidate.html'
    } else {
        window.location.href = 'business.html'
    }
}
