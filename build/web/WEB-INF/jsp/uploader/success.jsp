<%@ page pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.servletContext.contextPath}/">
	<meta charset="utf-8"/>
	<title>Tiêu đề</title>
</head>
<body>
	<img src="images/${name}"  width="110px" height="148px">
	<ul>
            <li>File Name: ${name}</li>
            <li>File Type: ${type}</li>
            <li>File Size: ${size}</li>
	</ul>
        
</body>
</html>
