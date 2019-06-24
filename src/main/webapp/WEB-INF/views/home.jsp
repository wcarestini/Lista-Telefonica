<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">



</head>
	<body>
		<div class="container">
			<h1 class="display-4">Lista de contatos</h1>
			<hr>
			<h1>${sucesso}</h1>
		<table class="table table-bordered table-striped table-dark">	
		<tr>
			<th scope="col">Nome</th>
			<th scope="col">Telefone</th>
			<th scope="col">e-mail</th>
		</tr>
		<form:form action="${s:mvcUrl('HC#home').build() }" commandName="contato">
			<tr>
				<td>
					<form:input path="name" type="text" class="form-control" placeholder="Nome" aria-label="Nome" aria-describedby="basic-addon1"/>
				</td>
				
				<td>
					<form:input path="phone" type="text" class="form-control" placeholder="Telefone" aria-label="Telefone" aria-describedby="basic-addon1"/>
				</td>
				
				<td>
					<form:input path="email" type="text" class="form-control" placeholder="E-mail" aria-label="E-mail" aria-describedby="basic-addon1"/>
				</td>
				
				<td>
					<button type="submit" class="btn btn-light">Busca</button>
				</td>
			</tr>
		</form:form>
			
				<c:forEach items="${contatos }" var="contato">
					<tr>	
						<td>${contato.name }</td>
						<td>${contato.phone }</td>
						<td>${contato.email }</td>       
						
						<td><button type="button" class="btn btn-light"><a href="${s:mvcUrl('CC#delete').arg(0, [contato.name]).build() } ">Remover</a></button></td>
						<td><button type="button" class="btn btn-light"><a href="${s:mvcUrl('CC#modelUpdate').arg(0, [contato.name]).build() } ">Editar</a></button></td>
					</tr>						
				</c:forEach>
			
		</table>
			<hr>
			
			<button type="button" class="btn btn-light">
				<a href="${s:mvcUrl('CC#form').build() }">Cadastrar</a>
			</button>
			
			
			
		</div>	
	</body>
</html>