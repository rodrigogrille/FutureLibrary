<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="modelDao.LibroDao"%>
<%@page import="model.Libro"%>
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
	<%
		LibroDao dao = new LibroDao();
		String Id = (String) request.getAttribute("id");
		Libro libro = (Libro) dao.read(Id);
		%>
		<h1  style="margin: 1em;font-size: 3em">Modificar Libro</h1>
		<form action="LibroController">
			<h3 style="margin-left: 35%">ISBN:</h3><br> <input type="text" name="txtIsbn" class="form-control" value="<%=libro.getIsbn()%>" style="width: 25%;margin-left: 35%"><br>
			<h3 style="margin-left: 35%">Numero Paginas:</h3><br> <input type="text" name="txtNPaginas" class="form-control" value="<%=libro.getNum_pag()%>" style="width: 25%;margin-left: 35%"><br>
			<h3 style="margin-left: 35%">Titulo:</h3><br> <input type="text" name="txtTitulo" class="form-control" value="<%=libro.getTitulo()%>" style="width: 25%;margin-left: 35%"><br>
			<h3 style="margin-left: 35%">Editorial:</h3><br> <input type="text" name="txtEditorial" class="form-control" value="<%=libro.getEditorial()%>" style="width: 25%;margin-left: 35%"><br>
			<h3 style="margin-left: 35%">ID Autor:</h3><br> <input type="text" name="txtIdAutor" class="form-control" value="<%=libro.getId_autor()%>" style="width: 25%;margin-left: 35%"><br>
			<input type="submit" name="accion" value="Modificar" style="margin-left: 35%" class="btn btn-outline-success"><a href="LibroController?accion=readLibro" style="margin-left: 18%" class="btn btn-info">Volver</a>
		</form>
		
	</div>
</body>
</html>