<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses Search</title>
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
				<span class="title">Courses Search</span>
			</div>
			<div class="bot-gap">
				<form method="GET"
					action="${pageContext.request.contextPath}/GetCourseController">
					<input name="description" type="text" class="search rounded"
						placeholder="Insert course 's Description" autofocus /> <br>
					<br>
					<button class="search-btn rounded color-btn" type="submit">Search</button>
					</form>
					
					<form method="GET"
					action="${pageContext.request.contextPath}/GetAllCoursesController">
					<button class="search-btn rounded color-btn" type="submit">Get All Courses</button>
					</form>
			</div>
		</div>

		<div class="insert-wrapper">
			<div class="bot-gap">
				<span class="title">Courses Insert</span>
			</div>
			<div class="bot-gap">
				<form method="POST"
					action="${pageContext.request.contextPath}/InsertCourse">
					<input name="description" type="text" class="insert rounded"
						placeholder="Course's Description" autofocus /><br> <input
						name="teacherid" type="text" class="insert rounded"
						placeholder="Teacher's Id" autofocus /> <br>
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
		<c:if test="${coursesNotFound}">
			<p>No courses found</p>
		</c:if>
	</div>
</body>
</html>
