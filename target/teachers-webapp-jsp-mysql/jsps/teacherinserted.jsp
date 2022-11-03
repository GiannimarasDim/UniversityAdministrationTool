<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Επιτυχής Εισαγωγή</title>
</head>
<body>
	<h1>Teacher inserted successfully</h1>
	<div>
		<p>${insertedTeacher.sname}</p>
		<p>${insertedTeacher.fname}</p>
		<p></p>
	</div>

	<div>
		<a href="${pageContext.request.contextPath}/jsps/teachersmenu.jsp">Επιστροφή</a>
	</div>
</body>
</html>