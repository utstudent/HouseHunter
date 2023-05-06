$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(houseType, status){
            $('#idEdit').val(houseType.id);
            $('#descriptionEdit').val(houseType.description);
            $('#detailsEdit').val(houseType.details);
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

            $.get(href, function(houseType, status){
                $('#idDetail').val(houseType.id);
                $('#descriptionDetail').val(houseType.description);
                $('#detailsDetail').val(houseType.details);
                $('#createdByDetails').val(houseType.createdBy);
                $('#createdDateDetails').val(houseType.createdDate.substr(0,19).replace("T", " "));
                $('#lastModifiedByDetails').val(houseType.lastModifiedBy);
                $('#lastModifiedDateDetails').val(houseType.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

}
);