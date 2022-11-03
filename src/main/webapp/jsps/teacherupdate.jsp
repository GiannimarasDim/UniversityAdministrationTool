<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/update.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Teacher Update</title>

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

	<div >
		<form   style="margin: auto; width: 220px;" method="GET" action="${pageContext.request.contextPath}/update">
			<input type="text" name="id" value="${param.id}" placeholder="Id"><br> <input
				type="text" name="fname" value="${param.fname}" placeholder="Όνομα"><br> <input
				type="text" name="sname" value="${param.sname}" placeholder="Επώνυμο"><br>
			<br>
			<button type="submit">Update Teacher</button>
		</form>
	</div>

</body>
</html>