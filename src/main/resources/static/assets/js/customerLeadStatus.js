$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(customerLeadStatus, status){
            $('#idEdit').val(customerLeadStatus.id);
            $('#descriptionEdit').val(customerLeadStatus.description);
            $('#detailsEdit').val(customerLeadStatus.details);
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

            $.get(href, function(customerLeadStatus, status){
                $('#idDetail').val(customerLeadStatus.id);
                $('#descriptionDetail').val(customerLeadStatus.description);
                $('#detailsDetail').val(customerLeadStatus.details);
                $('#lastModifiedByDetails').val(state.lastModifiedBy);
                $('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

}
);