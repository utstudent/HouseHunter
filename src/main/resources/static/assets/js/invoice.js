
$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');
        console.log({href})

        $.get(href, function(invoice, status){
        console.log({invoice})
            $('#idEdit').val(invoice.id);
            $('#descriptionEdit').val(invoice.description);
            $('#capitalEdit').val(invoice.capital);
            $('#codeEdit').val(invoice.code);
            $('#continentEdit').val(invoice.continent);
            $('#nationalityEdit').val(invoice.nationality);
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

        $.get(href, function(invoice, status){
        $('#idDetail').val(invoice.id);
        $('#descriptionDetail').val(invoice.description);
        $('#capitalDetail').val(invoice.capital);
        $('#codeDetail').val(invoice.code);
        $('#continentDetail').val(invoice.continent);
        $('#nationalityDetail').val(invoice.nationality);
        $('#lastModifiedByDetails').val(invoice.lastModifiedBy);
        $('#lastModifiedDateDetails').val(invoice.lastModifiedDate.substr(0,19).replace("T", " "));

        });

        $('#detailsModal').modal();
    })

}
);