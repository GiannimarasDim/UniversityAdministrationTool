<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teachers Found</title>

</head>
<body>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>

			<c:forEach var="teacher" items="${teachers}">
				<tr>
					<td>${teacher.id}</td>
					<td>${teacher.fname}</td>
					<td>${teacher.sname}</td>
					<td><a
						href="${pageContext.request.contextPath}/delete?id=${teacher.id}
					&fname=${teacher.fname}&sname=${teacher.sname}">Delete</a></td>
					<td><a
						href="${pageContext.request.contextPath}/jsps/teacherupdate.jsp?id=${teacher.id}
					&fname=${teacher.fname}&sname=${teacher.sname}">Update</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div>
		<c:if test="${deleteAPIError}">
			<p>Something went wrong in Delete</p>
		</c:if>
	</div>

	<div>
		<c:if test="${updateAPIError}">
			<p>Something went wrong in Update</p>
		</c:if>
	</div>


</body>
</html>