<%-- 
    Document   : replanting
    Created on : Oct 17, 2014, 12:50:38 PM
    Author     : audax
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Controller.FarmerManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <% String cp = request.getContextPath();%>


        <meta name="viewport" content="width=device-width, initial-scale=1.0">



        <script src="<%=cp%>/js/bootstrap.js"></script>

        <script src="<%=cp%>/js/bootstrap.min.js"></script>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <script src="<%=cp%>/jquery-2.js"></script> 
        <script src="js/parsley.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=cp%>/css/bootstrap.min.css">

        <title>Re-Planting Area</title>
    </head>
    <body onload="hiddee()">
        <script>


            $(document).ready(function() {

                $("#showAsh").click(function() {
                    $(".tablew").toggle();
                });
                $("#showWN").click(function() {
                    $(".tableWN").toggle();
                });
                $("#showWS").click(function() {
                    $(".tableWS").toggle();
                });
                $("#showCen").click(function() {
                    $(".tableC").toggle();
                });
                $("#showBA").click(function() {
                    $(".tableBA").toggle();
                });
                $("#showV").click(function() {
                    $(".tableV").toggle();
                });
                $("#showES").click(function() {
                    $(".tableE").toggle();
                });


            });

            function hiddee() {
                $(document).ready(function() {

                    $(".tablew").hide();
                    $(".tableWN").hide();
                    $(".tableWS").hide();
                    $(".tableC").hide();
                    $(".tableBA").hide();
                    $(".tableV").hide();
                    $(".tableE").hide();


                });
            }




        </script>

    <center>

        <div style="position: fixed; top: 0; z-index: 1 ; right: 10%; "  data-ajax="false">
            <!--
            <input type="submit" value="LOGOUT" name="logOut" id="logOut" class="btn-danger glyphicon-log-out">
            -->
            <a href="dashboard.jsp" class="btn btn-block"><span class="glyphicon glyphicon-backward"></span> BACK</a>
            <!--
            Session stuff
            
            -->
        </div>

        <div class="container">
            <div class="jumbotron">
                <h2>RE-PLANTING AREA</h2>      
                <p>Click on your region of choice and click on the Farm Number to go to re-planting form</p>
                <br><br>
                <!--
                 <a href="rpp.jsp" id="" class="btn btn-info btn-lg">
                                <span class="glyphicon glyphicon-search"></span>
                                SEARCH</a></td>
                
                -->
                <form action="rpp.jsp" data-parsley-validate>
                    <input type="text" style="text-transform: uppercase;" class="input-sm" required="true" name="searchLot" placeholder="Search By FarmNumber"> 
                    <input type='submit' value="SEARCH">
                </form>
                <br><br>


                <!-- First Table-->
                <table style="padding: 30px; text-align: center;"> 
                    <tr>
                        <td><a href="javascript:void(0)" id="sumBit" class="btn btn-info btn-lg">
                                <span class="glyphicon glyphicon-briefcase"></span>
                                ASHANTI</a></td>

                        <td style="padding: 10px;">  <a href="javascript:void(0)" id="sumBit" class="btn btn-info btn-lg">
                                <span class="glyphicon glyphicon-briefcase"></span>
                                WESTERN NORTH</a></td>

                        <td>  <a href="javascript:void(0)" id="sumBit" class="btn btn-info btn-lg">
                                <span class="glyphicon glyphicon-briefcase"></span>
                                WESTERN SOUTH</a></td>

                        <td style="padding: 10px;">  <a href="javascript:void(0)" id="sumBit" class="btn btn-info btn-lg">
                                <span class="glyphicon glyphicon-briefcase"></span>
                                CENTRAL</a></td>
                    </tr>
                    <tr>

                        <td>  <button id="showAsh" >TOGGLE</button></td>
                        <td>  <button id="showWN" >TOGGLE</button></td>
                        <td>  <button id="showWS" >TOGGLE</button></td>
                        <td>  <button id="showCen" >TOGGLE</button></td>


                    </tr>
                </table>
                <!-- End of First Table-->

                <!--Second Table-->

                <table style="padding: 30px; text-align: center;"> 
                    <tr>
                        <td><a href="javascript:void(0)" id="sumBit" class="btn btn-info btn-lg">
                                <span class="glyphicon glyphicon-briefcase"></span>
                                BRONG AHAFO</a></td>

                        <td style="padding: 10px;">  <a href="javascript:void(0)" id="sumBit" class="btn btn-info btn-lg">
                                <span class="glyphicon glyphicon-briefcase"></span>
                                VOLTA</a></td>

                        <td>  <a href="javascript:void(0)" id="sumBit" class="btn btn-info btn-lg">
                                <span class="glyphicon glyphicon-briefcase"></span>
                                EASTERN</a></td>


                    </tr>
                    <tr>

                        <td>  <button id="showBA" >TOGGLE</button></td>
                        <td>  <button id="showV" >TOGGLE</button></td>
                        <td>  <button id="showES" >TOGGLE</button></td>



                    </tr>
                </table>
                <!-- End of Second Table -->


            </div>
        </div>

        <br>
        <!-- Ashanti Table -->
        <table border="2" class="tablew" >
            <thead>
            <td colspan="4">
                <strong>ASHANTI</strong>

            </td>
            </thead>
            <%

                FarmerManager manager;

                manager = new FarmerManager();

                ResultSet rs = manager.rpList("Ashanti");

                while (rs.next()) {


            %>


            <tr>

                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rs.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rs.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rs.getString(1)%>  ></td>
            </tr>
            <%

                }

            %>


        </table>
            
        <!-- End of Ashanti Table -->

        <br>
        <!-- Brong Ahafo Table -->
        <table border="2" class="tableBA" >
            <thead>
            <td colspan="3">
                <strong>BRONG AHAFO</strong>

            </td>
            </thead>
            <%                    ResultSet rsBA = manager.rpList("Brong Ahafo");

                while (rsBA.next()) {


            %>

            <tr>


                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsBA.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsBA.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsBA.getString(1)%>  ></td>
            </tr>
            <%

                }

            %>


        </table>
        <!-- End of Brong Ahafo Table -->






        <br>
        <!-- Western North Table -->
        <table border="2" class="tableWN" >
            <thead>
            <td colspan="3">
                <strong>WESTERN NORTH</strong>

            </td>
            </thead>
            <%                    ResultSet rsWN = manager.rpList("Western North");

                while (rsWN.next()) {


            %>

            <tr>


                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsWN.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsWN.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsWN.getString(1)%>  ></td>
            </tr>
            <%

                }

            %>


        </table>
        <!-- End of WESTERN NORTH Table -->



        <br>
        <!-- Western South Table -->
        <table border="2" class="tableWS" >
            <thead>
            <td colspan="3">
                <strong>WESTERN SOUTH</strong>

            </td>
            </thead>
            <%                    ResultSet rsWS = manager.rpList("Western South");

                while (rsWS.next()) {


            %>

            <tr>


                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsWS.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsWS.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsWS.getString(1)%>  ></td>
            </tr>
            <%

                }

            %>


        </table>
        <!-- End of WESTERN SOUTH Table -->


        <br>
        <!-- Central Table -->
        <table border="2" class="tableC" >
            <thead>
            <td colspan="3">
                <strong>CENTRAL</strong>

            </td>
            </thead>
            <%                    ResultSet rsC = manager.rpList("Central");

                while (rsC.next()) {


            %>

            <tr>


                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsC.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsC.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsC.getString(1)%>  ></td>
            </tr>
            <%

                }

            %>


        </table>
        <!-- End of Central Table -->


        <br>
        <!-- Volta Table -->
        <table border="2" class="tableV" >
            <thead>
            <td colspan="3">
                <strong>VOLTA</strong>

            </td>
            </thead>
            <%                    ResultSet rsV = manager.rpList("Volta");

                while (rsV.next()) {


            %>

            <tr>


                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsV.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsV.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsV.getString(1)%>  ></td>
            </tr>
            <%

                }

            %>


        </table>
        <!-- End of Volta Table -->

        <br>
        <!-- Eastern Table -->
        <table border="2" class="tableE" >
            <thead>
            <td colspan="3">
                <strong>EASTERN</strong>

            </td>
            </thead>
            <%              
                ResultSet rsE = manager.rpList("Eastern");

                while (rsE.next()) {


            %>

            <tr>


                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsE.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsE.getString(1)%>  ></td>
                <td><input name="lott" style="background: transparent; border: none;" type="submit" value=<%= rsE.getString(1)%>  ></td>
            </tr>
            <%

                }

            %>


        </table>
        <!-- End of Eastern Table -->
        
    </body>
</html>
