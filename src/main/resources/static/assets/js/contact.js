
$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(contact, status){
            $('#idEdit').val(contact.id);
            $('#firstNameEdit').val(contact.firstName);
            $('#lastNameEdit').val(contact.lastName);
            $('#phoneEdit').val(contact.phone);
            $('#emailEdit').val(contact.email);
            $('#addressEdit').val(contact.address);
            $('#cityEdit').val(contact.city);
            $('#ddlStateEdit').val(contact.stateid);
            $('#ddlCountryEdit').val(contact.countryid);
            $('#websiteEdit').val(contact.website);
            $('#detailsEdit').val(contact.details);
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

            $.get(href, function(contact, status){
                $('#idDetail').val(contact.id);
                $('#firstNameDetail').val(contact.firstName);
                $('#lastNameDetail').val(contact.lastName);
                $('#phoneDetail').val(contact.phone);
                $('#emailDetail').val(contact.email);
                $('#addressDetail').val(contact.address);
                $('#cityDetail').val(contact.city);
                $('#ddlStateDetail').val(contact.stateid);
                $('#ddlCountryDetail').val(contact.countryid);
                $('#websiteDetail').val(contact.website);
                $('#detailsDetail').val(contact.details);
                $('#createdByDetails').val(contact.createdBy);
                $('#createdDateDetails').val(contact.createdDate.substr(0,19).replace("T", " "));
                $('#lastModifiedByDetails').val(contact.lastModifiedBy);
                $('#lastModifiedDateDetails').val(contact.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

}
);