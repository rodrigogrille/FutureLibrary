<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
		<h1 style="margin: 1em;font-size: 3em">Ejemplares</h1>
		<a class="btn btn-outline-light btn-lg" href="EjemplarController?accion=createEjemplar" style="margin-left: 20%">Crear Ejemplar</a>
		<table class="table table-hover" style="width: 60%;margin-left: 20%">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Estado</th>
					<th scope="col">ISBN</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<%
			EjemplarDao dao = new EjemplarDao();
			List<Ejemplar> list = dao.read();
			Iterator<Ejemplar> iter = list.iterator();
			Ejemplar ejemplar = null;
			while (iter.hasNext()) {
				ejemplar = iter.next();
			%>
			<tr class="table-secondary">
				<td scope="col"><%=ejemplar.getId()%></td>
				<td scope="col"><%=ejemplar.getEstado()%></td>
				<td scope="col"><%=ejemplar.getISBN()%></td>
				<td scope="col"><a class="btn btn-outline-warning"
					href="EjemplarController?accion=updateEjemplar&id=<%=ejemplar.getId()%>">Modificar</a>
					<a class="btn btn-outline-danger" href="EjemplarController?accion=deleteEjemplar&id=<%=ejemplar.getId()%>">Borrar</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<a class="btn btn-info btn-lg" href="./index.jsp" style="margin-top: 2em;margin-left: 20%">Volver</a>
	</div>
</body>
</html>