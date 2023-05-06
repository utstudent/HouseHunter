
$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(state, status){
            $('#idEdit').val(state.id);
            $('#nameEdit').val(state.name);
            $('#capitalEdit').val(state.capital);
            $('#codeEdit').val(state.code);
            $('#ddlCountryEdit').val(state.countryid);
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

            $.get(href, function(state, status){
                $('#idDetail').val(state.id);
                $('#nameDetail').val(state.name);
                $('#capitalDetail').val(state.capital);
                $('#codeDetail').val(state.code);
                $('#ddlCountryDetail').val(state.countryid);
                $('#createdByDetails').val(state.createdBy);
                $('#createdDateDetails').val(state.createdDate.substr(0,19).replace("T", " "));
                $('#lastModifiedByDetails').val(state.lastModifiedBy);
                $('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

}
);