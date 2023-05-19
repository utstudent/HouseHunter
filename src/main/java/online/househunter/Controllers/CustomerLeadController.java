package online.househunter.Controllers;

import online.househunter.Models.CustomerLead;
import online.househunter.Models.CustomerLeadStatus;
import online.househunter.Services.CustomerLeadService;
import online.househunter.Services.CustomerLeadStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerLeadController {
    @Autowired
    private CustomerLeadService customerLeadService;
    @Autowired private CustomerLeadStatusService customerLeadStatusService;

    @GetMapping("/customerLeads")
    public String goCustomerLeads(Model model, String keyword){
        List<CustomerLead> customerLeadList;

        if(keyword==null) {
            customerLeadList = customerLeadService.getCustomerLeads();
        } else {
            customerLeadList = customerLeadService.findByKeyword(keyword);
        }

        List<CustomerLeadStatus> customerLeadStatusList = customerLeadStatusService.getCustomerLeadStatuses();

        model.addAttribute("customerLeads",customerLeadList);
        model.addAttribute("customerLeadStatuses",customerLeadStatusList);
        return "customerLead";
    }
    @PostMapping("/customerLeads/addNew")
    public String addNew(CustomerLead customerLead) {
        customerLeadService.save(customerLead);
        return "redirect:/customerLeads";
    }
    @RequestMapping("customerLeads/findById")
    @ResponseBody
    public Optional<CustomerLead> findById(Long id) {
        return customerLeadService.findById(id);
    }

    @RequestMapping(value = "/customerLeads/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(CustomerLead customerLead) {
        customerLeadService.save(customerLead);
        return "redirect:/customerLeads";
    }

    @RequestMapping(value = "/customerLeads/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        customerLeadService.delete(id);
        return "redirect:/customerLeads";
    }
}
