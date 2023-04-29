package online.househunter.Controllers;

import online.househunter.Models.InvoiceStatus;
import online.househunter.Services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoiceStatuses")
    public String goInvoiceStatuses(Model model){
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();

        model.addAttribute("invoiceStatuses",invoiceStatusList);
        return "invoiceStatus";
    }
    @PostMapping("/invoiceStatuses/addNew")
    public String addNew(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }
    @RequestMapping("invoiceStatuses/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(Long id) {
        return invoiceStatusService.findById(id);
    }

    @RequestMapping(value = "/invoiceStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping(value = "/invoiceStatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        invoiceStatusService.delete(id);
        return "redirect:/invoiceStatuses";
    }
}
