<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ενημέρωση Επιτυχής</title>
</head>
<body>
	<h1>Νέα Στοιχεία </h1>
	<p>teacher ${course.description}</p>
	<p>teacher ${course.teacherId}</p>
	<a href="${pageContext.request.contextPath}/jsps/coursesmenu.jsp">Επιστροφή</a>
</body>
</html>
