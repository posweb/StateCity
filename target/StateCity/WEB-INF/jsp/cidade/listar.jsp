<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de Cidades</title>
</head>
<body>
	${message}<br/>
	<h3>Listagem de cidades</h3><br/>
	<a href="<c:url value='/cidade/adicionar'/>" >adicionar</a>
	<br/>
	<a href="<c:url value='/'/>" >voltar</a>
	<br/>
	<br/>
	<ul>
	<c:forEach items="${cidades}" var="cidade" >
		<div>
			<div>
				<span>${cidade.codigo} ${cidade.nome} ${cidade.cep}</span>
				<span>
					<a href="<c:url value='/cidade/editar/${cidade.codigo}'/>" >editar</a>
				</span>
				<span>
					<a href="<c:url value='/cidade/deletar/${cidade.codigo}'/>" >deletar</a>
				</span>
			</div>
		</div>
	</c:forEach>
	</ul>
</body>
</html>