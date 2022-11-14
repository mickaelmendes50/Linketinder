# Linketinder | Vamos dar um match?

### Programa que promove o encontro e o início de um lindo contrato entre empresas e trabalhadores.

Para executar, faça um clone do projeto:
```
git clone https://github.com/mickaelmendes50/Linketinder.git
```
Importe a pasta /Linketinder como um projeto da IntelliJ e então execute com Tomcat

### Banco de Dados
A aplicação foi desenvolvida utilizando o Banco de Dados PostgreSQL. Para criar um modelo de banco de dados compatível com a aplicação utilize essa [Query](https://raw.githubusercontent.com/mickaelmendes50/Linketinder/master/database/postgres.sql).

### APIs
A aplicação utiliza Java Servlets e Tomcat para a implementação de APIs. Foram criados métodos GET e POST, com persistência de dados para as seguintes entidades:
- Candidato
- Empresa
- Vaga

Siga o modelo `http://localhost:8080/linketinder/{entidade}s`

### Linguagens e Tecnologias

- JavaScript
- TypeScript
- Groovy
- Gradle
- Tomcat

##### Desenvolvido por [Mickael Mesquita](https://github.com/mickaelmendes50).
