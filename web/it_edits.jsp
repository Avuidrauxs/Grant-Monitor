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

        <form action="./ITeditServlet" method="POST" data-parsley-validate>
            <center>
                <div class="container">
                    <divz class="jumbotron">
                        <h2>Initial Treatment Corrections</h2>      
                        Select Field to edit: <br>
                        <select name="fields" id="fields">
                            <option value="ITVouch">IT GP Number</option>
                            <option value="TRVouch">Tree Removal Number</option>
                            <option value="ITDate">IT Date </option>
                            <option value="ITPayable">IT Grant Payable </option>
                            <option value="TRPayable">TR Grant Payable </option>\
                            <option value="NumberOfTressCut">Number of Trees Cut</option>
                            
                            <option value="FarmerName">Farmer Name </option>
                            <option value="IDNumber">ID Number</option>
                            <option value="LotNumber">Lot Number</option>
                            <option value="ConName">Contractor Name</option>
                            <option value="ConLocation">Contractor Location</option>
                            
                           <!-- <option value="FarmNumber">Farm Reference Number</option>-->
                            <option value="OldFarmNumber">Old Farm Number </option>
                            <option value="TotalFarmSize">Farm Size </option>
                             <option value="EstTrees">Estimated Trees</option>
                            <option value="TreatedFarmSize">Treated Area </option>
                      </select>
                        <br><br>
                        <table>
                            <tr>
                                <td>Enter Old Value: <br><input type="text" id="oldVal" name="oldVal"  required></td>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td>Enter New Value: <br><input type="text" id="newVal" name="newVal" required></td>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td>Enter Farm Number: <br><input type="text" style="text-transform: uppercase" id="FarmNumber" name="FarmNumber" required></td>
                            </tr>
                        </table>
                        <br><br>
                        <a href="javascript:void(0)" id="sumBit" class="btn btn-info btn-lg">
                            <span class="glyphicon glyphicon-print"></span>
                            CHANGE</a>


                    </div>
                </div>
        </form>

      


    </body>
</html>
