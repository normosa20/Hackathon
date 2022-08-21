<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

</head>

<body>
	<nav class="navbar navbar-expand-sm p-0">
		<div class="container">
			<button class="navbar-toggler" data-bs-toggle="collapse"
				data-bs-target="#navbarCollapse">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse py-3" id="navbarCollapse">
				<c:if test="${user != null}">
					<h3 class="text-dark mt-4">
						<c:out value="${user.userName}" />
					</h3>
				</c:if>
				<ul class="navbar-nav ms-auto">
					<c:if test="${user != null}">
						<li class="nav-item"><a href="/logout" class="nav-link">Logout</a>
						</li>
					</c:if>
					<c:if test="${user == null}">
						<li class="nav-item"><a href="/login" class="nav-link">Login</a>
						</li>
					</c:if>
					<li class="nav-item"><a href="/" class="nav-link ">Home</a></li>
					<li class="nav-item"><a href="/about" class="nav-link">About</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container d-flex justify-content-between mt-4">
		<div
			class="container d-flex row justify-content-center  p-4 position-absolute top-50 start-50 translate-middle">
			<h2 class="text-success text-center">About the website</h2>
			<h4 class="text-center">Web Site that achieves environmental
				sustainability and preserves it from desertification, and the
				environment is the main focus for the sustainability of life and one
				of the most dangerous factors that negatively affect the
				sustainability of the environment is desertification.</h4>
			<div class="card mt-4 m-4text-center" style="width: 18rem;">
				<img src="/images/home/Donations.jpg" class="card-img-top mt-4" alt="...">
				<div class="card-body">
					<h5>
						<a href="/items" class="card-title text-center "> Donations </a>
					</h5>
				</div>
			</div>
			<div class="card mt-4 m-4 text-center" style="width: 18rem;">
				<img src="/images/home/deserts.jpg" class="card-img-top mt-4 ">
				<div class="card-body ">
					<h5>
						<a href="/dersert" class="card-title text-center">Report
							Desertification</a>
					</h5>
				</div>
			</div>
		</div>
	</div>
</body>
</html>