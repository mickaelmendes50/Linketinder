<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/styles.css">

    <title>Linketinder</title>
</head>
<body onload="initialize()">
<div id="header">
    <h1 id="title">LinkeTinder</h1>
    <hr class="rounded">
    <h3 id="subtitle">Vamos dar um match?</h3>
</div>

<div id="forms">
    <form id="p-account">
        <b><h3 id="return-info"></h3></b><br>
        <label for="name">Nome</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="email">Email</label><br>
        <input type="text" id="email" name="email"><br>

        <input type="radio" id="empresa" name="priority" value="empresa" onclick="displayEnable('forms-business'), displayDisable('forms-candidate')">
        <label for="priority">Empresa</label>
        <input type="radio" id="candidato" name="priority" value="candidato" onclick="displayEnable('forms-candidate'), displayDisable('forms-business')">
        <label for="priority">Candidato</label>
    </form>
</div>

<div id="forms-business">
    <form id="pj-account">
        <label for="cnpj">CNPJ</label><br>
        <input type="text" id="cnpj" name="cnpj"><br>
        <label for="country">País</label><br>
        <input type="text" id="country" name="country"><br>
        <label for="pj_estate">Estado</label><br>
        <input type="text" id="pj_estate" name="pj_estate"><br>
        <label for="pj_cep">CEP</label><br>
        <input type="text" id="pj_cep" name="pj_cep"><br>
        <label for="pj_description">Descrição</label><br>
        <input type="text" id="pj_description" name="pj_description"><br>
        <label for="pj_skills">Habilidades (Separe por vírgula)</label><br>
        <input type="text" id="pj_skills" name="pj_skills"><br>

        <button id="button-business" type="button" onclick="createEmpresa()">Criar conta</button>
    </form>
</div>

<div id="forms-candidate">
    <form id="pf-account">
        <label for="cpf">CPF</label><br>
        <input type="text" id="cpf" name="cpf"><br>
        <label for="age">Idade</label><br>
        <input type="text" id="age" name="age"><br>
        <label for="pf_estate">Estado</label><br>
        <input type="text" id="pf_estate" name="pf_estate"><br>
        <label for="pf_cep">CEP</label><br>
        <input type="text" id="pf_cep" name="pf_cep"><br>
        <label for="pf_description">Descrição</label><br>
        <input type="text" id="pf_description" name="pf_description"><br>
        <label for="pf_skills">Habilidades (Separe por vírgula)</label><br>
        <input type="text" id="pf_skills" name="pj_skills"><br>

        <button id="button-candidate" type="button" onclick="createCandidato()">Criar conta</button>
    </form>
</div>

<script src="script/scripts.js"></script>
<script src="script/entity/Pessoa.js"></script>
<script src="script/entity/Candidato.js"></script>
<script src="script/entity/Empresa.js"></script>
<script src="script/service/empresaService.js"></script>
<script src="script/service/candidatoService.js"></script>
</body>
</html>
