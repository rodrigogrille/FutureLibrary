<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
					<li class="nav-item"><a class="nav-link active" href="#"
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
		ClienteDao dao = new ClienteDao();
		String Dni = (String) request.getAttribute("id");
		Cliente cliente = (Cliente) dao.read(Dni);
		%>
		<h1  style="margin: 1em;font-size: 3em">Modificar Cliente</h1>
		<form action="ClienteController">
			<h3 style="margin-left: 35%">DNI:</h3><br> <input type="text" name="txtDNI" class="form-control" value="<%=cliente.getDni()%>" style="width: 25%;margin-left: 35%"><br>
			<h3 style="margin-left: 35%">Nombre:</h3><br> <input type="text" name="txtNombre" class="form-control" value="<%=cliente.getNombre()%>" style="width: 25%;margin-left: 35%"><br>
			<h3 style="margin-left: 35%">Telefono:</h3><br> <input type="text" name="txtTelefono" class="form-control" value="<%=cliente.getTelefono()%>" style="width: 25%;margin-left: 35%"><br>
			<h3 style="margin-left: 35%">Direccion:</h3><br> <input type="text" name="txtDireccion" class="form-control" value="<%=cliente.getDireccion()%>" style="width: 25%;margin-left: 35%"><br>
			<h3 style="margin-left: 35%">Correo:</h3><br> <input type="text" name="txtCorreo" class="form-control" value="<%=cliente.getCorreo()%>" style="width: 25%;margin-left: 35%"><br>
			<input type="submit" name="accion" value="Modificar" style="margin-left: 35%" class="btn btn-outline-success"><a href="ClienteController?accion=readCliente" style="margin-left: 18%" class="btn btn-info">Volver</a>
		</form>
		
	</div>
</body>
</html>