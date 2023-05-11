
$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(customerLead, status){
            $('#idEdit').val(customerLead.id);
            $('#firstNameEdit').val(customerLead.firstname);
            $('#lastNameEdit').val(customerLead.lastname);
            $('#phoneEdit').val(customerLead.phone);
            $('#emailEdit').val(customerLead.email);
            $('#jobTitleEdit').val(customerLead.jobTitle);
            $('#companyNameEdit').val(customerLead.companyName);
            $('#ddlCustomerLeadStatusEdit').val(customerLead.customerleadstatusid);
            $('#notesEdit').val(customerLead.notes);
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

            $.get(href, function(customerLead, status){
                $('#idDetail').val(customerLead.id);
                $('#firstNameDetail').val(customerLead.firstname);
                $('#lastNameDetail').val(customerLead.lastname);
                $('#phoneDetail').val(customerLead.phone);
                $('#emailDetail').val(customerLead.email);
                $('#jobTitleDetail').val(customerLead.jobTitle);
                $('#companyNameDetail').val(customerLead.companyName);
                $('#ddlCustomerLeadStatusDetail').val(customerLead.customerleadstatusid);
                $('#notesDetail').val(customerLead.notes);

                $('#createdByDetails').val(customerLead.createdBy);
                $('#createdDateDetails').val(customerLead.createdDate.substr(0,19).replace("T", " "));
                $('#lastModifiedByDetails').val(customerLead.lastModifiedBy);
                $('#lastModifiedDateDetails').val(customerLead.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

}
);