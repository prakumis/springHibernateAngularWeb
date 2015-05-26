<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script>
function deleteEmp(id) {
	
}
</script>
<h1>
	Welcome message :
	<c:out value="${message}"></c:out>
</h1>
<table border="1" id="">
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Designation</th>
	<th>Actions</th>
</tr>
<c:forEach var="emp" items="${empList}" varStatus="status">
	<tr>
		<td>${emp.id}</td>
		<td>${emp.firstName} ${emp.lastName}</td>
		<td>${emp.lastName}</td>
		<td><a href="${pageContext.request.contextPath}/emp/view/${emp.id}">View</a> 
		| <a href="#" onclick="return edit('${pageContext.request.contextPath}/emp/edit?empId=${emp.id}')">Edit</a>
		| <a href="#" onclick="return removeEmp('${pageContext.request.contextPath}/emp/delete?empId=${emp.id}')">Delete</a></td>
	</tr>
</c:forEach>
</table>
<a href="${pageContext.request.contextPath}/emp/new">Create New</a>
