<!doctype html>
<%@ page import="is2.Alumno"%>
<%@ page import="is2.Curso"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
Alumnos:
  <ul>
    <%
    	for (Alumno a : Alumno.findAll()) {
    %>
  <li><%=a.getId()%> - <%=a.getApellido()%></li>
    <%
    	}
    %>
  </ul>
Cursos:
  <ul>
    <%
    	for (Curso c : Curso.findAll()) {
    %>
  <li><%=c.getCodigo()%> - <%=c.getNombre()%></li>
    <%
    	}
    %>
  </ul>
</body>
</html>
