<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/welcome.css" />

Welcome ${loggedInUser.firstName} to the application home<br>
This project will be served as base project for Spring MVC / Spring Security. For other technology integration, 
use this project as baseline and start integration.
<p>Technologies used in this sample spring based web application::</p>
<p class="menuSection">Basic Technologies</p>
<ul id="nav">
 	<li>JDK/JSE 7.0</li>
 	<li>JEE 5.0</li>
 	<li>Eclipse Mars 5</li>
 	<li>GIT / github</li>
 	<li>Maven 3.2.2</li>
</ul>

<p class="menuSection">Frameworks/Technologies</p>
<ul id="nav">
 	<li>Spring 4.1.4.RELEASE</li>
 	<li>Spring MVC, Form-Validation, JSP/Tiles</li>
 	<li>Spring Security 3.0.0.RELEASE - ldap authentication, db authorization, method level security</li>
 	<li>Hibernate:: Done:: [org.apache.commons.dbcp.BasicDataSource]</li>
 	<li>Hibernate:: Done:: [@org.springframework.transaction.annotation.Transactional annotation for Tx Mgmt]</li>
 	<li>Hibernate:: Done:: [com.mchange.v2.c3p0.ComboPooledDataSource]</li>
 	<li>Hibernate:: done:: [JDBC details from properties file.]</li>
 	<li>Hibernate:: Done:: [< tx:advice id="txAdvice" transaction-manager="txManager"> for Tx Mgmt]</li>
 	<li>Hibernate:: Pending:: [Multiple database under a tx]</li>
 	<li>Hibernate:: Pending:: [Entity Mapping: One-One, One-Many, Many-Many::: One directional + BiDirectional]</li>
 	<li>AOP:: Pending:: Calculate the time taken to execute a service. hint: TraCS proj</li>
 	<li>Interceptor:: Pending:: Calculate the time taken to execute a request. hint: OPM</li>
</ul>

<p class="menuSection">Pending Technologies</p>
<ul id="nav">
 	<li>Spring REST / JSON implementation</li>
 	<li>Follow the ReadMe.txt for more</li>
</ul>

