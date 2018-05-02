<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Quản lý sinh viên</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
        <base href="${pageContext.servletContext.contextPath}/">
         
          
</head>
<body>

    <h2>Quản lý sinh viên</h2>
   


    <br>            
    

    <table border="1">
        <tr>
            <td>Masv</td>
            <td>Name</td>
     
        </tr>
        <c:forEach var="rows" items="${listDeparts}">
            <form action="student99/delete.html">
            <tr>
                <td>${rows.id}</td>
                <td>${rows.name}</td>

                <c:url var="edit" value="student99/edit.html">
                    <c:param name="txtMasv" value="${rows.id}"/>
                    <c:param name="txtName" value="${rows.name}"/>

                </c:url>
                <td><a href="${edit}">Edit</a></td>
                <td>
                    <input type="hidden" name="txtMasv" value="${rows.id}"/>
                    <input type="submit" name="Delete" value="Delete"/>
                </td>
            </tr>
            
            </form>
        </c:forEach>    
    </table>
    
    
    

</body>
</html>
