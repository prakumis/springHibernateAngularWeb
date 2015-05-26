<%@ page isErrorPage="true" %>
<html>
<head>
<title>Show Error Page</title>
</head>
<body>
<p>Sorry, an error occurred.</p>

<p>Unable to process request at this time<p>

<%
    out.print("<br/><br/><h1> Exception !!! </h1>");
	if(null!= exception) {
	    out.print("<b>Exception Message is [" + exception.getMessage() + "]</b>");
	    out.print("<br/>Exception stack trace [");
	
	    StackTraceElement[] element = exception.getStackTrace();
	
	    for (int i = 0; i < element.length; i++) {
	        out.print(element[i].toString()+"<br>");
	    }
	}
    out.print("]");
%>
</body>
</html>