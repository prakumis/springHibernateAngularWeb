<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link rel="icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/layout.css?time=2015-04-17-13-12" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css?b" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/footer.css" />
<script type="text/javascript" src="<c:url value="/resources/js/form_validation.js?aaa" />"></script>


<title><tiles:getAsString name="title" /></title>
</head>

<body>
	<div id="layoutmain">

		<div id="header">
			<tiles:insertAttribute name="header" ignore="true" />
		</div>

		<div id="midBody">

			<div id="leftmenu">
				<tiles:insertAttribute name="menu" ignore="true" />
			</div>

			<div id="content">
				<tiles:insertAttribute name="body" ignore="true" />
			</div>

			<div id="footer">
				<tiles:insertAttribute name="footer" ignore="true" />
			</div>

		</div>
</body>

</html>
