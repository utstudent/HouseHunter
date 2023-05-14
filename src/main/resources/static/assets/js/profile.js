
$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(employee, status){
            $('#idEdit').val(employee.id);
            $('#ddlTitleEdit').val(employee.title);
            $('#firstNameEdit').val(employee.firstname);
            $('#lastNameEdit').val(employee.lastname);
            $('#usernameEdit').val(employee.username);
            $('#ddlGenderEdit').val(employee.gender);

            var dateOfBirth = employee.dateOfBirth.substr(0,10);
            $('#dateOfBirthEdit').val(dateOfBirth);

            $('#phoneEdit').val(employee.phone);
            $('#emailEdit').val(employee.email);
            $('#ddlJobTitleEdit').val(employee.jobtitleid);
            $('#ddlEmployeeTypeEdit').val(employee.employeetypeid);

            var hireDate = employee.hireDate.substr(0,10);
            $('#hireDateEdit').val(hireDate);

            $('#addressEdit').val(employee.address);
            $('#cityEdit').val(employee.city);
            $('#ddlStateEdit').val(employee.stateid);
            $('#ddlCountryEdit').val(employee.countryid);
            $('#socialSecurityNumberEdit').val(employee.socialSecurityNumber);
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

            $.get(href, function(employee, status){
                $('#idDetail').val(employee.id);
                $('#ddlTitleDetail').val(employee.title);
                $('#firstNameDetail').val(employee.firstname);
                $('#lastNameDetail').val(employee.lastname);
                $('#usernameDetail').val(employee.username);
                $('#ddlGenderDetail').val(employee.gender);

                var dateOfBirth = employee.dateOfBirth.substr(0,10);
                $('#dateOfBirthDetail').val(dateOfBirth);

                $('#phoneDetail').val(employee.phone);
                $('#emailDetail').val(employee.email);
                $('#ddlJobTitleDetail').val(employee.jobtitleid);
                $('#ddlEmployeeTypeDetail').val(employee.employeetypeid);

                var hireDate = employee.hireDate.substr(0,10);
                $('#hireDateDetail').val(hireDate);

                $('#addressDetail').val(employee.address);
                $('#cityDetail').val(employee.city);
                $('#ddlStateDetail').val(employee.stateid);
                $('#ddlCountryDetail').val(employee.countryid);
                $('#socialSecurityNumberDetail').val(employee.socialSecurityNumber);
                $('#createdByDetails').val(employee.createdBy);
                $('#createdDateDetails').val(employee.createdDate.substr(0,19).replace("T", " "));
                $('#lastModifiedByDetails').val(employee.lastModifiedBy);
                $('#lastModifiedDateDetails').val(employee.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

    $('.table #photoButton').on('click',function(event) {
       event.preventDefault();
       var href = $(this).attr('href');
       $('#photoModal #employeePhoto').attr('src', href);
       $('#photoModal').modal();
    });

}
);