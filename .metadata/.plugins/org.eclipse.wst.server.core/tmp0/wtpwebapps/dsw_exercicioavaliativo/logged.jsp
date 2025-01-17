<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<% var usuarioLogado = session.getAttribute("user");
		if(usuarioLogado == null){
			response.sendRedirect("/front.do?action=getLoginPage");
		}
	%>

	<h2>Logged</h2>
</body>
</html>