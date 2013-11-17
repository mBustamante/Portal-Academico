<!doctype html>
<%@page import="is2.repository.jpa.JpaCursoDao"%>
<%@ page import="is2.domain.Alumno"%>
<%@ page import="is2.domain.Curso"%>
<%@ page import="is2.repository.CursoDao"%>
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
