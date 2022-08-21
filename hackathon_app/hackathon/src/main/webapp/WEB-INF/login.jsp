<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <!DOCTYPE html>
      <html>

      <head>
        <meta charset="UTF-8">
        <title>Login</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
      </head>
      </head>

      <body>
        <nav class="navbar navbar-expand-sm p-0">
          <div class="container">
            <button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse py-3" id="navbarCollapse">
              <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                  <a href="/" class="nav-link ">Home</a>
                </li>
                <li class="nav-item">
                  <a href="/about" class="nav-link">About</a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
        <div class="container d-flex row justify-content-center mt-4">
          <h3 class="text-center mt-4">Lets Contribute to increasing the</h3>
          <h3 class="text-center"> greenness of our environment</h3>
          <div class="d-flex col-10 justify-content-evenly">
            <form:form action="/login" method="post" modelAttribute="newLogin">


              <div class="form-group mt-4">

                <form:input path="email" class="form-control" placeholder="Enter your email " />
                <form:errors path="email" class="text-danger" />
              </div>
              <div class="form-group mt-4">
                <form:password path="password" class="form-control" placeholder="Enter your password" />
                <form:errors path="password" class="text-danger" />
              </div>
              <input type="submit" value="Login" class="btn btn-success mt-4" />
              <p class="mt-4"> Don't have an account?<a href="/logReg" class="text-success mt-4"> Register Now</a></p>
            </form:form>
          </div>
        </div>
      </body>

      </html>