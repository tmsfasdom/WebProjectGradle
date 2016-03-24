<jsp:useBean id="HelloWorld" class="br.com.tmsfasdom.business.Hello"/>
<html>
<head>
<title>
Pagina de Teste Java
</title>
</head>
<body>
<p>
<img alt="Embedded Image" src="data:image/png;base64,${HelloWorld.sayHello('Fernando')}" />
</p>
</body>
</html>