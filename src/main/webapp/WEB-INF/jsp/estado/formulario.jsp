<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar Estado</title>
</head>
<body>
	<h3>Editar cidade</h3>
	<c:url value="/estado/salvar" var="saveuri" />
	<form action="${saveuri}" method="POST">
		<label for="id">Código:</label>
		<input type="text" name="estado.codigo" value="${estado.codigo}">
		
		<label for="id">Nome:</label>
		<input type="text" name="estado.nome" value="${estado.nome}">
		
		<label for="id">UF:</label>
		<input type="text" name="estado.uf" value="${estado.uf}">
		
		<input type="submit" value="Salvar">
	</form>
</body>
</html>