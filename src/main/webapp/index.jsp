<!doctype html>
<%@page import="repository.jpa.JpaCursoDao"%>
<%@ page import="is2.Alumno"%>
<%@ page import="is2.Curso"%>
<%@ page import="repository.CursoDao"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
Alumnos:

Cursos:
  <ul>
    <%
    	CursoDao f = new JpaCursoDao();
    	for (Curso c : f.findAll()) {
    %>
  <li><%=c.getId()%> - <%=c.getNombre()%></li>
    <%
    	}
    %>
  </ul>
</body>
</html>
