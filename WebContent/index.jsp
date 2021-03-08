<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Estacionamento</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

</head>
<body>
    
	<div style="margin-top: 30px;" class="container">

		<div class="header clearfix">
			<h2>Estacionamento Java Web (servlet,jdbc e mysql)</h2>
		</div>
		<div class="jumbotron">
			<form action="cadastrarVeiculos" method="post" onsubmit="return validar()? true: false" >
				<div class="form-group">
					<label>Modelo do Veículo</label> <input type="text"
						id="modeloCarro" name="modeloCarro" class="form-control">
				</div>

				<div class="form-group">
					<label>Placa do Veículo</label> <input type="text" id="placaCarro"
						name="placaCarro" class="form-control" >
				</div>
				<input type="submit" class="btn btn-primary" value="Adicionar"/>
			</form>
		</div>

		<div class="col-lg-12">

			<table class="table">

				<thead>
					<tr>
						<th scope="col">Modelo</th>
						<th scope="col">Placa</th>
						<th scope="col">Data</th>
						<th scope="col">Horário</th>
						<th scope="col">Excluir</th>
					</tr>
				</thead>
			   <tbody>
			   <c:forEach items="${veiculos }" var="veiculo">
			        <tr>
			         
                     <th scope="row"><c:out value="${veiculo.veiculo }"></c:out></th>
                     <td><c:out value="${veiculo.placa }"></c:out></td>
                     <td><c:out value="${veiculo.dataFormatada }"></c:out></td>
                     <td><c:out value="${veiculo.horaAtual }"></c:out></td>
                     <td><button class="btn btn-danger" ><a class="btn btn-danger"href="cadastrarVeiculos?acao=delete&veiculo=${veiculo.placa }">Excluir</a></button></td>
                     
                  </tr>
                   </c:forEach>
			   </tbody>
			</table>
		</div>

	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>
		
		<script type="text/javascript" src="resources/js/index.js"></script>
</body>
</html>