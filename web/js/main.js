/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */











function altAudax() {


//                 var data = [ // The data
//                        ['Ashanti', [
//                            'Juaso','Mampong','Offinso','Nkawie','Tepa','Antoakrom','Obuasi','Fumso'
//                        ]],
//                    
//                    
//                    
//                        ['Eastern', [
//                            "Oyoko","Suhum","Tafo","Nkawkaw","Kibi","Kade","Bawdua","Asamankese","Osino","Akros","Oda"
//                        ]],
//                    
//                     ['Western', [
//                            "Asankagwa","Samreboi","Sekondi","Tarkwa","Wassa Akropong","Dunkwa"
//                        ]],
//                    
//                     ['Central', [
//                            "Asikwa","Nyakrom","Jukwa","Assin Fosu"
//                        ]],
//                    
//                     ['Volta', [
//                            "Kpeve/Hohoe","Jasikan/Papase"
//                        ]],
//                    
//                     ['Brong Ahafo', [
//                           "Dormaa-Ahenkro","Bechem","Goaso","Berekum","Sankore"
//                        ]],
//                    
//                     ['West North', [
//                            'Jaaboso', 'Sefwi Bekwai','Essam','Enchi','Boako','Dadieso','Ankontombra'
//                        ]]
//                    
//                            ];





    var data = [// The data
        ['Ashanti', [
                'JUA', 'MAM', 'OFN', 'NKI', 'TEP', 'ANT', 'OBS', 'FUM'
            ]],
        ['Eastern', [
                "OYO", "SUH", "TAF", "NKW", "KIB", "KAD", "BWD", "ASM", "OSN", "AKR", "ODA"
            ]],
        ['Western South', [
                "ASG", "SMB", "SKD", "TAK", "WAK", "DUN"
            ]],
        ['Central', [
                "ASI", "NYK", "JUK", "FOS"
            ]],
        ['Volta', [
                "KHO", "JSP"
            ]],
        ['Brong Ahafo', [
                "DAH", "BEC", "GOS", "BEK", "SAN"
            ]],
        ['Western North', [
                'JAB', 'SBK', 'ESM', 'ENC', 'BUA', 'DDS', 'KTB'
            ]]

    ];

    $a = $('#a'); // The dropdowns
    $b = $('#b');

    for (var i = 0; i < data.length; i++) {
        var first = data[i][0];
        $a.append($("<option>").// Add options
                attr("value", first).
                data("sel", i).
                text(first));
    }

    $a.change(function() {
        var index = $(this).children('option:selected').data('sel');
        var second = data[index][1]; // The second-choice data

        $b.html(''); // Clear existing options in second dropdown

        for (var j = 0; j < second.length; j++) {
            $b.append($("<option>").// Add options
                    attr("value", second[j]).
                    data("sel", j).
                    text(second[j]));
        }
    }).change(); // Trigger once to add options at load of first choice



}

function calcUntreat() {

    var fmsize = document.getElementById('farmSize').value;
    var treatedA = document.getElementById('treatedArea').value;





    if (treatedA <= fmsize)
    {
        //toFixed(2) method will set the float value to 2 decimal places
        var unt = fmsize - treatedA;
        document.getElementById("genUntreated").innerHTML = unt.toFixed(2);
    }

    else
    {
        alert("Please Treated can't be more than farm size");

    }


}


function rehAreaNot()
{
    
     var fmsize = document.getElementById('rehFarmSize').value;
    var rehabed = document.getElementById('rehArea').value;





    if (rehabed <= fmsize)
    {
        //toFixed(2) method will set the float value to 2 decimal places
        var unt = fmsize - rehabed;
        document.getElementById("notRehab").innerHTML = unt.toFixed(2);
    }

    else
    {
        alert("Please Area to be rehabilitated cannot be more than farm size");

    }


}
    
    


