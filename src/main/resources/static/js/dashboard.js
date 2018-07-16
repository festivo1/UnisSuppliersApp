/* global dipo, number */

$(function () {
    $('.navbar-toggle-sidebar').click(function () {
        $('.navbar-nav').toggleClass('slide-in');
        $('.side-body').toggleClass('body-slide-in');
        $('#search').removeClass('in').addClass('collapse').slideUp(200);
    });
    $('#search-trigger').click(function () {
        $('.navbar-nav').removeClass('slide-in');
        $('.side-body').removeClass('body-slide-in');
        $('.search-input').focus();
    });
    //    dipo ko lagi
    $('.sbtn').on('click', function (event) {
        $('.myDipoCreateForm #dipoCreateModal').modal();
    });
    $('.ebtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (dipo, status) {
            $('.myDipoEditForm #id').val(dipo.id);
            $('.myDipoEditForm #userId').val(dipo.user.id);
            $('.myDipoEditForm #name').val(dipo.name);
            $('.myDipoEditForm #address').val(dipo.address);
            $('.myDipoEditForm #contactNumber').val(dipo.contactNumber);
            $('.myDipoEditForm #panNumber').val(dipo.panNumber);
            $('.myDipoEditForm #id').val(dipo.id);
            var date = new Date(dipo.addedDate);//dipo.addedDate;
            var month = (date.getMonth() + 1);
            var day = date.getDate();
            if (month < 10)
                month = "0" + month;
            if (day < 10)
                day = "0" + day;
            var today = date.getFullYear() + '-' + month + '-' + day;
            $('.myDipoEditForm #addedDate').val(today);
        });
        $('.myDipoEditForm #dipoEditModal').modal();
    });
    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal ').modal();
    });
    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myTransactionModal #delRef').attr('href', href);
        $('#myTransactionModal ').modal();
    });
    //transaction ko lagi

    $('.sTranBtn').on('click', function (event) {
// var dipoName=$(dipo.name);
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (dipo, status) {
            $('.dipoName').text("Transactions of " + dipo.name);
            $('.myTransactionCreateForm #did').val(dipo.id);

            var now = new Date();
            var month = (now.getMonth() + 1);
            var day = now.getDate();
            if (month < 10)
                month = "0" + month;
            if (day < 10)
                day = "0" + day;
            var today = now.getFullYear() + '-' + month + '-' + day;
            $('.myTransactionCreateForm #addedDate').val(today);


//            var d = new Date();
//              $('.myTransactionCreateForm #addedDate').val(new Date().toDateInputValue());
//            $('.myTransactionCreateForm #soldNumber').val(0);
//            $('.myTransactionCreateForm #emptyRate').val(0);
//             if(soldNum==NULL){
//                 $('.myTransactionCreateForm #soldNumber').val(0);
//             }
        });
        $('.myTransactionCreateForm #transactionCreateModal').modal();
    });
    $('.eTranBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (dipo, status) {
            $('.myTransactionEditForm #id').val(dipo.id);
            $('.myTransactionEditForm #name').val(dipo.name);
            $('.myTransactionEditForm #address').val(dipo.address);
            $('.myTransactionEditForm #contactNumber').val(dipo.contactNumber);
            $('.myTransactionEditForm #panNumber').val(dipo.panNumber);
        });
        $('.myTransactionEditForm #transactionEditModal').modal();
        $('.myTransactionEditForm #transactionEditModal').reset();
    });
    // leakage ko lagi
    $('.sLeakageBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (dipo, status) {
            $('.dipoName').text("Leakage Transactions of " + dipo.name);
            $('.myLeakageCreateForm #did').val(dipo.id);
            var now = new Date();
            var month = (now.getMonth() + 1);
            var day = now.getDate();
            if (month < 10)
                month = "0" + month;
            if (day < 10)
                day = "0" + day;
            var today = now.getFullYear() + '-' + month + '-' + day;
            $('.myLeakageCreateForm #addedDate').val(today);
        });
        $('.myLeakageCreateForm #leakageCreateModal').modal();
    });
