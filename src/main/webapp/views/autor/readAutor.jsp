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
<title>Insert title here</title>
</head>
<body>
	<div>
	<h1>Autores</h1>
	<a href="AutorController?accion=createAutor">Crear Autor</a>
 <table border="1">
  <tr>
    <th>ID</th>
    <th>Nombre</th>
    <th>Acciones</th>
  </tr>
  <%
  	AutorDao dao=new AutorDao();
  	List<Autor>list = dao.read();
  	Iterator<Autor>iter=list.iterator();
  	Autor autor=null;
  	while(iter.hasNext()) {
  		autor=iter.next();
  %>
  <tr>
    <td><%= autor.getId()%></td>
    <td><%= autor.getNombre()%></td>
    <td><a href="AutorController?accion=updateAutor&id=<%=autor.getId()%>">Modificar</a>
    <a href="AutorController?accion=deleteAutor&id=<%=autor.getId()%>">Borrar</a></td>
  </tr>
  <%}%>
</table>
<a href="./index.jsp">Volver</a>
	</div>
</body>
</html>