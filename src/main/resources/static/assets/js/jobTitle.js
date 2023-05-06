$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(jobTitle, status){
            $('#idEdit').val(jobTitle.id);
            $('#descriptionEdit').val(jobTitle.description);
            $('#detailsEdit').val(jobTitle.details);
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

            $.get(href, function(jobTitle, status){
                $('#idDetail').val(jobTitle.id);
                $('#descriptionDetail').val(jobTitle.description);
                $('#detailsDetail').val(jobTitle.details);
                $('#createdByDetails').val(jobTitle.createdBy);
                $('#createdDateDetails').val(jobTitle.createdDate.substr(0,19).replace("T", " "));
                $('#lastModifiedByDetails').val(jobTitle.lastModifiedBy);
                $('#lastModifiedDateDetails').val(jobTitle.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

}
);