// amount ko lagi
    $('.sAmountBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (dipo, status) {
            $('.dipoName').text("Amount Records of " + dipo.name);
            $('.myAmountCreateForm #did').val(dipo.id);
            var now = new Date();
            var month = (now.getMonth() + 1);
            var day = now.getDate();
            if (month < 10)
                month = "0" + month;
            if (day < 10)
                day = "0" + day;
            var today = now.getFullYear() + '-' + month + '-' + day;
            $('.myAmountCreateForm #addedDate').val(today);
        });
        $('.myAmountCreateForm #amountCreateModal').modal();
    });
    // cylinder ko lagi
    $('.sCylinderBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (dipo, status) {
            $('.dipoName').text("CylinderRecords of " + dipo.name);
            $('.myCylinderCreateForm #did').val(dipo.id);
            var now = new Date();
            var month = (now.getMonth() + 1);
            var day = now.getDate();
            if (month < 10)
                month = "0" + month;
            if (day < 10)
                day = "0" + day;
            var today = now.getFullYear() + '-' + month + '-' + day;
            $('.myCylinderCreateForm #addedDate').val(today);
        });
        $('.myCylinderCreateForm #cylinderCreateModal').modal();
    });
});






//filter

$(document).ready(function () {
    $('.filterable .btn-filter').click(function () {
        var $panel = $(this).parents('.filterable'),
                $filters = $panel.find('.filters input'),
                $tbody = $panel.find('.table tbody');
        if ($filters.prop('disabled') == true) {
            $filters.prop('disabled', false);
            $filters.first().focus();
        } else {
            $filters.val('').prop('disabled', true);
            $tbody.find('.no-result').remove();
            $tbody.find('tr').show();
        }
    });
    $('.filterable .filters input').keyup(function (e) {
        /* Ignore tab key */
        var code = e.keyCode || e.which;
        if (code == '9')
            return;
        /* Useful DOM data and selectors */
        var $input = $(this),
                inputContent = $input.val().toLowerCase(),
                $panel = $input.parents('.filterable'),
                column = $panel.find('.filters th').index($input.parents('th')),
                $table = $panel.find('.table'),
                $rows = $table.find('tbody tr');
        /* Dirtiest filter function ever ;) */
        var $filteredRows = $rows.filter(function () {
            var value = $(this).find('td').eq(column).text().toLowerCase();
            return value.indexOf(inputContent) === -1;
        });
        /* Clean previous no-result if exist */
        $table.find('tbody .no-result').remove();
        /* Show all rows, hide filtered ones (never do that outside of a demo ! xD) */
        $rows.show();
        $filteredRows.hide();
        /* Prepend no-result row if all rows are filtered */
        if ($filteredRows.length === $rows.length) {
            $table.find('tbody').prepend($('<tr class="no-result text-center"><td colspan="' + $table.find('.filters th').length + '">No result found</td></tr>'));
        }
    });
});
window.onload = function () {
    var sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0, sum6 = 0, sum7 = 0;
    var dataTable = document.getElementById("table1");
    // use querySelector to find all sseventh table cells
    var cells7 = document.querySelectorAll("td:nth-of-type(7)");
    for (var i = 0; i < cells7.length; i++)
        sum7 += parseFloat(cells7[i].firstChild.data);
    var cells3 = document.querySelectorAll("td:nth-of-type(3)");
    for (var i = 0; i < cells3.length; i++)
        sum3 += parseFloat(cells3[i].firstChild.data);
    var cells5 = document.querySelectorAll("td:nth-of-type(5)");
    for (var i = 0; i < cells5.length; i++)
        sum5 += parseFloat(cells5[i].firstChild.data);
    // now add sum to end of table
    var newRow = document.createElement("tr");
    newRow.style.color = "blue";
    // first cell
    var firstCell = document.createElement("td");
    var firstCellText = document.createTextNode("Sum:");
    firstCell.appendChild(firstCellText);
    newRow.appendChild(firstCell);
    // second cell with sum
    var secondCell = document.createElement("td");
    var secondCellText = document.createTextNode(sum2);
    secondCell.appendChild(secondCellText);
    newRow.appendChild(secondCell);
    // third cell with sum
    var thirdCell = document.createElement("td");
    var thirdCellText = document.createTextNode(sum3);

    if (Number.isInteger(sum3)) {
        thirdCell.appendChild(thirdCellText);

        //if (thirdCell.appendChild(thirdCellText) instanceof Number) {
        //if(true)  {
        newRow.appendChild(thirdCell);
    }
    // fourth cell with sum
    var fourthCell = document.createElement("td");
    var fourthCellText = document.createTextNode("");
    fourthCell.appendChild(fourthCellText);
    newRow.appendChild(fourthCell);
    // fifth cell with sum
    var fifthCell = document.createElement("td");
    var fifthCellText = document.createTextNode(sum5);
    fifthCell.appendChild(fifthCellText);
    newRow.appendChild(fifthCell);
    // sixth cell with sum
    var sixthCell = document.createElement("td");
    var sixthCellText = document.createTextNode("");
    sixthCell.appendChild(sixthCellText);
    newRow.appendChild(sixthCell);
    //seventh cell with sum
    var seventhCell = document.createElement("td");
    var seventhCellText = document.createTextNode(sum7);
    seventhCell.appendChild(seventhCellText);
    newRow.appendChild(seventhCell);
    // add  to table
    var tta = document.getElementById('getAmount');

    tta.innerHTML = sum7;

    tta.style.color = 'green';
    var title = document.getElementById('dipoName');
    title.style.color = "green";
    title.style.fontSize = "30px";
    dataTable.appendChild(newRow);

    console.log(sum7);
    console.log(document.getElementById('table1').rows[0].cells.length);

//    var balance =document.getElementById("amountTable");
//    cells4 = document.querySelectorAll("td:nth-of-type(4)");
//    for (var i = 0; i < cells4.length; i++)
//        sum4 += parseFloat(cells4[i].firstChild.data);
//    newRow = document.createElement("tr");
//    newRow.style.color = "blue";
//     firstCell = document.createElement("td");
//     firstCellText = document.createTextNode("Sum:");
//    firstCell.appendChild(firstCellText);
//    newRow.appendChild(firstCell);
//    balance.appendChild(newRow);
//    console.log(sum4);
};
/**
 * Comment
 */
