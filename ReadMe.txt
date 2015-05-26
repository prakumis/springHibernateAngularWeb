Technologies Used in this application:
------------------------------------------------------------------------------------------
1. JDK 1.7
2. Eclipse - MARS-M5
3. Maven 3.2.2
4. GIT as repository (moved eclipse code to git:: http://stackoverflow.com/questions/17552457/how-do-i-upload-eclipse-projects-to-github)
5. Spring: MVC + REST Service (Jackson Lib)
6. Spring Security [FormBasedLogin: a) hardCoded-UserPassword. b) enterprize ldap c) openLdap]
6. Spring Security [Authorization: role based access to services]
7. LDAP for storing credentials

Implementation Pending
---------------------------------------------------------------------------------------------------
8. MySQL / POSTGRES / Oracle databases
9. JPA / Hibernate as ORM (Do the POC for Both)
10.Caching
11.Payment Gatway implementation
12.UML Diagrams (class diagram + sequence diagram + others (see eniq adapter design doc))
13.Latest scheduler implementation
14.JUnit test cases
15.Java Mail (or any other mail api implementation)
16.PDF / Excel report generation
17.HTTPS support in Tomcat server
18.

============================================================================================================
======= Step to create dynamic web project using maven and convert it into eclipse  ========================
============================================================================================================
1. create a maven web application on console: (optional: import project into eclipse)
	http://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/
2. check in the code into git repository
http://stackoverflow.com/questions/17552457/how-do-i-upload-eclipse-projects-to-github
3. Add the maven dependency whenever required
4. Error: if any compilation error: in eclipse:
http://stackoverflow.com/questions/18122336/cannot-change-version-of-project-facet-dynamic-web-module-to-3-0
5. Error: SLF4J Dependencies and LocationAwareLogger.log Method Not Found Exception
http://www.captaindebug.com/2012/01/slf4j-dependencies-and.html#.VSeqynX_SPQ

============================================================================================================

###################################################################################################
------------------ Spring Security Notes ----------------------------------------------------------
---------------------------------------------------------------------------------------------------
1. web.xml
2. 

Notes: ThreadLocal, Namespace of spring security, sprin-security-4, url level + service level security
		https://spring.io/blog/2010/03/06/behind-the-spring-security-namespace/ (lakshmi shared this link)

Good Read on expression in spring security (using hasRole())::
		http://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html

Method level security:  http://howtodoinjava.com/2014/02/15/xml-config-based-method-level-spring-security-using-protect-pointcut/
<global-method-security>
  <protect-pointcut expression="execution(* com.howtodoinjava.service.*Impl.add*(..))" access="ROLE_USER"/>
  <protect-pointcut expression="execution(* com.howtodoinjava.service.*Impl.delete*(..))" access="ROLE_ADMIN"/>
</global-method-security>
---------------------------------------------------------------------------------------------------


###################################################################################################
------------------ Open LDAP Notes ----------------------------------------------------------
---------------------------------------------------------------------------------------------------
URL: http://www.unixmen.com/openldap-installation-configuration-ubuntu-12-1013-0413-10-debian-67-2/
---------------------------------------------------------------------------------------------------
