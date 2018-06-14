/* global dipo */

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
            $('.myDipoEditForm #name').val(dipo.name);
            $('.myDipoEditForm #address').val(dipo.address);
            $('.myDipoEditForm #contactNumber').val(dipo.contactNumber);
            $('.myDipoEditForm #panNumber').val(dipo.panNumber);
            $('.myDipoEditForm #id').val(dipo.id);

        });
        $('.myDipoEditForm #dipoEditModal').modal();
    });

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal ').modal();

    });
    
    
    //transaction ko lagi
    
     $('.sTranBtn').on('click', function (event) {
        // var dipoName=$(dipo.name);
         event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (dipo, status) {
            $('#dipoName').text("Transactions of "+ dipo.name);
             $('.myTransactionCreateForm #did').val(dipo.id);
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
    });

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myTransactionModal #delRef').attr('href', href);
        $('#myTransactionModal ').modal();

    });
    

});


