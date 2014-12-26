<%-- 
    Document   : serach_result
    Created on : Oct 20, 2014, 1:15:15 PM
    Author     : audax
--%>


<%@page import="java.sql.ResultSet"%>
<%@page import="Controller.FarmerManager"%>
<%@page import="Utility.GrantConnectors"%>
<%@page import="java.sql.Connection"%>
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


            table,th
            {
                border: 5px solid black;


            }


            tr,td
            {

                border: 1px solid black;
                width:1%;
                white-space:nowrap;

            }

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

        <%

            FarmerManager manager = new FarmerManager();
            ResultSet rs;

            //Search parameters
            int criteria = Integer.parseInt(request.getParameter("searcher"));
            String searchVariable = request.getParameter("searchItem");
            String field = request.getParameter("field");

            if (field.equals("IT")) {
        %>
        <script>alert("You're inside IT")</script>
        <%
            switch (criteria) {

                case 1:

                    rs = manager.searchITFarmNumber(searchVariable);


        %>
        <table>
            <tr>
                <th>Farm Number</th>
                <th>Total Farm Size</th>
                <th>Number Trees Cut</th>
                <th>Treated Farm Size</th>
                <th>Farmer Name</th>
                <th>ID Number</th>
                <th>IT Voucher</th>
                <th>TR Voucher</th>
                <th>IT Date</th>
                <th>IT Payable</th>
                <th>Old Farm Number</th>
                <th>Region</th>
                <th>Lot Number</th>


            </tr>
            <% while (rs.next()) {%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><%=rs.getString(13)%></td>



            </tr>
            <% }%>
        </table>


        <%
                break;

            case 2:

                rs = manager.searchITOldFNumber(searchVariable);

        %>
        <table>
            <tr>
                <th>Farm Number</th>
                <th>Total Farm Size</th>
                <th>Number Trees Cut</th>
                <th>Treated Farm Size</th>
                <th>Farmer Name</th>
                <th>ID Number</th>
                <th>IT Voucher</th>
                <th>TR Voucher</th>
                <th>IT Date</th>
                <th>IT Payable</th>
                <th>Old Farm Number</th>
                <th>Region</th>
                <th>Lot Number</th>


            </tr>
            <% while (rs.next()) {%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><%=rs.getString(13)%></td>



            </tr>
            <% }%>
        </table>


        <%
                break;

            case 3:

                rs = manager.searchRPFarmerName(searchVariable);


        %>
        <table>
            <tr>
                <th>Farm Number</th>
                <th>Total Farm Size</th>
                <th>Number Trees Cut</th>
                <th>Treated Farm Size</th>
                <th>Farmer Name</th>
                <th>ID Number</th>
                <th>IT Voucher</th>
                <th>TR Voucher</th>
                <th>IT Date</th>
                <th>IT Payable</th>
                <th>Old Farm Number</th>
                <th>Region</th>
                <th>Lot Number</th>


            </tr>
            <% while (rs.next()) {%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><%=rs.getString(13)%></td>



            </tr>
            <% }%>
        </table>


        <%
                break;

            case 4:

                rs = manager.searchITIDNumber(searchVariable);

        %>
        <table>
            <tr>
                <th>Farm Number</th>
                <th>Total Farm Size</th>
                <th>Number Trees Cut</th>
                <th>Treated Farm Size</th>
                <th>Farmer Name</th>
                <th>ID Number</th>
                <th>IT Voucher</th>
                <th>TR Voucher</th>
                <th>IT Date</th>
                <th>IT Payable</th>
                <th>Old Farm Number</th>
                <th>Region</th>
                <th>Lot Number</th>


            </tr>
            <% while (rs.next()) {%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><%=rs.getString(13)%></td>



            </tr>
            <% }%>
        </table>


        <%

                break;

            case 5:

                rs = manager.searchITLotNum(searchVariable);


        %>
        <table>
            <tr>
                <th>Farm Number</th>
                <th>Total Farm Size</th>
                <th>Number Trees Cut</th>
                <th>Treated Farm Size</th>
                <th>Farmer Name</th>
                <th>ID Number</th>
                <th>IT Voucher</th>
                <th>TR Voucher</th>
                <th>IT Date</th>
                <th>IT Payable</th>
                <th>Old Farm Number</th>
                <th>Region</th>
                <th>Lot Number</th>


            </tr>
            <% while (rs.next()) {%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><%=rs.getString(13)%></td>



            </tr>
            <% }%>
        </table>


        <%

                break;

            case 6:

                rs = manager.searchITVouch(searchVariable);

        %>
        <table>
            <tr>
                <th>Farm Number</th>
                <th>Total Farm Size</th>
                <th>Number Trees Cut</th>
                <th>Treated Farm Size</th>
                <th>Farmer Name</th>
                <th>ID Number</th>
                <th>IT Voucher</th>
                <th>TR Voucher</th>
                <th>IT Date</th>
                <th>IT Payable</th>
                <th>Old Farm Number</th>
                <th>Region</th>
                <th>Lot Number</th>


            </tr>
            <% while (rs.next()) {%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><%=rs.getString(13)%></td>



            </tr>
            <% }%>
        </table>


        <%

                break;

            case 7:

                rs = manager.searchTRVouch(searchVariable);

        %>
        <table>
            <tr>
                <th>Farm Number</th>
                <th>Total Farm Size</th>
                <th>Number Trees Cut</th>
                <th>Treated Farm Size</th>
                <th>Farmer Name</th>
                <th>ID Number</th>
                <th>IT Voucher</th>
                <th>TR Voucher</th>
                <th>IT Date</th>
                <th>IT Payable</th>
                <th>Old Farm Number</th>
                <th>Region</th>
                <th>Lot Number</th>


            </tr>
            <% while (rs.next()) {%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><%=rs.getString(13)%></td>



            </tr>
            <% }%>
        </table>


        <%

                break;

            default:

        %>

        <script>
            alert("Nothing to see here");
        </script>

        <%                                break;
            }

        } else if (field.equals("RP")) {

        %>
        <script>alert("You're inside RP")</script>
        <%            switch (criteria) {

                case 1:

                    rs = manager.searchRPFarmNumber(searchVariable);

        %>
        <table>
            <tr>
                <th>Farm Number</th>
                <th>Old Farm Number</th>
                <th>Total Farm Size</th>
                <th>Treated Farm Size</th>
                <th>Farmer Name</th>
                <th>ID Number</th>
                <th>IT Voucher</th>
                <th>IT Date</th>
                <th>IT Payable</th>
                <th>RP Vouch</th>
                <th>Replant Date</th>
                <th>Area Replanted</th>
                <th>Qty Free Seed</th>

                <th>Qty Free Fert</th>
                <th>Gross Payable</th>
                <th>Total Deduction</th>
                <th>Net RP Payable</th>
                <th>Qty Fert Purchase</th>
                <th>Qty Seed Purchase</th>
                <th>Cost of Fert Allocated</th>
                <th>Cost of Seed</th>
                <th>Region</th>
                <th>RP LotNumber</th>
                <th>ID Number</th>
                <th>IT Vouch</th>
                <th>TR Vouch</th>


            </tr>
            <% while (rs.next()) {%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><%=rs.getString(13)%></td>


                <td><%=rs.getString(14)%></td>
                <td><%=rs.getString(15)%></td>
                <td><%=rs.getString(16)%></td>
                <td><%=rs.getString(17)%></td>
                <td><%=rs.getString(18)%></td>
                <td><%=rs.getString(19)%></td>
                <td><%=rs.getString(20)%></td>
                <td><%=rs.getString(21)%></td>
                <td><%=rs.getString(22)%></td>
                <td><%=rs.getString(23)%></td>
                <td><%=rs.getString(24)%></td>
                <td><%=rs.getString(25)%></td>
                <td><%=rs.getString(26)%></td>


            </tr>
            <% }%>
        </table>


        <%

                break;

            case 3:

                rs = manager.searchRPFarmerName(searchVariable);

        %>
        <table>
            <tr>
                <th>Farm Number</th>
                <th>Old Farm Number</th>
                <th>Total Farm Size</th>
                <th>Treated Farm Size</th>
                <th>Farmer Name</th>
                <th>ID Number</th>
                <th>IT Voucher</th>
                <th>IT Date</th>
                <th>IT Payable</th>
                <th>RP Vouch</th>
                <th>Replant Date</th>
                <th>Area Replanted</th>
                <th>Qty Free Seed</th>

                <th>Qty Free Fert</th>
                <th>Gross Payable</th>
                <th>Total Deduction</th>
                <th>Net RP Payable</th>
                <th>Qty Fert Purchase</th>
                <th>Qty Seed Purchase</th>
                <th>Cost of Fert Allocated</th>
                <th>Cost of Seed</th>
                <th>Region</th>
                <th>RP LotNumber</th>
                <th>ID Number</th>
                <th>IT Vouch</th>
                <th>TR Vouch</th>


            </tr>
            <% while (rs.next()) {%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><%=rs.getString(13)%></td>


                <td><%=rs.getString(14)%></td>
                <td><%=rs.getString(15)%></td>
                <td><%=rs.getString(16)%></td>
                <td><%=rs.getString(17)%></td>
                <td><%=rs.getString(18)%></td>
                <td><%=rs.getString(19)%></td>
                <td><%=rs.getString(20)%></td>
                <td><%=rs.getString(21)%></td>
                <td><%=rs.getString(22)%></td>
                <td><%=rs.getString(23)%></td>
                <td><%=rs.getString(24)%></td>
                <td><%=rs.getString(25)%></td>
                <td><%=rs.getString(26)%></td>


            </tr>
            <% }%>
        </table>


        <%

                break;

            case 8:

                rs = manager.searchRPLotNumber(searchVariable);

        %>
        <table>
            <tr>
                <th>Farm Number</th>
                <th>Old Farm Number</th>
                <th>Total Farm Size</th>
                <th>Treated Farm Size</th>
                <th>Farmer Name</th>
                <th>ID Number</th>
                <th>IT Voucher</th>
                <th>IT Date</th>
                <th>IT Payable</th>
                <th>RP Vouch</th>
                <th>Replant Date</th>
                <th>Area Replanted</th>
                <th>Qty Free Seed</th>

                <th>Qty Free Fert</th>
                <th>Gross Payable</th>
                <th>Total Deduction</th>
                <th>Net RP Payable</th>
                <th>Qty Fert Purchase</th>
                <th>Qty Seed Purchase</th>
                <th>Cost of Fert Allocated</th>
                <th>Cost of Seed</th>
                <th>Region</th>
                <th>RP LotNumber</th>
                <th>ID Number</th>
                <th>IT Vouch</th>
                <th>TR Vouch</th>


            </tr>
            <% while (rs.next()) {%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><%=rs.getString(13)%></td>


                <td><%=rs.getString(14)%></td>
                <td><%=rs.getString(15)%></td>
                <td><%=rs.getString(16)%></td>
                <td><%=rs.getString(17)%></td>
                <td><%=rs.getString(18)%></td>
                <td><%=rs.getString(19)%></td>
                <td><%=rs.getString(20)%></td>
                <td><%=rs.getString(21)%></td>
                <td><%=rs.getString(22)%></td>
                <td><%=rs.getString(23)%></td>
                <td><%=rs.getString(24)%></td>
                <td><%=rs.getString(25)%></td>
                <td><%=rs.getString(26)%></td>


            </tr>
            <% }%>
        </table>


        <%

                break;

            case 2:

                rs = manager.searchRPOldNumber(searchVariable);

        %>
        <table>
            <tr>
                <th>Farm Number</th>
                <th>Old Farm Number</th>
                <th>Total Farm Size</th>
                <th>Treated Farm Size</th>
                <th>Farmer Name</th>
                <th>ID Number</th>
                <th>IT Voucher</th>
                <th>IT Date</th>
                <th>IT Payable</th>
                <th>RP Vouch</th>
                <th>Replant Date</th>
                <th>Area Replanted</th>
                <th>Qty Free Seed</th>

                <th>Qty Free Fert</th>
                <th>Gross Payable</th>
                <th>Total Deduction</th>
                <th>Net RP Payable</th>
                <th>Qty Fert Purchase</th>
                <th>Qty Seed Purchase</th>
                <th>Cost of Fert Allocated</th>
                <th>Cost of Seed</th>
                <th>Region</th>
                <th>RP LotNumber</th>
                <th>ID Number</th>
                <th>IT Vouch</th>
                <th>TR Vouch</th>


            </tr>
            <% while (rs.next()) {%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><%=rs.getString(13)%></td>


                <td><%=rs.getString(14)%></td>
                <td><%=rs.getString(15)%></td>
                <td><%=rs.getString(16)%></td>
                <td><%=rs.getString(17)%></td>
                <td><%=rs.getString(18)%></td>
                <td><%=rs.getString(19)%></td>
                <td><%=rs.getString(20)%></td>
                <td><%=rs.getString(21)%></td>
                <td><%=rs.getString(22)%></td>
                <td><%=rs.getString(23)%></td>
                <td><%=rs.getString(24)%></td>
                <td><%=rs.getString(25)%></td>
                <td><%=rs.getString(26)%></td>


            </tr>
            <% }%>
        </table>


        <%

                break;

            case 9:

                rs = manager.searchRPVouch(searchVariable);

        %>
        <table>
            <tr>
                <th>Farm Number</th>
                <th>Old Farm Number</th>
                <th>Total Farm Size</th>
                <th>Treated Farm Size</th>
                <th>Farmer Name</th>
                <th>ID Number</th>
                <th>IT Voucher</th>
                <th>IT Date</th>
                <th>IT Payable</th>
                <th>RP Vouch</th>
                <th>Replant Date</th>
                <th>Area Replanted</th>
                <th>Qty Free Seed</th>

                <th>Qty Free Fert</th>
                <th>Gross Payable</th>
                <th>Total Deduction</th>
                <th>Net RP Payable</th>
                <th>Qty Fert Purchase</th>
                <th>Qty Seed Purchase</th>
                <th>Cost of Fert Allocated</th>
                <th>Cost of Seed</th>
                <th>Region</th>
                <th>RP LotNumber</th>
                <th>ID Number</th>
                <th>IT Vouch</th>
                <th>TR Vouch</th>


            </tr>
            <% while (rs.next()) {%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><%=rs.getString(13)%></td>


                <td><%=rs.getString(14)%></td>
                <td><%=rs.getString(15)%></td>
                <td><%=rs.getString(16)%></td>
                <td><%=rs.getString(17)%></td>
                <td><%=rs.getString(18)%></td>
                <td><%=rs.getString(19)%></td>
                <td><%=rs.getString(20)%></td>
                <td><%=rs.getString(21)%></td>
                <td><%=rs.getString(22)%></td>
                <td><%=rs.getString(23)%></td>
                <td><%=rs.getString(24)%></td>
                <td><%=rs.getString(25)%></td>
                <td><%=rs.getString(26)%></td>


            </tr>
            <% }%>
        </table>


        <%

                break;

            default:

        %>

        <script>
            alert("Nothing to see here");
        </script>

        <%                                break;

                }
            }


        %>


    </body>
</html>
