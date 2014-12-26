<%-- 
    Document   : dashboard
    Created on : Oct 12, 2014, 11:36:51 AM
    Author     : audax
--%>

<%@page language="java" contentType="text/html charset=US-ASCII" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dashboard</title>
        <% String cp = request.getContextPath ();%>
        <meta charset="UTF-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        
        
        <script src="<%=cp%>/js/bootstrap.js"></script>

        <script src="<%=cp%>/js/bootstrap.min.js"></script>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <script src="<%=cp%>/jquery-2.js"></script> 

<!--
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
-->
<link rel="stylesheet" type="text/css" href="<%=cp%>/css/bootstrap.min.css">

    </head>
    <body>
        <%
            //allow access only if session exists
            String user = null;
            if (session.getAttribute("user") == null) {
                response.sendRedirect("index.html");
            } else {
                user = (String) session.getAttribute("user");
            }
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            }
        %>
        <div style="position: fixed; top: 0; z-index: 1 ; right: 10%; "  data-ajax="false">
            <!--
            <input type="submit" value="LOGOUT" name="logOut" id="logOut" class="btn-danger glyphicon-log-out">
            -->
            <a href="./AlternateLogout" class="btn btn-block"><span class="glyphicon glyphicon-log-out"></span> LOGOUT &nbsp; <%=userName%></a>
            <!--
            Session stuff
            </br> Session ID <%=sessionID %>
            -->
        </div>


        <!-- First Row -->
        <div class="container" data-ajax="false">
            <div class="row">
                <div class="col-md-6">
                    <div class="jumbotron">
                        <h2>Initial Treatment Area</h2>      
                        <p>Fill out a form to register diseased farm</p>      
                        <a href="<%=cp%>/IT.html" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-open"></span>
                            Go to Form</a>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="jumbotron"> 
                        <h2>Report Area</h2>      
                        <p>Get all your reports using Lot numbers</p>      
                        <a href="reports.jsp" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-paperclip"></span>
                            Enter</a>
                    </div>
                </div>

            </div>
        </div>
        <!-- End of the FIrst Row -->

        <!-- Second row -->
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="jumbotron">
                        <h2>Re-Planting Area</h2>      
                        <p>Farms that require re-planting information </p>      
                        <a href="replanting.jsp" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-open"></span>
                            Enter</a>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="jumbotron"> 
                        <h2>Admin Area</h2>      
                        <p>Log in as admin to make some administrative changes</p>      
                        <a href="edits.jsp" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-log-in"></span>
                            Login</a>
                    </div>
                </div>

            </div>
        </div>
        <!-- End of the second row -->

        
        
        <!-- Third row -->
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="jumbotron">
                        <h2>Rehabilitation Area</h2>      
                        <p>Cocoa farm rehabilitation section </p>      
                        <a href="rehab.html" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-open"></span>
                            Enter</a>
                    </div>
                </div>
                
                
                 <div class="col-md-6">
                    <div class="jumbotron"> 
                        <h2>Search Area</h2>      
                        <p>Search for records throughout the database</p>      
                        <a href="searchGrant.jsp" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-envelope"></span>
                            Enter</a>
                    </div>
                </div>
                
        </div>
        <!-- End of the third row -->
        
        
        <!--
        
        
         
        <div class="container">
      <div class="jumbotron">
        <h2>My first Bootstrap</h2>      
        <p>This page will grow as we add more and more components from Bootstrap...</p>      
        <a href="#" class="btn btn-info btn-lg">Search</a>
      </div>
    </div>
        
        -->

    </body>
</html>
