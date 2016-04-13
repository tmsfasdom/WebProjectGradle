<jsp:useBean id="Hello" class="br.com.tmsfasdom.business.Hello"/>
<html>
<head>
<title>
Pagina de Teste Java
</title>
</head>
<body>
<p>
<img alt="Embedded Image" src="data:image/png;base64,${Hello.sayHello('Fernando')}" />
</p>
</body>
</html>