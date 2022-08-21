<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <!DOCTYPE html>
        <html>

        <head>
          <meta charset="UTF-8">
          <title>Home</title>
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
          <link rel="stylesheet" href="/CSS/style.css">

        </head>

        <body>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
            crossorigin="anonymous"></script>

          <nav class="navbar  navbar-expand-sm p-0">
            <div class="container">
              <button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse py-3" id="navbarCollapse">
                <h3 class="text-dark mt-4">
                  <c:out value="${user.userName}" />
                </h3>
                
                <ul class="navbar-nav">
                  <li class="nav-item">
                    <a href="/logout" class="nav-link">Logout</a>
                  </li>
                  <li class="nav-item">
                    <a href="/" class="nav-link ">Home</a>
                  </li>
                  <li class="nav-item">
                    <a href="/about" class="nav-link">About</a>
          <img src="/images/pic/Vector 1.png"  style="left:335px;">
                  </li>
                </ul>
              </div>
            </div>


        
          </nav>


          </div>

          <div class="container row justify-content-between mt-4">
            <div
              class="container ">
              <div class="title">
                <h1>${item.title}</h1>
              </div>
              <div class="img"><img style="width: 200px;" src="${item.img}"></div>
              <div class="Donaite">
                <h2>Donaite Remaind</h2>
              </div>
              <div class="price">
                <h5>${item.targetPrice} SAR</h5>
              </div>
              <form:form action="/items/${item.id}/order" method="post">

                <div class="submit"><input type="submit" value="${item.price} SAR Donate Amount" class="btn btn-success mt-4" /> </div>
              </form:form>
              
              <div class="info">
                <h2>Information</h2>
              </div>
              <div class="description">
                <h5>${item.description}</h5>
              </div>
            </div>
          </div>
          
          
        </body>

        </html>