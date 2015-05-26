<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<p id="errorMessages">${errorMessage}</p>
<p id="successMessage">${successMessage}</p>

<table>
	<tr>
		<td width="40%">Employee Id</td>
		<td>${emp.id} - ${emp}</td>
	</tr>
	<tr>
		<td width="40%">First Name</td>
		<td>${emp.id} - ${emp.firstName}</td>
	</tr>
	<tr>
		<td width="40%">Last Name</td>
		<td>${emp.id} - ${emp.lastName}</td>
	</tr>
	<tr>
		<td colspan="2"><a href="${pageContext.request.contextPath}/emp/" >Back to Employee List</a> | 
		<a href="#" onclick="return edit('${pageContext.request.contextPath}/emp/edit?empId=${emp.id}')">Edit Employee</a></td>
	</tr>
</table>
