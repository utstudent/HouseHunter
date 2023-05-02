
$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(client, status){
            $('#idEdit').val(client.id);
            $('#nameEdit').val(client.name);
            $('#phoneEdit').val(client.phone);
            $('#emailEdit').val(client.email);
            $('#addressEdit').val(client.address);
            $('#cityEdit').val(client.city);
            $('#ddlStateEdit').val(client.stateid);
            $('#ddlCountryEdit').val(client.countryid);
            $('#websiteEdit').val(client.website);
            $('#detailsEdit').val(client.details);
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

            $.get(href, function(client, status){
                $('#idDetail').val(client.id);
                $('#nameDetail').val(client.name);
                $('#phoneDetail').val(client.phone);
                $('#emailDetail').val(client.email);
                $('#addressDetail').val(client.address);
                $('#cityDetail').val(client.city);
                $('#ddlStateDetail').val(client.stateid);
                $('#ddlCountryDetail').val(client.countryid);
                $('#websiteetail').val(client.website);
                $('#detailsDetail').val(client.details);
                $('#lastModifiedByDetails').val(client.lastModifiedBy);
                $('#lastModifiedDateDetails').val(client.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

}
);