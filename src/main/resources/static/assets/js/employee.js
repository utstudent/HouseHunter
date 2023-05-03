
$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(employee, status){
            $('#idEdit').val(employee.id);
            $('#nameEdit').val(employee.name);
            $('#phoneEdit').val(employee.phone);
            $('#emailEdit').val(employee.email);
            $('#addressEdit').val(employee.address);
            $('#cityEdit').val(employee.city);
            $('#ddlStateEdit').val(employee.stateid);
            $('#ddlCountryEdit').val(employee.countryid);
            $('#websiteEdit').val(employee.website);
            $('#detailsEdit').val(employee.details);
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

            $.get(href, function(employee, status){
                $('#idDetail').val(employee.id);
                $('#nameDetail').val(employee.name);
                $('#phoneDetail').val(employee.phone);
                $('#emailDetail').val(employee.email);
                $('#addressDetail').val(employee.address);
                $('#cityDetail').val(employee.city);
                $('#ddlStateDetail').val(employee.stateid);
                $('#ddlCountryDetail').val(employee.countryid);
                $('#websiteDetail').val(employee.website);
                $('#detailsDetail').val(employee.details);
                $('#lastModifiedByDetails').val(employee.lastModifiedBy);
                $('#lastModifiedDateDetails').val(employee.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

}
);