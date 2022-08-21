<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="UTF-8">
					<title>Home</title>
					<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
						rel="stylesheet"
						integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
						crossorigin="anonymous">
				</head>
				</head>

				<body>
					<nav class="navbar navbar-expand-sm p-0">
						<div class="container">
							<button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
								<span class="navbar-toggler-icon"></span>
							</button>
							<div class="collapse navbar-collapse py-3" id="navbarCollapse">
										<h3 class="text-dark mt-4">
											<c:out value="${user.userName}" />
											</h3>
								<ul class="navbar-nav ms-auto">
										<li class="nav-item">
											<a href="/logout" class="nav-link">Logout</a>
										</li>
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

					<div class="container d-flex row justify-content-between mt-4">
						<div
							class="container d-flex row justify-content-center  p-4 position-absolute top-50 start-50 translate-middle mt-4">

							<div id="items" class="container mt-4 mb-4 text-center">
								<h1 class="text-blue text-center font-weight-bold m-4" style="font-family:cairo;"></h1>
								<div class="d-flex justify-content-center flex-wrap p-4 mt-4">
									<c:forEach var="item" items="${allItems}">
										<div class="p-2">
											<div class="card  text-center" style="width: 18rem; ">
												<img style="width: 200px;" class="mt-4 mx-4" src="${item.img}">
												<a href="/items/${item.id}">${item.title}</a>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</body>

				</html>