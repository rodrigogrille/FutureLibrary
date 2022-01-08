<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	<h1>Añadir Autor</h1>
	<form action="AutorController">
		ID:<br>
		<input type="text" name="txtID"><br>
		Nombre:<br>
		<input type="text" name="txtNombre"><br>
		<input type="submit" name="accion" value="Crear"><br>
	</form>
	<a href="AutorController?accion=readAutor">Volver</a>
	</div>
</body>
</html>