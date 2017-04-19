<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Criar Cardapio</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/style.css" rel="stylesheet">
</head>
<body>
<!-- Barra superior com os menus de navegacao -->
<c:import url="menu.jsp"/>
<!-- Container Principal -->
<div id="main" class="container">
<h3 class="page-header">Incluir Cardapio</h3>
<!-- Formulario para inclusao de cardapio -->
<form action="crudCardapio" method="post">
<!-- area de campos do form -->


<div class="row">
<div class="form-group col-md-12">
<label for="tipo">Tipo</label>
<input type="text" class="form-control" name="tipo" id="tipo"
required maxlength="100" placeholder="tipo">
</div>
</div>


<div class="row">
<div class="form-group col-md-6">
<label for="disponilidade">Disponibilidade</label>
<input type="text" class="form-control" name="disponibilidade" id="disponibilidade"
required maxlength="100" placeholder="disponibilidade">
</div>
</div>

<div class="row">
<div class="form-group col-md-6">
<label for="descricacao">Descrição</label>
<input type="text" class="form-control" name="descricao" id="descricao"
required maxlength="100" placeholder="descrição">
</div>
</div>


<div class="row">
<div class="form-group col-md-6">
<label for="preco">Preço</label>
<input type="text" class="form-control" name="preco" id="preco"
maxlength="100"  placeholder="preço">
</div>
</div>


<hr />
<div id="actions" class="row">
<div class="col-md-12">
<button type="submit" class="btn btn-primary" name="acao"
value="Criar">Salvar</button>
<a href="index.html" class="btn btn-default">Cancelar</a>
</div>
</div>
</form>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>