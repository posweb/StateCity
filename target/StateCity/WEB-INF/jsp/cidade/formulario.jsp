<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar Cidade</title>
</head>
<body>
	<h3>Editar estado</h3>
	<c:url value="/cidade/salvar" var="saveuri" />
	<form action="${saveuri}" method="POST">
		<label for="id">Código:</label>
		<input type="text" name="cidade.codigo" value="${cidade.codigo}">
		
		<label for="id">Nome:</label>
		<input type="text" name="cidade.nome" value="${cidade.nome}">
		
		<label for="id">CEP:</label>
		<input type="text" name="cidade.cep" value="${cidade.cep}">
		
		<input type="submit" value="Salvar">
	</form>
</body>
</html>