<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	
	
		<form action="front.do?action=login" method="post">
			<div>
				<label for="login">Login</label>
				<input type="text" id="email" name="email">
			</div>
			
			<div>
				<label for="senha">Senha</label>
				<input type="text" id="senha" name="senha">
			</div>
			<button type="submit">Entrar</button>
			
		</form>


</body>
</html>