//window.onload = function () {
// var columnLength = document.getElementById('table1').rows[0].cells.length;
//    var sum = new Array();
//    var cells = new Array();
//    var cellText = new Array();
//    var cellElement = new Array();
//    var dataTable = document.getElementById("table1");
//    for (var i = 3; i < columnLength; i++){
//     sum[i] = 0;
//             cells[i] = document.querySelectorAll("td:nth-of-type(3)");
//    for (var j = 0; j < cells[i].length; j++) {
//        sum[i] += parseFloat(cells[i].firstChild.data);
//
//    }
//    var newRow = document.createElement("tr");
//             cellElement[i] = document.createElement("td");
//            cellText[i] = document.createTextNode(sum[i]);
//    cellElement[i].appendChild(cellText[i]);
//    newRow.appendChild(cellElement[i]);
//    }
//    dataTable.appendChild(newRow);
//};

//
//
//$(function(){
//	function tally (selector) {
//		$(selector).each(function () {
//			var total = 0,
//				column = $(this).siblings(selector).andSelf().index(this);
//			$(this).parents().prevUntil(':has(' + selector + ')').each(function () {
//				total += parseFloat($('td.sum:eq(' + column + ')', this).html()) || 0;
//			})
//			$(this).html(total);
//		});
//	}
//	tally('td.subtotal');
//	tally('td.total');
//});
//
//var totals = [];
//// Go through each row
//$('#tb').find('tr').each(function() {
//    var $row = $(this);
//
//    // Then each column
//    $row.children('td').not('.total-ignore').each(function(index) {
//        // "Initialize" the totals array. Basically this equals itself or 0. 
//        // This is important because you can't add to undefined!
//        totals[index] = totals[index] || 0;
//
//        // Add the total. This will either add the value if it's a number
//        // or 0 if it's blank/not a number
//        totals[index] += parseInt($(this).text()) || 0;
//    });
//})
//
//// Loop through each column in the foooter and update the values
//$('#totals td').not('.total-ignore').each(function(index) {
//    $(this).text(totals[index]);
//});
//



function cylformValidatorCheck() {

    var refilledNumber = document.getElementById("refilledNumber");
    if (refilledNumber.value === "") {
        refilledNumber.value = 0;

    }

}
;
function amtformValidatorCheck() {

    var decrementedAmount = document.getElementById("decrementedAmount");
    if(decrementedAmount.value ===""){
        decrementedAmount.value = 0;

    }

}
;
/**
 * Comment
 */
