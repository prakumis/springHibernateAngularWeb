<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head> 
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/login.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footer.css" />
	<title>Application Home</title>
</head>

<body>
		<div id="header">
			<a id="logo"  href="#" target="_blank"><img src="<%=request.getContextPath()%>/resources/images/econ-white.jpg" /></a>
			<p id="headerName">GURUKUL ONLINE</p>
		</div>
		
		<div id="color_line"></div>
		
		<div id="body">
			<div id="outer_wrapper">
			<div id="inner_wrapper">
			<div id="left_block">
				<div id="QED_picture"></div>
			</div>
			
			<div id="right_block">
				<div id="loginSection">
					<%--	<form name='f' action="<c:url value='j_spring_security_check' />"  id="form1" method='POST'> --%>
					<form name="loginForm" action="${pageContext.request.contextPath}/validateuser" id="loginForm" method="POST" modelAttribute="user">
						<p id="logoutMessage" class="red">You have successfully logged out.</p>
						<div id="loginholder">
						<p class="applicationFont">Login Here:</p>
				<div class="botloginarea">
					<div class="login">userName</div>
					<div class="logintxtbox">
						<label for="textfield"></label> <input type="text" name="userName"
							id="userName" placeholder="userName" class="txtbox" />
					</div>
				</div>
				<div class="botloginarea">
					<div class="login">Password</div>
					<div class="logintxtbox">
						<label for="textfield"></label> <input type="password"
							name="password" id="password" placeholder="Password"
							class="txtbox" />
					</div>
				</div>
				<div class="botloginarealast">
					<div class="login">&nbsp;</div>
					<div class="signholder">
						<input type="submit" value="Submit" id="loginBtn"/> <input type="reset"
							value="Reset" />
					</div>
				</div>
					</form>
				</div>
			</div>
			</div>
			</div>
		</div>
		
			<div class="color_line"></div>
<!-- Footer Part Start -->
<div id="footer">
	<p id="creditDesign">Designer: <a href="mailto:praveenkumarmishra@mycompany.com">Praveen Kumar Mishra</a></p>
</div>
		
	</body>
</html>