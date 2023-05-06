$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(houseStatus, status){
            $('#idEdit').val(houseStatus.id);
            $('#descriptionEdit').val(houseStatus.description);
            $('#detailsEdit').val(houseStatus.details);
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

            $.get(href, function(houseStatus, status){
                $('#idDetail').val(houseStatus.id);
                $('#descriptionDetail').val(houseStatus.description);
                $('#detailsDetail').val(houseStatus.details);
                $('#createdByDetails').val(houseStatus.createdBy);
                $('#createdDateDetails').val(houseStatus.createdDate.substr(0,19).replace("T", " "));
                $('#lastModifiedByDetails').val(houseStatus.lastModifiedBy);
                $('#lastModifiedDateDetails').val(houseStatus.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

}
);