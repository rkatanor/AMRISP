<%@ page import="java.sql.*" %>

<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
   <title>User | AMR Fibernet</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet"> 
    <link href="css/lightbox.css" rel="stylesheet"> 
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">

    <!--[if lt IE 9]>
	    <script src="js/html5shiv.js"></script>
	    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<header id="header">      
       
        <div class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a class="navbar-brand" href="index.html">
                    	<h1><img src="images/amrlogo.png" alt="logo"></h1>
                    </a>
                    
                </div>
              <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                     <li><a href="home.jsp"><b>Home</b></a></li>
                       
                          <li><a href="PlanServlet"><b>Profile</b></a></li>
                           <li><a href="amrfibernetcontactpage.jsp"><b>Contact us</b></a></li>
                            <li><a href="LogoutServlet"><b>Logout</b></a></li>
             

                                         
                       
                                         
                    </ul>
                </div>
                <div class="search">
                    <form role="form">
                        <i class="fa fa-search"></i>
                        <div class="field-toggle">
                            <input type="text" class="search-form" autocomplete="off" placeholder="Search">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </header>
    <!--/#header-->

   
   
    <footer id="footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center bottom-separator">
                    <img src="images/home/under.png" class="img-responsive inline" alt="">
                </div>
               
              
                <div class="col-md-4 col-sm-12">
                    <div class="contact-form bottom">
                        <h2></h2>
                         <%
		if (session != null) {
			if (session.getAttribute("user") != null) {
				String name = (String) session.getAttribute("user");
				out.print("Hello, " + name );
				//db connection
				
		
         %>
         <br> <br> <br> <br> <br> <br>
         <style>
table {
    border-collapse: collapse;
    width: 100%;
}

TH, TD {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

TR:hover{background-color:#f5f5f5}
</style>
         <h2><b><font color=green>CUSTOMER PACKAGE DETAILS</font></b></h2>
         <br>  <br>  <br>  <br>
          <TABLE BORDER=1  style="width:100%;">
            <TR>
                <TH>Customer Name</TH>
                <TH>Customer ID</TH>
                <TH>Customer Email</TH>
                <TH>Plan_Package</TH>
               
                <TH>Mobile</TH>
                <TH>Address</TH>
                <TH>Monthly Rental</TH>
                <TH>Due Amount</TH>
            </TR>
           
            <TR>

                <TD> <%=session.getAttribute("cust_name") %></td>
                <TD> <%=session.getAttribute("cust_id") %></td>
                <TD> <%=session.getAttribute("cust_email") %></td>
                <TD> <%=session.getAttribute("cust_package") %></td>
               
                <TD> <%=session.getAttribute("cust_mobile") %></td>
                <TD> <%=session.getAttribute("cust_add") %></td>
                <TD> <%=session.getAttribute("cust_monthly_bill") %></td>
                <TD> <%=session.getAttribute("cust_due_amount") %></td>
                
               
                  
            </TR>
             </TABLE>
             <br> <br> 
             <a href="https://www.payumoney.com/paybypayumoney/#/293495"><b>Pay Bill</b></a>
             <br> <br> <br> <br>
              <br> <br> <br> <br> <br> <br> <br> <br> 
             
            <% 
			
			}
		}
		else 
		{
			response.sendRedirect("amrfibernetlogin.jsp");
		}
	%>
                        
                       
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="copyright-text text-center">
                        <p>&copy; AMR FIBERNET Company 2017. All Rights Reserved.</p>
                        <p>Developed & Designed by <a target="_blank" href="">Rajkumar Katanor</a></p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--/#footer-->

    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/lightbox.min.js"></script>
    <script type="text/javascript" src="js/wow.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>   
</body>
</html>
