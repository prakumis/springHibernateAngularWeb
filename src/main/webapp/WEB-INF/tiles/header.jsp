<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div id="header">
<a id="logo" href="#" target="_blank"><img
	src="<%=request.getContextPath()%>/resources/images/app_logo.png" height="64" width="66"/></a>
<a id="headerName" href="${pageContext.request.contextPath}/welcome">JDK7 JEE5 GIT MAVEN ECLIPSE SPRING SECURITY MVC || REST HTML5 HIBERNATE</a>

<div id="rightSide">

	<div id="welcome"><b>Logged in as:</b></div>${loggedInUser.firstName} ${loggedInUser.lastName}

		<a id="logoutLink" href="<c:url value="/j_spring_security_logout"/>"  title="Logout"><img 
		src="<%=request.getContextPath()%>/resources/images/logout.png" style="height: 20px;" /></a>
		<a id="logoutLink" href="<c:url value="/logout"/>"  title="Logout"><img 
		src="<%=request.getContextPath()%>/resources/images/logout.png" style="height: 20px;" /></a>
</div>
</div>

<div id="color_line"></div>
