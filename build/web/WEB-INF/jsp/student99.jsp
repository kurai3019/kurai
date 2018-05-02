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
   
    <form:form action="student99.html" modelAttribute="student">
        <div class="caca">Mã SV</div>
        <form:input path="masv" readonly="true"/>
        <div>Họ và tên</div>
        <form:input path="name"/>
        
        <div>Điểm</div>
        <form:input path="mark"/>

          <div>Chuyên ngành</div>
                <form:select path="major" items="${majors}" 
                itemLabel="name" itemValue="id"/>

        <div>
            <button name="btnInsert">Thêm</button>
            <button name="btnUpdate">Cập nhật</button>    
        </div>
                <form:input path="tim"/>            <button name="btnSearch">Tìm kiếm</button>            

        
    </form:form>

    <br>            
    

    <table border="1">
        <tr>
            <td>Masv</td>
            <td>Name</td>
            <td>Mark</td>
            <td>Major</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="rows" items="${listStudent}">
            <form action="student99/delete.html">
            <tr>
                <td>${rows.masv}</td>
                <td>${rows.name}</td>
                <td>${rows.mark}</td>
                <td>${rows.major}</td>
                <c:url var="edit" value="student99/edit.html">
                    <c:param name="txtMasv" value="${rows.masv}"/>
                    <c:param name="txtName" value="${rows.name}"/>
                    <c:param name="txtMark" value="${rows.mark}"/>
                    <c:param name="txtMajor" value="${rows.major}"/>
                </c:url>
                <td><a href="${edit}">Edit</a></td>
                <td>
                    <input type="hidden" name="txtMasv" value="${rows.masv}"/>
                    <input type="submit" name="Delete" value="Delete"/>
                </td>
            </tr>
            
            </form>
        </c:forEach>    
    </table>
    
        <table border="1">
        <tr>
            <td>Masv</td>
            <td>Name</td>
            <td>Mark</td>
            <td>Major</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="rows" items="${listStudent}">
            <form action="student99/delete.html">
            <tr>
                <td>${rows.ID}</td>
                <td>${rows.Namee}</td>
            
                <c:url var="edit" value="student99/edit.html">
                    <c:param name="txtMasv" value="${rows.ID}"/>
                    <c:param name="txtName" value="${rows.Name}"/>

                </c:url>
                <td><a href="${edit}">Edit</a></td>
                <td>
                    <input type="hidden" name="txtMasv" value="${rows.ID}"/>
                    <input type="submit" name="Delete" value="Delete"/>
                </td>
            </tr>
            
            </form>
        </c:forEach>    
    </table>
    

</body>
</html>
