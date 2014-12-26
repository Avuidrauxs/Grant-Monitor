<%-- 
    Document   : rpp
    Created on : Oct 20, 2014, 1:15:15 PM
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
        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">



        <script src="<%=cp%>/js/bootstrap.js"></script>

        <script src="<%=cp%>/js/bootstrap.min.js"></script>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <script src="<%=cp%>/jquery-2.js"></script> 
        <script src="<%=cp%>/js/main.js"></script>
        <script src="<%=cp%>/jqFiles/js/jquery.js"></script>
        <script src="js/parsley.js">
            </script>

        <!--
                <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        -->
        <link rel="stylesheet" type="text/css" href="<%=cp%>/css/bootstrap.min.css">
        <style>

            #trd
            {
                padding-left: 15px;
                padding-right: 15px;
                font-style: oblique;
                font-weight: bolder;

            }

            #distOfficer,#taName
            {
                
                text-transform: capitalize;
                
                
            }
            
            #cla
            {
                
                color: #ff0000;
                
            }
        </style>
        <title>Re-Planting</title>
    </head>
    <body>
        <% String fnumber = request.getParameter("searchLot");%>

        <%if (fnumber == "") {


        %>
        <script>
            document.getElementById("rpVouch").disabled = true;

        </script>
        <div style="position: fixed; top: 0; z-index: 1 ; right: 10%; "  data-ajax="false">
            <!--
            <input type="submit" value="LOGOUT" name="logOut" id="logOut" class="btn-danger glyphicon-log-out">
            -->
            <a href="replanting.jsp" class="btn btn-block"><span class="glyphicon glyphicon-backward"></span> BACK</a>
            <!--
            Session stuff
            
            -->
        </div>
        <h2>Farm Number Not Valid or Not Found</h2>
        <%                }%>

        <% FarmerManager manager = new FarmerManager();
        
        float rateP = manager.rpRate();

           //ResultSet rs = manager.allReplant("JUA/3/45/4/S06/7");
            ResultSet rs = manager.allReplant(fnumber);

            if (rs.next()) {

                float treatedArea = rs.getFloat(2);
        %>

        <div style="position: fixed; top: 0; z-index: 1 ; right: 10%; "  data-ajax="false">
            <!--
            <input type="submit" value="LOGOUT" name="logOut" id="logOut" class="btn-danger glyphicon-log-out">
            -->
            <a href="replanting.jsp" class="btn btn-block"><span class="glyphicon glyphicon-backward"></span> BACK</a>
            <!--
            Session stuff
            
            -->
        </div>
    <center>
        <h2>
        <p>Region : <%=rs.getString(6)%> </p>
        <p>District : <%=rs.getString(7)%> </p>
        <p>Farm Ref Number : <%=fnumber%> </p>
        </h2>
        <input type="hidden" value="<%=treatedArea%>" id="fmSize" name="fmSize">
        <table><tr><td id='trd'><p>IT VOUCH : <span id="cla"><%=rs.getString(16)%></span> </p></td>
                <td id='trd'><p>TR VOUCH : <span id="cla"><%=rs.getString(17)%></span> </p></td>
                <td id='trd'><p>IT DATE : <span id="cla"><%=rs.getDate(19)%></span> </p></td>
            </tr></table>

        <table>
            <tr>
                <td id='trd'>Farm Size :<span id="cla"> <%=rs.getFloat(1)%></span> </td>
                <td id='trd'>Farmer's Name :<span id="cla"> <%=rs.getString(8)%></span> </td>
            </tr>
            <tr>
                <td id='trd'>Treated Area : <span id="cla"><%=rs.getString(2)%></span> </td>
                <td id='trd'>Farmer's Gender :<span id="cla"> <%=rs.getString(9)%></span> </td>
            </tr>
            <tr>
                <td id='trd'>Area not Treated :<span id="cla"> <%=rs.getString(3)%></span> </td>
                <td id='trd'>Farmer's Age :<span id="cla"> <%=rs.getInt(10)%></span> </td>
            </tr>
            <tr>
                <td id='trd'>CocoaType :<span id="cla"> <%=rs.getString(13)%></span> </td>
                <td id='trd'>Farmer's ID Number : <span id="cla"> <%=rs.getString(11)%></span> </td>
            </tr>
            <tr>
                <td id='trd'>Cocoa Age Class : <span id="cla"> <%=rs.getString(14)%></span> </td>
                <td id='trd'>Farmer's Address : <span id="cla"> <%=rs.getString(12)%></span> </td>
            </tr>
            <tr>
                <td id='trd'>Estimated Trees : <span id="cla"> <%=rs.getString(4)%></span> </td>
                <td id='trd'>IT Tech Assistant : <span id="cla"> <%=rs.getString(21)%></span> </td>
            </tr>
            <tr>
                <td id='trd'>Number of Trees Cut : <span id="cla"> <%=rs.getString(5)%></span> </td>
                <td id='trd'>District Officer : <span id="cla"> <%=rs.getString(22)%></span> </td>
            </tr>
            <tr>
                <td id='trd'>Trees Difference : <span id="cla"></span>  </td>
                <td id='trd'>IT Cheque Number : <span id="cla"></span> </td>
            </tr>
            <tr>
                <td id='trd'>IT Rate : <span id="cla"> <%=rs.getString(15)%></span> </td>
                <td id='trd'>Date Paid : <span id="cla"> </span> </td>
            </tr>
            <tr>
                <td id='trd'>IT Payable : <span id="cla"> <%=rs.getString(20)%></span> </td>
                <td id='trd'>LOT Number : <span id="cla"> <%=rs.getString(18)%></span> </td>
            </tr>

        </table>


        <%

            }
            
            
            else {
        %>
        
        <h2>Farm Number Not Valid or Not Found</h2>
        <%                }%>
        <script>
            //Makes me use <a> tag to submit form
            $(document).on("click", "#sumBit", function() {
                var form = $(this).closest("form");
                console.log(form);
                form.submit();
            });

        </script>
        <br>
        <form action="./RPInputs" method="POST" data-parsley-validate >
            <a href="javascript:void(0)" id="sumBit" class="btn btn-info btn-lg">
                <span class="glyphicon glyphicon-save"></span>
                SUBMIT</a>
 <input type="hidden" value="<%=fnumber%>" id="fNum" name="fNum">
            <br>
            <br>
            <div class="jumbotron" >

                <fieldset > 
                    <legend>RE-PLANTING INFO</legend>
                    <p style="float: left;"><label>RP VOUCH: &nbsp;</label><input type="text" class="input-sm" name="rpVouch" id="rpVouch" required/></p>
                     <p style="left: 10;" ><label>RP LOT NUMBER: &nbsp;</label><input type="text" class="input-sm" name="rpLot" id="rpLot" required/></p>
                    <p style="float: right;"><label>RP DATE: &nbsp;</label><input type="text" class="input-sm" name="rpDate" id="rpDate" required maxlength="10" placeholder="DD-MM-YY" onkeyup="addDateSeparator(event,this,'dd-mm-yyyy')"/></p>
                    <br>
                    <table style="float: left;"><tr>

                            <td><label>Area Replanted:&nbsp; </label><input onchange="calcAreaNot()" required type="text" class="input-sm" name="areaRpl" id="areaRpl"/></td>
                            <td><label>Quantity of Free Seed:&nbsp; </label><input onchange="netRP()" required type="number" min ="0" class="input-sm" name="quanSeed" id="quanSeed"/></td>
                            <td><label>Number of Fertilizer Bags:&nbsp; </label><input required="true" onchange="grossRP()" type="number" min ="0" class="input-sm" name="fertBags" id="fertBags"/></td>
                            <td><label>Seed Purchase:&nbsp; </label><input onchange="costSeed()"  type="number" min ="0"  class="input-sm" name="seedPurchase" id="seedPurchase"/></td>
                            <td><label>Replant rate/Ha :&nbsp; </label><input onchange="netRP()" type="text" required="" value="<%=rateP%>" class="input-sm" name="rplRate" id="rplRate"/></td>
                        </tr>
                        <!--Replant Rate has to be linked to database -->
                        
                        <td><label>Value of Free Seed:&nbsp; </label><input onchange="costSeed()" required type="number" min ="0" class="input-sm" name="valSeed" id="valSeed" value="0"/></td>
                        <td><label>Fertilizer Unit Price:&nbsp; </label><input onchange="costFert()"   type="number" min ="0" class="input-sm" name="fertPrice" id="fertPrice"/></td>
                        <td><label>Fertilizer Purchase:&nbsp; </label><input onchange="costFert()"   type="number" min ="0" class="input-sm" name="fertPurchase" id="fertPurchase"/></td>
                        <td><label>Fertilizer Allocated:&nbsp; </label><input onchange="fatAllo()"  type="number" min ="0"  name="fertAllo" id="fertAllo"/></td>
                        <td>Area not Replanted: <p id="areaNot"></p></td>
                        <input type="hidden" id="areaNott" name="areaNott"/>

                        <!-- -->
                        <tr>

                            
                            <td>Gross RP: <p id="grossRP"></p></td>
                        <input type="hidden" id="grossRPP" name="grossRPP"/>
                            
                            
                             <td>Cost of Seed Purchase: <p id="costSeed"></p></td>
                             <input type="hidden" id="costSeedd" name="costSeedd"/>
                            <td>Cost of Fert. Purchase: <p id="costFert"></p></td>
                            <input type="hidden" id="costFertt" name="costFertt"/>
                            <input type="hidden" id="total" name="total"/>
                             
                            <td colspan="2">Net RP:  <p id="netRP"></p></td>
                            <input onchange="netRP()" type="hidden" id="netRPP" name="netRPP"/>
                            
                        </tr>

                    </table>

                    <br>
                    <legend>OFFICER DETAILS</legend>
                    <table  style="float: left;">
                        <tr>

                            <td><label>District Officer:&nbsp; </label><input onchange="netRP()" required type="text" class="input-sm" name="distOfficer" id="distOfficer"/></td>
                            <td><label>Rep TA:&nbsp; </label><input onchange="netRP()" required type="text" class="input-sm" name="taName" id="taName"/></td>
                      <!--
                            <td><label>RP Cheque Number: &nbsp; </label><input required type="text" class="input-sm" name="chqNumber" id="chqNumber"/></td>
                            <td><label>Date RP Paid: &nbsp; </label><input required type="text" class="input-sm" name="paidDate" id="paidDate" maxlength="10" placeholder="DD-MM-YY" onkeyup="addDateSeparator(event,this,'dd-mm-yyyy')"/></td>
                        -->   
                        </tr>
                    </table>

                </fieldset>

            </div>
        </form>
    </center>
</body>
</html>
