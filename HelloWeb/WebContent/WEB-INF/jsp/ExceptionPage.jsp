<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Spring MVC Exception Handling</title>
</head>
<body>

<h2>Spring MVC Exception Handling</h2>

<h3>${exception.exceptionMsg}</h3>

</body>
</html>
下面是 Spring 视图文件 result.jsp 的内容：


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Student Information</h2>
   <table>
   <tr>
   <td>Name</td>
   <td>${name}</td>
   </tr>
   <tr>
   <td>Age</td>
   <td>${age}</td>
   </tr>
   <tr>
   <td>ID</td>
   <td>${id}</td>
   </tr>
   </table>  
</body>
</html>