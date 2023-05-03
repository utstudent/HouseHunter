
$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(supplier, status){
            $('#idEdit').val(supplier.id);
            $('#nameEdit').val(supplier.name);
            $('#phoneEdit').val(supplier.phone);
            $('#emailEdit').val(supplier.email);
            $('#addressEdit').val(supplier.address);
            $('#cityEdit').val(supplier.city);
            $('#ddlStateEdit').val(supplier.stateid);
            $('#ddlCountryEdit').val(supplier.countryid);
            $('#websiteEdit').val(supplier.website);
            $('#detailsEdit').val(supplier.details);
        });
        $('#editModal').modal();
    });

    $('table #deleteButton').on('click', function(event){
        event.preventDefault;
        var href = $(this).attr('href');

        $('#confirmDeleteButton').attr('href', href);

        $('#deleteModal').modal();
    });

    $('table #detailsButton').on('click', function(event){
            event.preventDefault();

            var href =$(this).attr('href');

            $.get(href, function(supplier, status){
                $('#idDetail').val(supplier.id);
                $('#nameDetail').val(supplier.name);
                $('#phoneDetail').val(supplier.phone);
                $('#emailDetail').val(supplier.email);
                $('#addressDetail').val(supplier.address);
                $('#cityDetail').val(supplier.city);
                $('#ddlStateDetail').val(supplier.stateid);
                $('#ddlCountryDetail').val(supplier.countryid);
                $('#websiteDetail').val(supplier.website);
                $('#detailsDetail').val(supplier.details);
                $('#lastModifiedByDetails').val(supplier.lastModifiedBy);
                $('#lastModifiedDateDetails').val(supplier.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

}
);