function leakValidationCheck() {
 var receivedLeakage = document.getElementById("receivedLeakage");
 var refilledLeakage = document.getElementById("refilledLeakage");
 var addedDate = document.getElementById("addedDate");
    if (receivedLeakage.value === "" && refilledLeakage.value=== "" ) {
        alert("fields can't be null");
        return false;
    }
    
    else if (!(receivedLeakage.value === "") && (!refilledLeakage.value=== "") && addedDate.object===null) {
        alert("add the date!!");
        return false;
    }
    else if(receivedLeakage.value === "" || refilledLeakage.value=== "") {
         if(receivedLeakage.value===""){
             receivedLeakage.value=0;
         }
         else{
             refilledLeakage.value=0;
         }
    }
    else{
        confirm("Do you want to save?"); 
    }

    
};


function formValidatorCheck() {
    var refilledNum = document.getElementById("transactedNumber");
    var refilledRate = document.getElementById("refilledRate");
    var soldNum = document.getElementById("soldNumber");
    var fullRate = document.getElementById("fullRate");

    if (!(refilledNum.value > -1) || !(refilledRate.value > -1) || !(soldNum.value > -1) || !(fullRate.value > -1)) {
        alert("Field should not be negative");
        return false;
    } else if (refilledNum.value === "" && soldNum.value === "") {
        alert("All four field can't be empty");
//        refilledNum.value = 0;
//        refilledRate.value = 0;

        return false;
    } else if ((refilledNum.value !== "" && soldNum.value === "") && ((refilledRate.value > 1000) && (refilledRate.value < 2000))) {

        soldNum.value = 0;
        fullRate.value = 0;
        return confirm('Do you really want to submit the form?');
        //return false;
    } else if ((refilledNum.value === "" && soldNum.value !== "") && ((fullRate.value > 3000) && (fullRate.value < 5000))) {

        refilledNum.value = 0;
        refilledRate.value = 0;
        return confirm('Do you really want to submit the form?');
        //return false;
    } else if (refilledNum.value > 0 || soldNum.value > 0) {
        if (!(refilledRate.value > 1000) || !(refilledRate.value < 2000) || !(fullRate.value > 3000) || !(fullRate.value < 5000)) {
// transactedNum.value=0;
//            if ((refilledRate.value < 1000 || refilledRate.value > 2000) && (soldNum==="") ) {
//                alert("Refilled Rate maynot be in range");
//                refilledRate.focus();
//                refilledRate.style.border = "3px solid red";
//                return false;
//            }
//            else if ((fullRate.value < 2000 || fullRate.value > 5000 ) && refilledRate==="" ) {
//            
//                alert("Full Rate maynot be in range");
//                fullRate.focus();
//                fullRate.style.border = "3px solid red";
//                return false;
//            }
//            else{
//                refilledRate.focus();
//                refilledRate.style.border = "3px solid red";
//                fullRate.focus();
//                fullRate.style.border = "3px solid red";
//                return false;
//            }
            alert("Rate maynot be in range");
            return false;
        }
    } else {
        return confirm('Do you really want to submit the form?');

    }
    return confirm('Do you really want to submit the form?');

}
;



var totals = [0, 0, 0];

$(document).ready(function () {

    var $dataRows = $("#sum_table tr:not('.totalColumn, .titlerow')");

    $dataRows.each(function () {
        $(this).find('.rowDataSd').each(function (i) {
            totals[i] += parseInt($(this).html());
        });
    });
    $("#sum_table td.totalCol ").each(function (i) {
        $(this).html(totals[i]);

        if (totals[i] < 0) {
            $("#balance").html("Remaining Balance= " + totals[i]).css("color", "red");
            $("#dipoName").css("color", "red");
        } else {
            $("#balance").html("Remaining Balance= " + totals[i]).css("color", "green");

        }
        $("#dipoName").css("color", "green");

    });

    $("#sum_table td.totalCol ").each(function (i) {
        $(this).html(totals[i]);

        if (totals[i] < 0) {
            $("#remainingCyl").html("Remaining Cylinder= " + totals[i]).css("color", "red");

        } else {
            $("#remainingCyl").html("Remaining Cylinder:= " + totals[i]).css("color", "green");

        }
        $("#dipoName").css("color", "green");

    });

    $("#sum_table td.totalCol ").each(function (i) {
        $(this).html(totals[i]);

        if (totals[i] < 0) {
            $("#leakage").html("LeakageCylinderToReturn= " + totals[i]).css("color", "red");

            // $("#dipoName").css("color", "red");
        } else {
            $("#leakage").html("LeakageCylinderToReturn:= " + totals[i]).css("color", "green");

        }
        $("#dipoName").css("color", "green");

    });



});