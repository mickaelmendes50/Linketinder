let workers: PessoaFisica[] = []
let employers: PessoaJuridica[] = []

function displayEnable(id: string) {
    const element = document.getElementById(id)
    if (element != null) {
        element.style.display = 'block'
    }
}

function displayDisable(id: string) {
    const element = document.getElementById(id)
    if (element != null) {
        element.style.display = 'none'
    }
}

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
        person = new PessoaFisica(name, email, id, age, estate, cep, description);
    } else {
        person = new PessoaJuridica(name, email, id, country, estate, cep, description);
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

function initialize() {
    // Instâncias predefindias para testes
    let worker = new PessoaFisica("João", "joao@worker.com", "123.456.789-01", "23", "Goiás", "74659-156", "Legal e extrovertido")
    worker.addSkill("Java")
    worker.addSkill("C++")
    worker.addSkill("Python")
    workers.push(worker)
    worker = new PessoaFisica("Maria", "maria@worker.com", "456.789.101-11", "32", "São Paulo", "86551-785", "Chata e introvertida")
    worker.addSkill("Java")
    worker.addSkill("C#")
    worker.addSkill("Ruby")
    workers.push(worker)
    worker = new PessoaFisica("Pedro", "pedro@worker.com", "789.101.112-13", "25", "Pernambuco", "95125-532", "Sábio e inteligente")
    worker.addSkill("C#")
    worker.addSkill("Ruby")
    worker.addSkill("Python")
    workers.push(worker)
    worker = new PessoaFisica("Marta", "marta@worker.com", "101.112.131-41", "20", "Ceará", "75369-159", "Educada e amorosa")
    worker.addSkill("JavaScript")
    worker.addSkill("TypeScript")
    worker.addSkill("Java")
    workers.push(worker)
    worker = new PessoaFisica("José", "jose@worker.com", "112.131.415-01", "40", "Bahia", "96325-452", "Triste e dramático")
    worker.addSkill("Ruby")
    worker.addSkill("Python")
    worker.addSkill("JavaScript")
    workers.push(worker)    

    // Instâncias predefindias para testes
    let employer = new PessoaJuridica("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa")
    employer.addSkill("Liderança")
    employer.addSkill("Experiencia")
    employers.push(employer)
    employer = new PessoaJuridica("Google", "google@employer.com", "12.345.678/0001-10", "Estados Unidos", "Califórnia", "75369-159", "Tecnologia")
    employer.addSkill("Formação superior")
    employer.addSkill("Gestão")
    employers.push(employer)
    employer = new PessoaJuridica("Ford", "ford@employer.com", "12.345.678/0001-10", "Estados Unidos", "Dearborn", "86551-785", "Carros")
    employer.addSkill("Experiencia")
    employer.addSkill("Vendas")
    employers.push(employer)
    employer = new PessoaJuridica("Xiaomi", "xiaomi@employer.com", "12.345.678/0001-10", "China", "Haidian", "74659-156", "Celulares")
    employer.addSkill("Formacao superior")
    employer.addSkill("Vendas")
    employers.push(employer)
    employer = new PessoaJuridica("Polishop", "polishop@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "95125-532", "Eletrodomesticos")
    employer.addSkill("Liderança")
    employer.addSkill("Gestão")
    employers.push(employer)
}

function restoreContent(type: number) {
    let storedWorkers = JSON.parse(sessionStorage.workersArray);
    for (let i = 0; i < storedWorkers.length; i++) {
        workers.push(storedWorkers[i])
    }

    let storedEmployers = JSON.parse(sessionStorage.employersArray);
    for (let i = 0; i < storedEmployers.length; i++) {
        employers.push(storedEmployers[i])
    }
    
    if (type) {
        const size = workers.length - 1
        const accName = document.getElementById("acc-name") as HTMLInputElement
        accName.innerHTML = workers[size]._name
    } else {
        const size = employers.length - 1
        const accName = document.getElementById("acc-name") as HTMLInputElement
        accName.innerHTML = employers[5]._name        
    }
}

function showInfo(type: number) {
    let size
    let arr = []
    if (type) {
        size = workers.length -1;
        arr = workers
    } else {
        size = employers.length - 1;
        arr = employers
    }
    
    (document.getElementById("show-name") as HTMLInputElement).innerHTML = arr[size]._name;
    (document.getElementById("show-email") as HTMLInputElement).innerHTML = arr[size]._email;
    (document.getElementById("show-id") as HTMLInputElement).innerHTML = arr[size]._id;
    if (type) {
        (document.getElementById("show-age") as HTMLInputElement).innerHTML = arr[size]._age;
    } else {
        (document.getElementById("show-country") as HTMLInputElement).innerHTML = arr[size]._country;
    }
    (document.getElementById("show-estate") as HTMLInputElement).innerHTML = arr[size]._estate;
    (document.getElementById("show-cep") as HTMLInputElement).innerHTML = arr[size]._cep;
    (document.getElementById("show-description") as HTMLInputElement).innerHTML = arr[size]._description;
}

function showList(type: number) {
    let arr = []
    if (type) {
        arr = workers
    } else {
        arr = employers
    }

    const element_list = document.getElementById("list-values")

    for (let i = 0; i < arr.length; i++) {
        const p = document.createElement("p");
        const x = arr[i]
        
        let y
        if (type) {
            y = "Idade: " + x._age + " anos. " + "Descrição: " + x._description + ". Local: CEP " + x._cep + ", " + x._estate
        } else {
            y = "Descrição: " + x._description + ". Local: CEP " + x._cep + ", " + x._estate + " - " + x._country
        }
        
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