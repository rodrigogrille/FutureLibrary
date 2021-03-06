<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="modelDao.AutorDao"%>
<%@page import="model.Autor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
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
					<li class="nav-item"><a class="nav-link active" href="LibroController?accion=readLibro"
						style="font-size: 22px">Libros</a></li>
					<li class="nav-item"><a class="nav-link active" href="PrestamoController?accion=readPrestamo"
						style="font-size: 22px">Prestamos</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div>
		<%
		AutorDao dao = new AutorDao();
		int id = Integer.parseInt((String) request.getAttribute("id"));
		Autor autor = (Autor) dao.read(id);
		%>
		<h1 style="margin: 1em;font-size: 3em">Modificar Autor</h1>
		<form action="AutorController">
			<h3 style="margin-left: 35%">ID:</h3>
			<br> <input type="text" name="txtID" value="<%=autor.getId()%>"
				class="form-control" style="width: 25%; margin-left: 35%"><br>
			<h3 style="margin-left: 35%">Nombre:</h3>
			<br> <input type="text" name="txtNombre"
				value="<%=autor.getNombre()%>" class="form-control"
				style="width: 25%; margin-left: 35%"><br> <input
				type="submit" name="accion" value="Modificar" class="btn btn-outline-warning" style="margin-left: 35%"><a href="AutorController?accion=readAutor" style="margin-left: 18%" class="btn btn-info">Volver</a>
		</form>
		
	</div>
</body>
</html>