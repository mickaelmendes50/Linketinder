function getDataCandidato(): void {
    nome = (document.getElementById("name") as HTMLInputElement).value;
    email = (document.getElementById("email") as HTMLInputElement).value
    id = (document.getElementById("cpf") as HTMLInputElement).value
    age = (document.getElementById("age") as HTMLInputElement).value
    estate = (document.getElementById("pf_estate") as HTMLInputElement).value
    cep = (document.getElementById("pf_cep") as HTMLInputElement).value
    description = (document.getElementById("pf_description") as HTMLInputElement).value
    skill = (document.getElementById("pf_skills") as HTMLInputElement).value
}

function checkDataCandidato(): boolean {
    if (nome.match(/[a-zA-Z\u00C0-\u00FF ]+/gi) == null || nome.match(/\d/g) != null  || nome == "" ) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "Nome inválido!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return false
    }

    if ((email.match(/\S+@\w+\.\w{2,6}(\.\w{2})?/g)) == null) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "Email inválido!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return false
    }
        
    if ((id.match(/([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/)) == null) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "CPF inválido!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return false
    }

    if (age == "" || age.match(/\d{1,2}/) == null || age.length > 2) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "Idade inválida!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return false
    }

    if (estate.match(/[a-zA-Z\u00C0-\u00FF ]+/gi) == null || estate.match(/\d/g) != null  || estate == "" ) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "Estado inválido!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return false
    }

    if ((cep.match(/\d{5}-?\d{3}/)) == null) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "CEP inválido!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return false
    }

    if (description == "" ) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "Descrição inválida!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return false
    }

    if (skill.match(/\D+/g) == null || skill == "" ) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "Habilidades inválidas!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return false
    }

    return true
}

function createCandidato(): void {
    getDataCandidato()

    if (!checkDataCandidato()) {
        return
    }
    
    let person = new Candidato(nome, email, id, age, estate, cep, description);

    let arr_skills = skill.split(',')
    for (let i = 0; i < arr_skills.length; i++) {
        person.addSkill(arr_skills[i])
    }

    workers.push(person)

    sessionStorage.setItem("workersArray", JSON.stringify(workers))
    sessionStorage.setItem("employersArray", JSON.stringify(employers))
    
    window.location.href = 'candidate.html'
}

function showCandidatoInfo(type: number) {
    let size = workers.length -1;
    let arr: Candidato[] = workers;
    
    (document.getElementById("show-name") as HTMLInputElement).innerHTML = arr[size]._name;
    (document.getElementById("show-email") as HTMLInputElement).innerHTML = arr[size]._email;
    (document.getElementById("show-id") as HTMLInputElement).innerHTML = arr[size]._id;
    (document.getElementById("show-age") as HTMLInputElement).innerHTML = arr[size]._age;
    (document.getElementById("show-estate") as HTMLInputElement).innerHTML = arr[size]._estate;
    (document.getElementById("show-cep") as HTMLInputElement).innerHTML = arr[size]._cep;
    (document.getElementById("show-description") as HTMLInputElement).innerHTML = arr[size]._description;
}

function showCandidatosList(type: number) {
    let arr: Candidato[] = workers

    const element_list = document.getElementById("list-values")

    for (let i = 0; i < arr.length; i++) {
        const p = document.createElement("p");
        const x = arr[i]
        
        let y= "Idade: " + x._age + " anos. " + "Descrição: " + x._description + ". Local: CEP " + x._cep + ", " + x._estate
        
        let z = "Habilidades: "
        for (let j = 0; j < (x._skills).length; j++) {
            z += x._skills[j] + "; "
        }
        
        let text = document.createTextNode(z + y)
        p.appendChild(text)

        let img = document.createElement("img")
        img.setAttribute("src", "assets/heart-icon.png")
        img.setAttribute("class", "heart-icon")
        
        element_list?.appendChild(p)
        element_list?.appendChild(img)
    }
}
