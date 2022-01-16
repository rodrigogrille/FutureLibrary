<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelDao.AutorDao"%>
<%@page import="model.Autor"%>
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
					<li class="nav-item"><a class="nav-link active" href="LibroController?accion=readLibro"
						style="font-size: 22px">Libros</a></li>
					<li class="nav-item"><a class="nav-link active" href="PrestamoController?accion=readPrestamo"
						style="font-size: 22px">Prestamos</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div>
		<h1 style="margin: 1em;font-size: 3em">Autores</h1>
		<a class="btn btn-outline-light btn-lg" href="AutorController?accion=createAutor" style="margin-left: 20%">Crear Autor</a>
		<table class="table table-hover" style="width: 60%;margin-left: 20%">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nombre</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<%
			AutorDao dao = new AutorDao();
			List<Autor> list = dao.read();
			Iterator<Autor> iter = list.iterator();
			Autor autor = null;
			while (iter.hasNext()) {
				autor = iter.next();
			%>
			<tr class="table-secondary">
				<td scope="col"><%=autor.getId()%></td>
				<td scope="col"><%=autor.getNombre()%></td>
				<td scope="col"><a class="btn btn-outline-warning"
					href="AutorController?accion=updateAutor&id=<%=autor.getId()%>">Modificar</a>
					<a class="btn btn-outline-danger" href="AutorController?accion=deleteAutor&id=<%=autor.getId()%>">Borrar</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<a class="btn btn-info btn-lg" href="./index.jsp" style="margin-top: 2em;margin-left: 20%">Volver</a>
	</div>
</body>
</html>