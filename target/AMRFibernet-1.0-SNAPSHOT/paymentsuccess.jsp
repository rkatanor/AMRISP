<%@page import="com.amr.net.JavaSMS" %>

<html>
<head><title>Example of Extends 
Attribute of page Directive in JSP</title></head>

<body>
<font size="20" color="green">
<h2>Payment was successful</h2>

<%
JavaSMS.sendSMS();
 out.print("sms sent"); 
%>

</font>
</body>


</html>
