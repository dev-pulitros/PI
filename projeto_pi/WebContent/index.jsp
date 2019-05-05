<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastros</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegaÃ§Ã£o -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Login</h3>
		<form action="ManterProfessor.do" method="post">
			<div class="form-group col-md-6">
				<label for="matricula">Matricula</label>
				<input class="form-control" type="text" name="matricula" id="matricula" placeholder="Matricula" required maxlength="15">
			</div><br/>
			<div class="form-group col-md-6">
				<label for="senha">Senha</label>
				<Input class="form-control" type="password" name="senha" id="senha" placeholder="senha" required maxlength="60">
			</div>
			<div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="Login">Entrar</button>
                </div>
            </div>
		</form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>