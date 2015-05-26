<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/menu.css" />

<div class="menuWithShadow">
<p class="menuSection">Employee Module (MVC + REST)</p>
<ul id="nav">
 	<li><a href="${pageContext.request.contextPath}/emp/">List Employees (MVC/Tiles/JSP)</a></li>
 	<li><a href="${pageContext.request.contextPath}/json/something/">List category (REST/JSON)</a></li>
 	<li><a href="${pageContext.request.contextPath}/json/getAllEmp/">List category (REST/JSON)</a></li>
 	<li><a href="${pageContext.request.contextPath}/json/view/1">View Emp (REST/JSON)</a></li>
</ul>
<p class="menuSection">Basic Operations</p>
<ul id="nav">
 	<li><a href="${pageContext.request.contextPath}/op1">Operation 1</a></li>
 	<li><a href="${pageContext.request.contextPath}/op2">Operation 2</a></li>
</ul>
<p class="menuSection">Basic Operations</p>
<ul id="nav">
 	<li><a href="${pageContext.request.contextPath}/op1">Operation 1</a></li>
 	<li><a href="${pageContext.request.contextPath}/op2">Operation 2</a></li>
</ul>
</div></br>
