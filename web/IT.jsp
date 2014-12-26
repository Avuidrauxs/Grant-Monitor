<%-- 
    Document   : IT
    Created on : Oct 16, 2014, 3:19:36 PM
    Author     : audax
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Initial Treatment</title>
        <% String cp = request.getContextPath ();%>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="icon" href="/img/favChed.png" type="image/png" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <script src="jquery-2.js"></script> 

        
<!--
<script src="jquery.mobile-1.4.2/jquery.mobile-1.4.2.js"></script>
        <link rel="stylesheet" href= "jquery.mobile-1.4.2/jquery.mobile-1.4.2.css" >
       -->





        <script src="js/parsley.js"></script>


        <script src="js/main.js"></script>

        <style>

            body
            {
                //zoom: 80%;
                font-size: 70%;
            }
            zoom {
                zoom: 70%;
            }

            table
            {
                padding: 20px;
                white-space: nowrap;
                //table-layout: fixed;
                width: 100%;

            }

            label
            {
                //width: 4em;
                float: left;
                text-align: right;
                margin-right: 0.5em;
                display: block
            }

            .submit input
            {
                margin-left: 4.5em;
            } 


            input
            {
                color: #781351;
                background: #fee3ad;
                border: 1px solid #781351
            }


            fieldset
            {
                display: inline-block;
                margin-top: 20px;
                border: 1px solid #781351;
                //width: 70em
            }

            legend
            {

                color: #fff;
                background: #ffa20c;
                border: 1px solid #781351;
                padding: 2px 6px;
                font-size: 20px;
            } 

        </style>


    </head>
    <body onload="myLot()">


        <div data-role="main" style="background-color: transparent; height: 100%; " id="farmerArea" class="ui-content" >

            <form action="./InputsServlet" method="post" data-parsley-validate>

                <div style="position: fixed; top: 0">

                    <input type="submit" value="REGISTER" name="register" id="registerid" >
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <script>
                        function myLot() {

                            prefixes();
                            var lin = localStorage.getItem("lotNumber")
                            var lotVal = prompt("Please Enter Lot Number", lin);

                            if (lotVal == "") {
                                alert("You didn't enter lot number");
                            }

                            else {
                                alert("Lot number entered!!");
                                // Store
                                localStorage.setItem("lotNumber", lotVal);
                                // Retrieve
                                document.getElementById("inLot").innerHTML = lotVal;

                                var elem = document.getElementById("lotNumbers");
                                elem.value = localStorage.getItem("lotNumber");

                            }

                        }


                        function mySto()
                        {

                            //alert("Lot number entered!!");

                            // Check browser support
                            if (typeof (Storage) != "undefined") {
                                // Store
                                localStorage.setItem("lotNumber", lotVal);
                                // Retrieve
                                document.getElementById("inLot").innerHTML = localStorage.getItem("lotNumber");
                            } else {
                                document.getElementById("inLot").innerHTML = "Sorry, your browser does not support Web Storage...";



                            }

                        }




                    </script>

                    <input type="button" value="LOT NUMBER" name="register" id="registerid" onclick="myLot()" >

                </div>
                <center>

                    <h1 id="inLot" onclick="myLot()">LOT NUMBER</h1>
                    <br>
                    <fieldset>

                        <legend>Farmer Details</legend>
                        <table>
                            <tr>
                                <td>
                                    Region: &nbsp;  <select name="Regions" id='a' >   </select>
                                </td>

                                <td>
                                    Farmer's Name : &nbsp; <input type="text" data-parsley-pattern="\w*" data-parsley-length="[6,100]" id="farmerName" name="farmerName" style="text-transform: capitalize"    required="">
                                </td>
                                <td>
                                    Sex :&nbsp;
                                    <input type="radio" name="sex" value="male" required="false" > Male &nbsp;
                                    <input type="radio" name="sex" value="female" > Female
                                </td>
                                <td>

                                    Age :  <input type="number" name ="age" min="0" style="width: 40px" id="age"  pattern="\d*" data-parsley-type="integer" required >

                                </td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td>
                                    District ID :  

                                    <select name="Districts" id='b' >

                                    </select>
                                </td>
                                <td>
                                    Farmer's Location :

                                    <input type="text" name="location" id="location" style="text-transform: capitalize"  required>

                                </td>

                                <td>

                                    National ID Type :

                                    <select name="nationalid"> 

                                        <option value="voters">Voter's ID </option>
                                        <option value="NHIS">NHIS </option>
                                        <option value='passport>'>Passport </option>


                                    </select>
                                </td>

                                <td>
                                    ID Number :

                                    <input type='text' id='natID' name="natID" style="width: 100px;"  pattern="\d*"  required >
                                </td>
                            </tr>
                        </table>
                    </fieldset>



                    <fieldset>
                        <legend>Initial Treatment</legend>

                        <table>
                            <tr>
                                <td>
                                    Initial Treatment No :

                                    <input type="text" id="initNum"  name="initNum" value="IT/"  style="width: 120px; text-transform: uppercase"  required>
                                </td>

                                <td>
                                    Tree Removal No :

                                    <input type="text" id="treeRemovalID" value="TR/" name="treeRemovalID" style="width: 120px; text-transform: uppercase" required="">
                                </td>
                                <td>
                                    Initial Treatment Date :

                                    <input type="text" required="" name="itDate" id="itDate" style="width: 120px; background-color:#0088bb;color: floralwhite" placeholder="DD-MM-YYYY" >
                                </td>
                                <td>
                                    Old Farm No. :
                                    <input type="text" id="oldFarmID" required="" name="oldFarmID">
                                </td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td>
                                    Sector Number :

                                    <input type="number" name="sectNo" id="sectNo" min="0" style="width: 80px" pattern="\d*" data-parsley-type="integer" required="">
                                </td>
                                <td>
                                    Block ID :  

                                    <input type="number" name="distNo" id="distNo" min="0" style="width: 80px" pattern="\d*" data-parsley-type="integer" required="" >
                                </td>
                                <td>
                                    Cocoa Area ID :

                                    <input type="number" name="caID" id="caID" min="0" style="width: 80px" pattern="\d*" data-parsley-type="integer" required="">
                                </td>
                                <td>
                                    Outbreak ID :

                                    <input type="text" name="obNo" id="obNo"  style="width: 80px; text-transform: uppercase" required data-parsley-type="alphanum">
                                </td>
                                <td>
                                    Farm ID :

                                    <input type="number" name="farmNo" min="0" id="farmNo" style="width: 80px" pattern="\d*" data-parsley-type="integer" required="">
                                </td>

                            </tr>
                        </table>
                        <fieldset>
                            <table>
                                <tr>
                                    <td>
                                        Outbreak Size :

                                        <input type="number" step="0.01" min="0" name="obSize" id="obSize" required=""  >
                                    </td>
                                    <td>
                                        Farms in Outbreak :

                                        <input type="number" step="0.01" min="0" name="farmObSize" id="farmObSize"  required="">
                                    </td>
                                    <td>
                                        Est. Trees in Outbreak Area :

                                        <input type="number" step="0.01" min="0" name="treesOb" id="treesOb"  required="">
                                    </td>

                                    <td>
                                        Cocoa Type :

                                        <select name="Ctype">

                                            <option value="mixed">Mixed</option>
                                            <option value="amelonado">Amelonado</option>
                                            <option value="amazonia">Amazonia</option>



                                            <option value="hybrid">Hybrid</option>
                                        </select>
                                    </td>
                                </tr>
                            </table>

                            <table>
                                <tr>

                                    <td>
                                        Farm Size :

                                        <input type="number" step="0.01" min="0" onchange="calcUntreated()" name="farmSize" id="farmSize" style="width: 80px" required="">
                                    </td> 
                                    <td>
                                        Trees Cut :

                                        <input type="number" step="any" min="0" name="treesCut" id="treesCut" style="width: 80px" required="">
                                    </td>
                                    <td>
                                        Treated Area :

                                        <input type="number" onchange="calcUntreated()" step="0.01" min="0" name="treatedArea" id="treatedArea" style="width: 80px"  required="">
                                    </td>
                                </tr>
                            </table>

                            <table>
                                <tr>


                                    <td>
                                        Untreated Farm Area :

                                        <p id="genUntreated">----</p>
                                    </td>
                                    <td>
                                        Trees Cut By :

                                        <select name="cutters">

                                            <option value="fosdak">FOSDAK ENTERPRISE</option>
                                            <option value="ched">CHED</option>

                                        </select>
                                    </td>


                                    <td>
                                        Cocoa Age Class : <br>

                                        <input type="radio" name="cocoaClass" id="aA" required value="A"> A 

                                        <input type="radio" name="cocoaClass" id="bB" value="B"> B

                                        <input type="radio" name="cocoaClass" id="c" value="C"> C 

                                        <input type="radio" name="cocoaClass" id="d" value="D"> D 
                                    </td>

                                </tr>
                            </table>

                        </fieldset>
                        <fieldset>
                            <legend>Administrative Details </legend>
                            <table>
                                <tr>
                                    <td>
                                        District Officer Name :

                                        <input type="text" name="distOfficer" id="distOfficer" data-parsley-pattern="\w*"  required="">
                                    </td>

                                    <td>
                                        District Officer Date Signed 
                                        <input type="text" id="distSigned" name="distSigned" required="" placeholder="DD-MM-YYYY"> 
                                    </td>
                                    <td>
                                        Technical Assistant :

                                        <input type="text" id="tAssist" name="tAssist" required="">
                                    </td>
                                    <td>

                                        TA Date Signed 
                                        <input type="text" id="taSigned" name="taSigned" required="" placeholder="DD-MM-YYYY"> 
                                    </td>
                                </tr>
                            </table>
                            <table>
                                <tr>
                                    <td>
                                        Reg Officer Name: 
                                        <input type="text" id="regOffName" name="regOffName" required="">

                                    </td>
                                    <td>
                                        Reg Officer Date Signed :

                                        <input type="text" id="regSigned" name="regSigned" required="" placeholder="DD-MM-YYYY">
                                    </td>


                                </tr>
                                <tr>

                                    <td><input type="hidden" id="lotNumbers"></td>
                                </tr>
                            </table>
                        </fieldset>

                    </fieldset>

            </form>
        </center>

    </div>
</body>
</html>

