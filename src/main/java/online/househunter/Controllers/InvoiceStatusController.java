package online.househunter.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceStatusController {

    @GetMapping("/invoicestatus")
    public String goInvoiceStatus(){
        return  "invoiceStatus";
    }
}
