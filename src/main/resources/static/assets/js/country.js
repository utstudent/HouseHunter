
$(document).ready(function(){

    $('.table.btn-group#editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(country, status){
            $('#idEdit').val(country.id);
            $('#descriptionEdit').val(country.description);
            $('#capitalEdit').val(country.capital);
            $('#codeEdit').val(country.code);
            $('#continentEdit').val(country.continent);
            $('#nationalityEdit').val(country.nationality);
        });

        $('#editModal').modal();
    });

//    $('.table .btn-primary').on('click',function(event){
//    		event.preventDefault();
//    		var href= $(this).attr('href');
//    		$.get(href, function(country, status){
//    			$('#idEdit').val(country.id);
//    			$('#descriptionEdit').val(country.description);
//    			$('#codeEdit').val(country.code);
//    		});
//    		$('#editModal').modal();
//    	});

}
);