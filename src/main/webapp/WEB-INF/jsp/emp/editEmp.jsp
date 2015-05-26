<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

Create New Employee: ${emp} <br><br><br>

<form:form id="createEmpForm" method="post" 
	action="${pageContext.request.contextPath}/emp/save" modelAttribute="emp" >
	<table>
		<tr>
			<td width="40%">Employee Id</td>
			<td><input type="text" name="id" id="id"
				value="${emp.id}"
				${not empty emp.id ? 'readonly="readonly"':''}></td>
		</tr>
		<tr>
			<td width="40%">First Name</td>
			<td><input type="text" name="firstName" id="firstName"
				value="${emp.firstName}" ><form:errors path="firstName" cssClass="error" /></td>
		</tr>
		<tr>
			<td width="40%">Last Name</td>
			<td><input type="text" name="lastName" id="lastName"
				value="${emp.lastName}" ><form:errors path="lastName" cssClass="error" /></td>
		</tr>
		<tr><td colspan="2"><input type="submit"></td></tr>
	</table>
</form:form>
