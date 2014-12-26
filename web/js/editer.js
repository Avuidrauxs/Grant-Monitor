/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




function loader(){
    var data = [// The data
        ['Initial Treatment and TR', [
                'ITVouch', 'TRVouch', 'ITDate', 'ITPayable', 'TRPayable', 'NumberOfTreesCut', 
                'FarmerName', 'IDNumber','OldFarmNumber','TotalFarmSize','EstTrees','TreatedFarmSize'
            ]],
        ['Replanting', [
                "RP GP Num", "RP Date", "Area replant", 'Gross RP', "Seeding qty prev purchase", 
                "Seedling qty free", "Seeding qty alloc", "Fert qty purchase", "Fert qty alloc", 
                "deduction cost of seed", "deduction cost fert", "total deductions",'Net RP'
            ]]
    ];

    $a = $('#area'); // The dropdowns
    $b = $('#fields');

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