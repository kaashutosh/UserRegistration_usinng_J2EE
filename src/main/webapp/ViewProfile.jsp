<%@page import="aashu.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String fName = (String)request.getAttribute("fname");
UserBean ub =  (UserBean)application.getAttribute("ubean");
out.println("Page belongs to User : "+fName+"<br>");
out.println(ub.getFname()+"&nbsp&nbsp"+ub.getlName()+"&nbsp&nbsp"+ub.getAddr()+"&nbsp&nbsp"+ub.getMid()+"&nbsp&nbsp"+ub.getPhno()+"&nbsp&nbsp"+"<a href='edit'>Edit</a>");
%>
<a href="logout">Logout</a>
</body>
</html>