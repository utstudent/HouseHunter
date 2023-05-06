
$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');
        console.log({href})

        $.get(href, function(country, status){
        console.log({country})
            $('#idEdit').val(country.id);
            $('#descriptionEdit').val(country.description);
            $('#capitalEdit').val(country.capital);
            $('#codeEdit').val(country.code);
            $('#continentEdit').val(country.continent);
            $('#nationalityEdit').val(country.nationality);
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

        $.get(href, function(country, status){
        $('#idDetail').val(country.id);
        $('#descriptionDetail').val(country.description);
        $('#capitalDetail').val(country.capital);
        $('#codeDetail').val(country.code);
        $('#continentDetail').val(country.continent);
        $('#nationalityDetail').val(country.nationality);
        $('#createdByDetails').val(country.createdBy);
        $('#createdDateDetails').val(country.createdDate.substr(0,19).replace("T", " "));
        $('#lastModifiedByDetails').val(country.lastModifiedBy);
        $('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));

        });

        $('#detailsModal').modal();
    })

}
);