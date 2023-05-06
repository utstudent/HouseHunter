
$(document).ready(function(){

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href =$(this).attr('href');

        $.get(href, function(invoice, status){
            $('#idEdit').val(invoice.id);

            var invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#invoiceDateEdit').val(invoiceDate);

            $('#paymentTermsEdit').val(invoice.paymentTerms);
            $('#amountPayableEdit').val(invoice.amountPayable);
            $('#ddlInvoiceStatusEdit').val(invoice.invoicestatusid);
            $('#ddlClientEdit').val(invoice.clientid);
            $('#remarksEdit').val(invoice.remarks);
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

            var invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#invoiceDateDetail').val(invoiceDate);

            $('#paymentTermsDetail').val(invoice.paymentTerms);
            $('#amountPayableDetail').val(invoice.amountPayable);
            $('#ddlinvoiceStatusDetail').val(invoice.invoicestatusid);
            $('#ddlClientDetail').val(invoice.clientid);
            $('#remarksDetail').val(invoice.remarks);
            $('#createdByDetails').val(invoice.createdBy);
            $('#createdDateDetails').val(invoice.createdDate.substr(0,19).replace("T", " "));
            $('#lastModifiedByDetails').val(invoice.lastModifiedBy);
            $('#lastModifiedDateDetails').val(invoice.lastModifiedDate.substr(0,19).replace("T", " "));
        });

        $('#detailsModal').modal();
    })

}
);