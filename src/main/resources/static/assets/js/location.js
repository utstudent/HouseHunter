
$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(location, status){
            $('#idEdit').val(location.id);
            $('#addressEdit').val(location.address);
            $('#cityEdit').val(location.city);
            $('#ddlStateEdit').val(location.stateid);
            $('#zipcodeEdit').val(location.zipcode);
            $('#ddlCountryEdit').val(location.countryid);
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

            $.get(href, function(location, status){
                $('#idDetail').val(location.id);
                $('#addressDetail').val(location.address);
                $('#cityDetail').val(location.city);
                $('#ddlStateDetail').val(location.stateid);
                $('#zipcodeDetail').val(location.zipcode);
                $('#ddlCountryDetail').val(location.countryid);
                $('#createdByDetails').val(location.createdBy);
                $('#createdDateDetails').val(location.createdDate.substr(0,19).replace("T", " "));
                $('#lastModifiedByDetails').val(location.lastModifiedBy);
                $('#lastModifiedDateDetails').val(location.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

}
);