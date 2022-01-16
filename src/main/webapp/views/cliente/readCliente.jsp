<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelDao.ClienteDao"%>
<%@page import="model.Cliente"%>
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
					<li class="nav-item"><a class="nav-link active" href="#"
						style="font-size: 22px">Prestamos</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div>
		<h1 style="margin: 1em;font-size: 3em">Clientes</h1>
		<a class="btn btn-outline-light btn-lg" href="ClienteController?accion=createCliente" style="margin-left: 20%">Crear Cliente</a>
		<table class="table table-hover" style="width: 60%;margin-left: 20%">
			<thead>
				<tr>
					<th scope="col">DNI</th>
					<th scope="col">Nombre</th>
					<th scope="col">Telefono</th>
					<th scope="col">Direccion</th>
					<th scope="col">Correo</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<%
			ClienteDao dao = new ClienteDao();
			List<Cliente> list = dao.read();
			Iterator<Cliente> iter = list.iterator();
			Cliente cliente = null;
			while (iter.hasNext()) {
				cliente = iter.next();
			%>
			<tr class="table-secondary">
				<td scope="col"><%=cliente.getDni()%></td>
				<td scope="col"><%=cliente.getNombre()%></td>
				<td scope="col"><%=cliente.getTelefono()%></td>
				<td scope="col"><%=cliente.getDireccion()%></td>
				<td scope="col"><%=cliente.getCorreo()%></td>
				<td scope="col"><a class="btn btn-outline-warning"
					href="ClienteController?accion=updateCliente&id=<%=cliente.getDni()%>">Modificar</a>
					<a class="btn btn-outline-danger" href="ClienteController?accion=deleteCliente&id=<%=cliente.getDni()%>">Borrar</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<a class="btn btn-info btn-lg" href="./index.jsp" style="margin-top: 2em;margin-left: 20%">Volver</a>
	</div>
</body>
</html>