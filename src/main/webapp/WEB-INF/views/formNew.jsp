<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>
<body>
	

	<div class="container">
		<button type="button" class="btn btn-light">
				<a href="${s:mvcUrl('HC#home').build() }">Voltar</a>
			</button>
	
		<h1 class="display-4">Cadastro de contatos</h1>
	
		<form:form action="${s:mvcUrl('CC#write').build() }" method="POST" commandName="contato">
			<div class="form-group">
				<label>Nome</label>
				<form:input path="name"  type="text" class="form-control" placeholder="Nome" />
			</div>
			<div>
				<label>Telefone</label>
				<form:input path="phone"  type="text" class="form-control" placeholder="Telefone" />
			</div>
			<div>
				<label>e-mail</label>
				<form:input path="email" type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com" />
			</div>
			<button type="submit" class="btn btn-success" >Salvar</button>
		</form:form>
	</div>
</body>
</html>