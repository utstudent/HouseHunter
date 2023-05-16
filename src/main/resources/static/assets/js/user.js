$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(user, status){
            $('#idEdit').val(user.id);
            $('#firstNameEdit').val(user.firstname);
            $('#lastNameEdit').val(user.lastname);
            $('#usernameEdit').val(user.username);
            $('#emailEdit').val(user.email);
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

            $.get(href, function(user, status){
                $('#idDetail').val(user.id);
                $('#firstNameDetail').val(user.firstname);
                $('#lastNameDetail').val(user.lastname);
                $('#usernameDetail').val(user.username);
                $('#emailDetail').val(user.email);
                $('#createdByDetails').val(user.createdBy);
                $('#createdDateDetails').val(user.createdDate.substr(0,19).replace("T", " "));
                $('#lastModifiedByDetails').val(user.lastModifiedBy);
                $('#lastModifiedDateDetails').val(user.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

}
);