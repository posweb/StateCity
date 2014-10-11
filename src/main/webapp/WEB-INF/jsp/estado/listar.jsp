<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de Estados</title>
</head>
<body>
	${message}<br/>
	<h3>Listagem de estados</h3>
	<br/>
	<a href="<c:url value='/estado/adicionar'/>" >adicionar</a>
	<br/>
	<a href="<c:url value='/'/>" >voltar</a>
	<br/>
	<br/>
	<ul>
	<c:forEach items="${estados}" var="estado" >
		<div>
			<div>
				<span>${estado.codigo} ${estado.nome} ${estado.uf}</span>
				<span>
					<a href="<c:url value='/estado/editar/${estado.codigo}'/>" >editar</a>
				</span>
				<span>
					<a href="<c:url value='/estado/deletar/${estado.codigo}'/>" >deletar</a>
				</span>
			</div>
		</div>
	</c:forEach>
	</ul>
</body>
</html>