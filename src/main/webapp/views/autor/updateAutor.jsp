<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="modelDao.AutorDao"%>
<%@page import="model.Autor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%
		AutorDao dao = new AutorDao();
		int id= Integer.parseInt((String)request.getAttribute("id"));
		Autor autor=(Autor)dao.read(id);
		%>
		<h1>Modificar Autor</h1>
		<form action="AutorController">
			ID:<br> <input type="text" name="txtID" value="<%=autor.getId()%>"><br>
			Nombre:<br> <input type="text" name="txtNombre" value="<%= autor.getNombre()%>"><br>
			<input type="submit" name="accion" value="Modificar"><br>
		</form>
		<a href="AutorController?accion=readAutor">Volver</a>
	</div>
</body>
</html>