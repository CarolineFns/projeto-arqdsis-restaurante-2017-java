<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="bean.CardapioTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cardápio</title>
</head>
<body>

		<%CardapioTO cardapio = (CardapioTO)request.getAttribute("cardapio"); %>
		Id: <%=cardapio.getId() %><br>
		Tipo: <%=cardapio.getTipo() %><br>
		Descrição: <%=cardapio.getDescricao() %><br>
		Preço: <%=cardapio.getPreco() %><br>
		Disponibilidade: <%=cardapio.getDisponibilidade() %><br>

</body>
</html>