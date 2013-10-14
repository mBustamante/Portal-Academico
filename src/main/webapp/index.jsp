<!doctype html>
<%@ page import="is2.Alumno"%>
<%@ page import="is2.Curso"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
Alumnos:

Cursos:
  <ul>
    <%
    	for (Curso c : Curso.findAll()) {
    %>
  <li><%=c.getId()%> - <%=c.getNombre()%></li>
    <%
    	}
    %>
  </ul>
</body>
</html>
