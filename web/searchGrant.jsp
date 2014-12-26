<%-- 
    Document   : searchGrant
    Created on : Oct 12, 2014, 11:36:51 AM
    Author     : audax
--%>

<%@page language="java" contentType="text/html charset=US-ASCII" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Page</title>
        <% String cp = request.getContextPath();%>
        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">



        <script src="<%=cp%>/js/bootstrap.js"></script>

        <script src="<%=cp%>/js/bootstrap.min.js"></script>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <script src="<%=cp%>/jquery-2.js"></script> 
        <script src="js/parsley.js"></script>

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

        <form action="search_result.jsp" method="POST" data-parsley-validate>
            <center>
                <div class="container">
                    <div class="jumbotron">
                        <h2>Search through database</h2>      
                        Select basis to search : <br>
                        <select name="searcher" id="searcher">
                            <option value="#">Choose Field to Search</option>
                            <option value="1">Farm Reference Number</option>
                            <option value="2">Old Farm Number</option>
                            <option value="3">Farmer Name</option>
                            <option value="4">ID Number</option>
                            <option value="5">Lot Number </option>
                            <option value="6">IT Voucher </option>
                            <option value="7">TR Voucher </option>
                            <option value="8">Re-planting Lot Number </option>
                            <option value="9">RP Voucher </option>
                            
                        </select>
                        <br>
                        <table>
                            <tr><td><input type="radio" name="field" value="IT" required >Look through Initial treatment or Tree removal records</td></tr>
                        <tr><td><input type="radio" name="field" value="RP"> Look through Re-planting Records</td></tr>
                        <!--<tr><td><input type="radio" name="field" value="ReH">Look through Rehabilitation records</td></tr>-->
                        </table>
                        <br><br>
                        Enter Search Value: <br><input type="text" id="searchItem" name="searchItem" required >
                        <br><br>
                        <a href="javascript:void(0)" id="sumBit" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-search"></span>
                            SEARCH</a>
                    </div>
                </div>
        </form>


    </body>
</html>