function requi() {

    var lol = document.getElementById(lotNumbers).value;
    var genU = document.getElementById(genUntreated).value;

    if ((lol == "" || lol == null) && genU == "--.--")

    {

        alert("Please make sure LotNumber and Untreated area appears")

    }


}


function addDateSeparator(e, control, format) {

    this.Format = format;
    var keycode = (e.which) ? e.which : event.keyCode

    if (keycode > 31 && (keycode < 48 || keycode > 57)) {
        return false;
    } else {

        var DateFormatPattern = /^dd\-mm\-yyyy$|^mm\-dd\-yyyy$|^mm\-dd\-yyyy$|^yyyy\-mm\-dd$/;
        if (DateFormatPattern.test(this.Format)) {

            var SplitFormat = this.Format.split("-");
            if (control.value.length >= this.Format.length) {

                if (keycode != 8) {
                    return false;
                }
            }
            if (control.value.length == SplitFormat[0].length) {

                if (keycode != 8) {
                    control.value += '-';
                }
            }
            if (control.value.length == (SplitFormat[1].length + SplitFormat[0].length + 1)) {

                if (keycode != 8) {
                    control.value += '-20';
                }
            }
        } else {
            alert("Supplied date format parameter is incorrect.");
        }
    }
}


function prefixes()
{
    //mySto();
    altAudax();

    $('#initNum').keydown(function(e) {
        var oldvalue = $(this).val();
        var field = this;
        setTimeout(function() {
            if (field.value.indexOf('IT/') !== 0) {
                $(field).val(oldvalue);
            }
        }, 1);
    });
    
    
      $('#rehabNum').keydown(function(e) {
        var oldvalue = $(this).val();
        var field = this;
        setTimeout(function() {
            if (field.value.indexOf('1RHB/') !== 0) {
                $(field).val(oldvalue);
            }
        }, 1);
    });

    $("#treeRemovalID").keydown(function(e) {
        var oldvalue = $(this).val();
        var field = this;
        setTimeout(function() {
            if (field.value.indexOf('TR/') !== 0) {
                $(field).val(oldvalue);
            }
        }, 1);
    });



}

function altPref() {

    $('##initNum').keyup(function(e) {
        if (this.value.length < 7) {
            this.value = 'IT';
        }
        else if (this.value.indexOf('IT/') !== 0) {
            this.value = 'IT/' + String.fromCharCode(e.which);
        }
    });

}



function calcAreaNot()
{

    var a = document.getElementById("fmSize").value;
    var b = document.getElementById("areaRpl").value;

    if(b <= a )
    {
    var c = a - b;
    var d = b / 0.20 ;
    
    
    

    document.getElementById("areaNot").innerHTML = c.toFixed(2);
    var areaN = document.getElementById("areaNott");
    areaN.value = c.toFixed(2);
    //document.getElementById("fertAllo").innerHTML = d;
    var allocated = document.getElementById("fertAllo");
    allocated.value = d.toFixed(0);
    }
    else
    {
        alert("Area replanted cannot be greater than Treated Area");
        
    }

}




function fatAllo()
{
    var b = document.getElementById("areaRpl").value;
    var d = b / 0.20 ;
    document.getElementById("fertAllo").innerHTML = d;
}

function costFert() {

    var i = document.getElementById("fertPrice").value;
    var j = document.getElementById("fertPurchase").value;

    var k = i * j;
    document.getElementById("costFert").innerHTML = k.toFixed(2);
    var fert = document.getElementById("costFertt");
    fert.value = k.toFixed(2);

    if(k == 0)
    {
        return  k = 0;
    }

    return  k;

}


function costSeed()
{

    var s = document.getElementById("valSeed").value;
    var t = document.getElementById("seedPurchase").value;

    var p = s * t;
    document.getElementById("costSeed").innerHTML = p.toFixed(2);
    var cSeed = document.getElementById("costSeedd");
    cSeed.value = p.toFixed(2);


    if(p == 0)
    {
        return p = 0;
    }
    return p;
}


