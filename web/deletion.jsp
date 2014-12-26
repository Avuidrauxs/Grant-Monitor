<%-- 
    Document   : dashboard
    Created on : Oct 12, 2014, 11:36:51 AM
    Author     : audax
--%>

<%@page language="java" contentType="text/html charset=US-ASCII" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>EDIT PAGE</title>
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

    <center>
        
        
        <form action="confirm_update.jsp" method="POST" >
            <center>
                <div class="container">
                    <divz class="jumbotron">
                        <h2>Edit Farm Number</h2>      
                       
                        <br><br>
                        <table>
                            <tr>
                                <td>Enter Old Value: <br><input type="text" id="oldVal" name="oldVal"  required></td>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td>Enter New Value: <br><input type="text" id="newVal" name="newVal" required></td>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                
                            </tr>
                        </table>
                        <br><br>
                        <a href="javascript:void(0)" id="sumBit" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-print"></span>
                            CHANGE</a>


                    </div>
                </div>
        </form>
        
        <br><br>
        <h3>DELETE FARM </h3>
        <form action="confirm_delete.jsp" method="POST">
            
            <input type="text" name="deleted" id="deleted" style="text-transform: uppercase"  >
            
            <br><br><br>
            
             <a href="javascript:void(0)" id="sumBit" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-remove"></span>
                            DELETE FARM</a>

            
        </form>


    </body>
</html>
