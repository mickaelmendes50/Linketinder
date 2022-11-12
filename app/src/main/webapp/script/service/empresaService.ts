function getDataEmpresa(): void {
    nome = (document.getElementById("name") as HTMLInputElement).value
    email = (document.getElementById("email") as HTMLInputElement).value
    id = (document.getElementById("cnpj") as HTMLInputElement).value
    country = (document.getElementById("country") as HTMLInputElement).value
    estate = (document.getElementById("pj_estate") as HTMLInputElement).value
    cep = (document.getElementById("pj_cep") as HTMLInputElement).value
    description = (document.getElementById("pj_description") as HTMLInputElement).value
    skill = (document.getElementById("pj_skills") as HTMLInputElement).value
}

function checkDataEmpresa(): boolean {
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
    
    if ((id.match(/([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})/)) == null) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "CNPJ inválido!";
        (document.getElementById("return-info") as HTMLInputElement).style.color = "red"
        return false
    }
    
    if (country.match(/[a-zA-Z\u00C0-\u00FF ]+/gi) == null || country.match(/\d/g) != null  || country == "" ) {
        (document.getElementById("return-info") as HTMLInputElement).innerHTML = "País inválido!";
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

function createEmpresa(): void {
    getDataEmpresa()

    if (!checkDataEmpresa()) {
        return
    }

    let empresa = new Empresa(nome, email, id, country, estate, cep, description);

    let arr_skills = skill.split(',')
    for (let i = 0; i < arr_skills.length; i++) {
        empresa.addSkill(arr_skills[i])
    }

    employers.push(empresa)

    sessionStorage.setItem("workersArray", JSON.stringify(workers))
    sessionStorage.setItem("employersArray", JSON.stringify(employers))

    window.location.href = 'business.html'
}

function showEmpresaInfo() {
    let size = employers.length - 1;
    let arr: Empresa[] = employers;
    
    (document.getElementById("show-name") as HTMLInputElement).innerHTML = arr[size]._name;
    (document.getElementById("show-email") as HTMLInputElement).innerHTML = arr[size]._email;
    (document.getElementById("show-id") as HTMLInputElement).innerHTML = arr[size]._id;
    (document.getElementById("show-country") as HTMLInputElement).innerHTML = arr[size]._country;
    (document.getElementById("show-estate") as HTMLInputElement).innerHTML = arr[size]._estate;
    (document.getElementById("show-cep") as HTMLInputElement).innerHTML = arr[size]._cep;
    (document.getElementById("show-description") as HTMLInputElement).innerHTML = arr[size]._description;
}

function showEmpresasList() {
    let arr: Empresa[] = employers;

    const element_list = document.getElementById("list-values")

    for (let i = 0; i < arr.length; i++) {
        const p = document.createElement("p");
        const x = arr[i]
        
        let y = "Descrição: " + x._description + ". Local: CEP " + x._cep + ", " + x._estate + " - " + x._country        
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