function grossRP() {



    var rRate = document.getElementById("rplRate").value;
    var areaRpl = document.getElementById("areaRpl").value;

    var gross = rRate * areaRpl;

    document.getElementById("grossRP").innerHTML = gross.toFixed(2);
    var grossP = document.getElementById("grossRPP");
    grossP.value = gross.toFixed(2);

    return gross;

}

function netRP()
{

   // var fs = document.getElementById("fertPrice").value;
   // var ss = document.getElementById("valSeed").value;
    var g = grossRP() - (costFert() + costSeed());
    //var pop = fs + ss;

    var netRP = g;


    document.getElementById("netRP").innerHTML = netRP.toFixed(2);
    var nrp = document.getElementById("netRPP");
    
    
    nrp.value = netRP.toFixed(2);
    var totalDeduct = document.getElementById("total");
    totalDeduct.value = costFert() + costSeed();
}


/* 
 * 
 *  OTHER CODES
 *   
 *     */


function myLot() {

    prefixes();
    var lin = localStorage.getItem("lotNumber")
    var lotVal = prompt("Please Enter Lot Number", lin);
    lotVal = lotVal.toUpperCase();  //converts it to uppercase
    if (lotVal == "" || lotVal == null) {
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


function rehCut()
{
    
    var tC = document.getElementById("rehTreesCut").value;
    var costa = tC * 0.53;
    
    document.getElementById("rehCost").innerHTML = costa.toFixed(2);
    
    
}

function rehLot() {

    prefixes();
    var lin = localStorage.getItem("rehLotNumbers")
    var lotVal = prompt("Please Enter Lot Number", lin);
    lotVal = lotVal.toUpperCase();  //converts it to uppercase
    if (lotVal == "" || lotVal == null) {
        alert("You didn't enter lot number");
    }

    else {
        alert("Lot number entered!!");
        // Store
        localStorage.setItem("rehLotNumbers", lotVal);
        // Retrieve
        document.getElementById("inLot").innerHTML = "RH/"+lotVal;

        var elem = document.getElementById("lotNumbers");
        elem.value = "RH/"+localStorage.getItem("rehLotNumbers");

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
        document.getElementById("inLot").innerHTML = localSto
        rage.getItem("lotNumber");
    } else {
        document.getElementById("inLot").innerHTML = "Sorry, your browser does not support Web Storage...";



    }

}






//<!-- This code makes the jump from textbox two to text box three -->
function check2()
{
    var letters2 = document.joe.distNo.value.length + 1;
    if (letters2 <= 2)
    {
        document.joe.distNo.focus()
    }
    else
    {
        document.joe.caID.focus()
    }
}

//<!-- This code makes the jump from textbox three to textbox four -->


function sectNo3()
{
    var letters3 = document.joe.sectNo.value.length + 1;
    if (letters3 <= 3)
    {
        document.joe.sectNo.focus()
    }
    else
    {
        document.joe.distNo.focus()
    }
}


function caID3()
{
    var letters3 = document.joe.caID.value.length + 1;
    if (letters3 <= 2)
    {
        document.joe.caID.focus()
    }
    else
    {
        document.joe.obNo.focus()
    }
}

function obNo3()
{
    var letters3 = document.joe.obNo.value.length + 1;
    if (letters3 <= 3)
    {
        document.joe.obNo.focus()
    }
    else
    {
        document.joe.farmNo.focus()
    }
}


function farmNo3()
{
    var letters3 = document.joe.farmNo.value.length + 1;
    if (letters3 <= 3)
    {
        document.joe.farmNo.focus()
    }
    else
    {
        document.joe.obSize.focus()
    }
}


//<!-- This code makes the jump from textbox four to the submit button -->
function check4()
{
    var letters4 = document.joe.mardi.value.length + 1;
    if (letters4 <= 4)
    {
        document.joe.mardi.focus()
    }
    else
    {
        document.joe.go.focus()
    }
}





