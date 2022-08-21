<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deserts Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous"></head>
</head>
<body>
<div>
	<nav class="navbar sticky-top ">
    <div class="container-fluid">
     <c:choose>
      <c:when test="${user != null}">
           <h3 class="text-dark mt-4"><c:out value="${user.userName}" />!</h3>
           <a href="/logout" class="navbar-brand">Logout</a>
      </c:when>
            <c:otherwise>
                <div>
                    <a href="/login" class="navbar-brand">Login</a>
                </div>
            </c:otherwise>
        </c:choose>
     <a class="navbar-brand" href="/">Home</a>
    <a class="navbar-brand" href="/about">About</a>
   
  </div>
</nav>
</div>
	<div class="container mt-4">
	<form:form action="/dersert" method="post" modelAttribute="some_company" enctype="multipart/form-data">
        <div class="form-group mt-4">
          
            <form:input path="name" class="form-control" placeholder=" Name"/>
            <form:errors path="name" class="text-danger" />
        </div>
        <div class="form-group mt-4">
          
            <form:input path="phone" class="form-control"  placeholder="Phone Number" />
            <form:errors path="phone" class="text-danger" />
        </div>
        <div class="form-group mt-4">
         
            <form:input path="description" class="form-control" placeholder="Description"/>
            <form:errors path="description" class="text-danger" />
        </div>
        <div class="form-group mt-4">
			
            <form:input path="address" class="form-control" placeholder="Address"/>
            <form:errors path="address" class="text-danger" />
        </div>
			 <div class="input-group mt-4 mb-3">
			  <input type="file" class="form-control" id="inputGroupFile02" name="report_image">
			</div>
        <input type="submit" value="Register" class="btn btn-success mt-4" />
    </form:form>
    </div>
</body>
</html>