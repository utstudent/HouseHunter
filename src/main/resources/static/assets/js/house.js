
$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(house, status){
            $('#idEdit').val(house.id);
            $('#priceEdit').val(house.price);
            $('#ddlHouseStatusEdit').val(house.housestatusid);
            $('#ddlHouseTypeEdit').val(house.housetypeid);
            $('#bedroomsEdit').val(house.bedrooms);
            $('#bathroomsEdit').val(house.bathrooms);
            $('#storiesEdit').val(house.stories);
            $('#yearBuiltEdit').val(house.yearBuilt);
            $('#sqftEdit').val(house.sqft);
            $('#ddlLocationEdit').val(house.locationid);

            var marketEntryDate = house.marketEntryDate.substr(0,10);
            $('#marketEntryDateEdit').val(marketEntryDate);

            $('#ddlEmployeeEdit').val(house.employeeid);
            $('#descriptionEdit').val(house.description);
            $('#ddlHasPoolEdit').val(house.hasPool);
            $('#ddlHasFireplaceEdit').val(house.hasFireplace);
            $('#ddlHasGarageEdit').val(house.hasGarage);
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

            $.get(href, function(house, status){
                $('#idDetail').val(house.id);
                $('#priceDetail').val(house.price);
                $('#ddlHouseStatusDetail').val(house.housestatusid);
                $('#ddlHouseTypeDetail').val(house.housetypeid);
                $('#bedroomsDetail').val(house.bedrooms);
                $('#bathroomsDetail').val(house.bathrooms);
                $('#storiesDetail').val(house.stories);
                $('#yearBuiltDetail').val(house.yearBuilt);
                $('#sqftDetail').val(house.sqft);
                $('#ddlLocationDetail').val(house.locationid);

                var marketEntryDate = house.marketEntryDate.substr(0,10);
                $('#marketEntryDateDetail').val(marketEntryDate);

                $('#ddlEmployeeDetail').val(house.employeeid);
                $('#descriptionDetail').val(house.description);
                $('#ddlHasPoolDetail').val(house.hasPool);
                $('#ddlHasFireplaceDetail').val(house.hasFireplace);
                $('#ddlHasGarageDetail').val(house.hasGarage);
                $('#createdByDetails').val(house.createdBy);
                $('#createdDateDetails').val(house.createdDate.substr(0,19).replace("T", " "));
                $('#lastModifiedByDetails').val(house.lastModifiedBy);
                $('#lastModifiedDateDetails').val(house.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        })

    $('.table #photoButton').on('click',function(event) {
       event.preventDefault();
       var href = $(this).attr('href');
       $('#photoModal #housePhoto').attr('src', href);
       $('#photoModal').modal();
    });

}
);