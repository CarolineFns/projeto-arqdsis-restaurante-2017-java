<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="bean.CardapioTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Card�pio</title>
</head>
<body>

		<%CardapioTO cardapio = (CardapioTO)request.getAttribute("cardapio"); %>
		Id: <%=cardapio.getId() %><br>
		Tipo: <%=cardapio.getTipo() %><br>
		Descri��o: <%=cardapio.getDescricao() %><br>
		Pre�o: <%=cardapio.getPreco() %><br>
		Disponibilidade: <%=cardapio.getDisponibilidade() %><br>

</body>
</html>