<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Νέα Στοιχεία Teacher</h1>
	<p>teacher ${teacher.fname}</p>
	<p>teacher ${teacher.sname}</p>
	<a href="${pageContext.request.contextPath}/jsps/teachersmenu.jsp">Επιστροφή</a>
</body>
</html>
