<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Efetue seu Login</title>
</head>
  <body>
    <h2>Página de Login</h2>
    <form action="login" method="post">
    <!-- <input type="hidden" name="userId" value=0/>
     -->
      Login: <input type="text" name="userName" /> <br /> 
      Senha: <input type="password" name="password" /> <br />
      <input type="submit" value="Logar" /> 
    </form>
  </body>
</html>