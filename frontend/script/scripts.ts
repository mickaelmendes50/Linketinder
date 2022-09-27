let pfs: PessoaFisica[] = []
let pjs: PessoaJuridica[] = []

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
    let email: string = (document.getElementById("email") as HTMLInputElement).value

    if (type) {
        let id: string = (document.getElementById("cpf") as HTMLInputElement).value;
        let age: string = (document.getElementById("age") as HTMLInputElement).value
        let estate: string = (document.getElementById("pf_estate") as HTMLInputElement).value
        let cep: string = (document.getElementById("pf_cep") as HTMLInputElement).value
        let description: string = (document.getElementById("pf_description") as HTMLInputElement).value

        let person = new PessoaFisica(name, email, id, age, estate, cep, description);
        pfs.push(person)
    } else {
        let id: string = (document.getElementById("cnpj") as HTMLInputElement).value
        let country: string = (document.getElementById("country") as HTMLInputElement).value
        let estate: string = (document.getElementById("pj_estate") as HTMLInputElement).value
        let cep: string = (document.getElementById("pj_cep") as HTMLInputElement).value
        let description: string = (document.getElementById("pj_description") as HTMLInputElement).value

        let person = new PessoaJuridica(name, email, id, country, estate, cep, description);
        pjs.push(person)
    }
}
