package online.househunter.Controllers;

import online.househunter.Models.Client;
import online.househunter.Models.Invoice;
import online.househunter.Models.InvoiceStatus;
import online.househunter.Services.ClientService;
import online.househunter.Services.InvoiceService;
import online.househunter.Services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired private InvoiceStatusService invoiceStatusService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/invoices")
    public String goInvoices(Model model){
        List<Invoice> invoiceList = invoiceService.getInvoices();
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
        List<Client> clientList = clientService.getClients();

        model.addAttribute("invoiceStatuses",invoiceStatusList);
        model.addAttribute("invoices",invoiceList);
        model.addAttribute("clients",clientList);
        return  "invoice";
    }
    @PostMapping("/invoices/addNew")
    public String addNew(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }
    @RequestMapping("invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(Long id) {
        return invoiceService.findById(id);
    }

    @RequestMapping(value = "/invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
}
