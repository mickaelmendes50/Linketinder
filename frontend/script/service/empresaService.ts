let nome: string
let email: string
let id: string
let country: string
let estate: string
let cep: string
let description: string
let skill: string

function getData(): void {
    nome = (document.getElementById("name") as HTMLInputElement).value
    email = (document.getElementById("email") as HTMLInputElement).value
    id = (document.getElementById("cnpj") as HTMLInputElement).value
    country = (document.getElementById("country") as HTMLInputElement).value
    estate = (document.getElementById("pj_estate") as HTMLInputElement).value
    cep = (document.getElementById("pj_cep") as HTMLInputElement).value
    description = (document.getElementById("pj_description") as HTMLInputElement).value
    skill = (document.getElementById("pj_skills") as HTMLInputElement).value
}

function checkData(): boolean {
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
    getData()

    if (!checkData()) {
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
