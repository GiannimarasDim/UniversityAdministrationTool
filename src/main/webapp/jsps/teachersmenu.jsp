<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teachers Search</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/teachersmenu.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <img
					src="${pageContext.request.contextPath}/static/img/aueb100b.png"
					alt="AUEB 100 years">
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/jsps/index.jsp">Αρχική</a></li>
      <li><a href="${pageContext.request.contextPath}/jsps/teachersmenu.jsp">Teachers Menu</a></li>
      <li><a href="${pageContext.request.contextPath}/jsps/studentsmenu.jsp">Students Menu</a></li>
      <li><a href="${pageContext.request.contextPath}/jsps/coursesmenu.jsp">Courses Menu</a></li>
    </ul>
  </div>
</nav>

	<div class="center">

		<div class="search-wrapper">
			<div class="bot-gap">
				<span class="title">Teachers Search</span>
			</div>
			<div class="bot-gap">
				<form method="GET"
					action="${pageContext.request.contextPath}/search">
					<input name="lastname" type="text" class="search rounded"
						placeholder="Insert teacher's lastname" autofocus /> <br>
					<br>
					<button class="search-btn rounded color-btn" type="submit">Search</button>
				</form>
			</div>
		</div>

		<div class="insert-wrapper">
			<div class="bot-gap">
				<span class="title">Teachers Insert</span>
			</div>
			<div class="bot-gap">
				<form method="POST"
					action="${pageContext.request.contextPath}/insert">
					<input name="lastName" type="text" class="insert rounded"
						placeholder="Last name" autofocus /><br> <input
						name="firstName" type="text" class="insert rounded"
						placeholder="First name" autofocus /> <br>
					<br>
					<button class="search-btn rounded color-btn" type="submit">Insert</button>
				</form>
			</div>
		</div>
	</div>

	<div class="center">
		<c:if test="${sqlError}">
			<p>Error in insert. Please try again</p>
		</c:if>
	</div>

	<div class="center">
		<c:if test="${teachersNotFound}">
			<p>No teachers found</p>
		</c:if>
	</div>
</body>
</html>

