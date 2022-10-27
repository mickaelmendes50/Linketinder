let workers: Candidato[] = []
let employers: Empresa[] = []

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

function initialize() {
    // Instâncias predefindias para testes
    let worker = new Candidato("João", "joao@worker.com", "123.456.789-01", "23", "Goiás", "74659-156", "Legal e extrovertido")
    worker.addSkill("Java")
    worker.addSkill("C++")
    worker.addSkill("Python")
    workers.push(worker)
    worker = new Candidato("Maria", "maria@worker.com", "456.789.101-11", "32", "São Paulo", "86551-785", "Chata e introvertida")
    worker.addSkill("Java")
    worker.addSkill("C#")
    worker.addSkill("Ruby")
    workers.push(worker)
    worker = new Candidato("Pedro", "pedro@worker.com", "789.101.112-13", "25", "Pernambuco", "95125-532", "Sábio e inteligente")
    worker.addSkill("C#")
    worker.addSkill("Ruby")
    worker.addSkill("Python")
    workers.push(worker)
    worker = new Candidato("Marta", "marta@worker.com", "101.112.131-41", "20", "Ceará", "75369-159", "Educada e amorosa")
    worker.addSkill("JavaScript")
    worker.addSkill("TypeScript")
    worker.addSkill("Java")
    workers.push(worker)
    worker = new Candidato("José", "jose@worker.com", "112.131.415-01", "40", "Bahia", "96325-452", "Triste e dramático")
    worker.addSkill("Ruby")
    worker.addSkill("Python")
    worker.addSkill("JavaScript")
    workers.push(worker)    

    // Instâncias predefindias para testes
    let employer = new Empresa("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa")
    employer.addSkill("Liderança")
    employer.addSkill("Experiencia")
    employers.push(employer)
    employer = new Empresa("Google", "google@employer.com", "12.345.678/0001-10", "Estados Unidos", "Califórnia", "75369-159", "Tecnologia")
    employer.addSkill("Formação superior")
    employer.addSkill("Gestão")
    employers.push(employer)
    employer = new Empresa("Ford", "ford@employer.com", "12.345.678/0001-10", "Estados Unidos", "Dearborn", "86551-785", "Carros")
    employer.addSkill("Experiencia")
    employer.addSkill("Vendas")
    employers.push(employer)
    employer = new Empresa("Xiaomi", "xiaomi@employer.com", "12.345.678/0001-10", "China", "Haidian", "74659-156", "Celulares")
    employer.addSkill("Formacao superior")
    employer.addSkill("Vendas")
    employers.push(employer)
    employer = new Empresa("Polishop", "polishop@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "95125-532", "Eletrodomesticos")
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