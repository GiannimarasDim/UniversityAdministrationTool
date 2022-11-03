<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/afterLogin.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Ενημέρωση Επιτυχής</title>
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

	<h1>Νέα Στοιχεία </h1>
	<p>teacher ${teacher.fname}</p>
	<p>teacher ${teacher.sname}</p>
	<a href="${pageContext.request.contextPath}/jsps/teachersmenu.jsp">Επιστροφή</a>
</body>
</html>
