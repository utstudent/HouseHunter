
$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(employee, status){
            $('#firstNameEdit').val(employee.firstname);
            $('#lastNameEdit').val(employee.lastname);
            $('#aboutEdit').val(employee.about);
            $('#ddlJobTitleEdit').val(employee.jobtitleid);
            $('#ddlEmployeeTypeEdit').val(employee.employeetypeid);
            $('#ddlCountryEdit').val(employee.countryid);
            $('#addressEdit').val(employee.address);
            $('#cityEdit').val(employee.city);
            $('#ddlStateEdit').val(employee.stateid);
            $('#phoneEdit').val(employee.phone);
            $('#emailEdit').val(employee.email);

        });
        $('#editModal').modal();
    });

//    $('.table .btn-primary').on('click',function(event){
//    		event.preventDefault();
//    		var href= $(this).attr('href');
//    		$.get(href, function(client, status){
//    			$('#txtAddressEdit').val(client.address);
//    			$('#txtCityEdit').val(client.city);
//    			$('#ddlCountryEdit').val(client.countryid);
//    			$('#txtDetailsEdit').val(client.details);
//    		});
//    		$('#editModal').modal();
//    	});

    $('table #deleteButton').on('click', function(event){
        event.preventDefault;
        var href = $(this).attr('href');

        $('#confirmDeleteButton').attr('href', href);

        $('#deleteModal').modal();
    });

    $('.table #photoButton').on('click',function(event) {
       event.preventDefault();
       var href = $(this).attr('href');
       $('#photoModal #employeePhoto').attr('src', href);
       $('#photoModal').modal();
    });

}
);