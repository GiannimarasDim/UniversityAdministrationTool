<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/update.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Courses Found</title>

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

	<%-- <div>
		<table>
			<tr>
				<th>ID</th>
				<th>Description</th>
				<th>Teacher's Id</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>
			<c:choose>
			<c:when test="${isCourse}">
			<tr>
					<td>${course.id}</td>
					<td>${course.description}</td>
					<td>${course.teacherId}</td>
					<td><a
						href="${pageContext.request.contextPath}/DeleteCourseController?id=${course.id}
					&description=${course.description}&teacherid=${course.teacherId}">Delete</a></td>
					<td><a
						href="${pageContext.request.contextPath}/jsps/courseupdate.jsp?id=${course.id}
					&description=${course.description}&teacherid=${course.teacherId}">Update</a></td>
				</tr>
			</c:when>
			<c:otherwise>
			<c:forEach var="course" items="${courses}">
				<tr>
					<td>${course.id}</td>
					<td>${course.description}</td>
					<td>${course.teacherId}</td>
					<td><a
						href="${pageContext.request.contextPath}/DeleteCourseController?id=${course.id}
					&description=${course.description}&teacherid=${course.teacherId}">Delete</a></td>
					<td><a
						href="${pageContext.request.contextPath}/jsps/courseupdate.jsp?id=${course.id}
					&description=${course.description}&teacherid=${course.teacherId}">Update</a></td>
				</tr>
			</c:forEach>
			</c:otherwise>
			</c:choose>
		</table>
	</div> --%>

<table class="table" >
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Description</th>
      <th scope="col">Teacher's Id </th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  
  
  <tbody>
	<c:choose>
	<c:when test="${isCourse}">
    <tr>
      
      <td>${course.id}</td>
      <td>${course.description}</td>
      <td>${course.teacherId}</td>
      <td><a
						href="${pageContext.request.contextPath}/DeleteCourseController?id=${course.id}
					&description=${course.description}&teacherid=${course.teacherId}">Delete</a></td>
					<td><a
						href="${pageContext.request.contextPath}/jsps/courseupdate.jsp?id=${course.id}
					&description=${course.description}&teacherid=${course.teacherId}">Update</a></td>
    </tr>
    		</c:when>
			<c:otherwise>
			<c:forEach var="course" items="${courses}">
    			 <tr>
      
      <td>${course.id}</td>
      <td>${course.description}</td>
      <td>${course.teacherId}</td>
      <td><a
						href="${pageContext.request.contextPath}/DeleteCourseController?id=${course.id}
					&description=${course.description}&teacherid=${course.teacherId}">Delete</a></td>
					<td><a
						href="${pageContext.request.contextPath}/jsps/courseupdate.jsp?id=${course.id}
					&description=${course.description}&teacherid=${course.teacherId}">Update</a></td>
    </tr>
    	</c:forEach>
			</c:otherwise>
			</c:choose>
  </tbody>
</table>
	

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