<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="modelDao.EjemplarDao"%>
<%@page import="model.Ejemplar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<title>Future Library</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary" style="height: 7em">
		<div class="container-fluid">
			<a class="navbar-brand" href="./index.jsp" style="font-size:35px">Future Library</a>
			<div class="collapse navbar-collapse" id="navbarColor01">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link active"
						href="AutorController?accion=readAutor" style="font-size: 22px">Autores</a></li>
					<li class="nav-item"><a class="nav-link active" href="ClienteController?accion=readCliente"
						style="font-size: 22px">Clientes</a></li>
					<li class="nav-item"><a class="nav-link active" href="EjemplarController?accion=readEjemplar"
						style="font-size: 22px">Ejemplares</a></li>
					<li class="nav-item"><a class="nav-link active" href="#"
						style="font-size: 22px">Libros</a></li>
					<li class="nav-item"><a class="nav-link active" href="#"
						style="font-size: 22px">Prestamos</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div>
	<%
		EjemplarDao dao = new EjemplarDao();
		int Id = Integer.parseInt((String) request.getAttribute("id"));
		Ejemplar ejemplar = (Ejemplar) dao.read(Id);
		%>
		<h1  style="margin: 1em;font-size: 3em">Modificar Ejemplar</h1>
		<form action="EjemplarController">
			<h3 style="margin-left: 35%">ID:</h3><br> <input type="text" name="txtId" class="form-control" value="<%=ejemplar.getId()%>" style="width: 25%;margin-left: 35%"><br>
			<h3 style="margin-left: 35%">Estado:</h3><br> <input type="text" name="txtEstado" class="form-control" value="<%=ejemplar.getEstado()%>" style="width: 25%;margin-left: 35%"><br>
			<h3 style="margin-left: 35%">ISBN:</h3><br> <input type="text" name="txtISBN" class="form-control" value="<%=ejemplar.getISBN()%>" style="width: 25%;margin-left: 35%"><br>
			<input type="submit" name="accion" value="Modificar" style="margin-left: 35%" class="btn btn-outline-success"><a href="EjemplarController?accion=readEjemplar" style="margin-left: 18%" class="btn btn-info">Volver</a>
		</form>
		
	</div>
</body>
</html>