<%-- 
    Document   : Admin page
    Created on : Oct 12, 2014, 11:36:51 AM
    Author     : audax
--%>

<%@page language="java" contentType="text/html charset=US-ASCII" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Reports Page</title>
        <% String cp = request.getContextPath();%>
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
            <a href="dashboard.jsp" class="btn btn-block"><span class="glyphicon glyphicon-backward"></span> BACK</a>
            <!--
            Session stuff
            </br> Session ID <%=sessionID%>
            -->
        </div>
        <script>
            //Makes me use <a> tag to submit form
            $(document).on("click", "#sumBit", function() {
                var form = $(this).closest("form");
                console.log(form);
                form.submit();
            });

        </script>

        
            <center>
                <div class="container">
                    <div class="jumbotron">
                        <h1>ADMIN AREA</h1>      
                        <br>
                        <br>
                        <a href="it_edits.jsp" id="sumBit" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-open"></span>
                            EDIT Initial treatment(TR) Information </a>
                        <br>
                        <br>
                        <br>
                        <a href="replant_edits.jsp" id="sumBit" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-open"></span>
                            EDIT Re-planting Information </a>
                        
                        
                            <br>
                        <br>
                        <br>
                        <a href="#" id="sumBit" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-open"></span>
                            EDIT Rehabilitation Information </a>
                        
                        
                        <br>
                        <br>
                        <br>
                        <a href="deletion.jsp" id="sumBit" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-open"></span>
                            Farm Number Operations </a>
                    </div>
                </div>
        

    </body>
</html>
