<%@page import="bean.CardapioTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cardápio</title>
</head>
<body>

<c:import url="menu.jsp"/>
<div id="main" class="container">
<h3 class="page-header">Visualizar Cardapio #${cardapio.id}</h3>
<div class="row">
<div class="col-md-12">


		Id: ${cardapio.id}<br>
		Tipo: ${cardapio.tipo}<br>
		Descrição: ${cardapio.descricao}<br>
		Preço: ${cardapio.preco}<br>
		Disponibilidade: ${cardapio.disponibilidade}<br>
</div>

</div>
</div>

</body>
</html>
