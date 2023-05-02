package online.househunter.Controllers;

import online.househunter.Models.CustomerLeadStatus;
import online.househunter.Services.CustomerLeadStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerLeadStatusController {

    @Autowired
    private CustomerLeadStatusService customerLeadStatusService;

    @GetMapping("/customerLeadStatuses")
    public String goCustomerLeadStatuses(Model model){
        List<CustomerLeadStatus> customerLeadStatusList = customerLeadStatusService.getCustomerLeadStatuses();

        model.addAttribute("customerLeadStatuses", customerLeadStatusList);
        return "customerLeadStatus";
    }
    @PostMapping("/customerLeadStatuses/addNew")
    public String addNew(CustomerLeadStatus customerLeadStatus) {
        customerLeadStatusService.save(customerLeadStatus);
        return "redirect:/customerLeadStatuses";
    }
    @RequestMapping("customerLeadStatuses/findById")
    @ResponseBody
    public Optional<CustomerLeadStatus> findById(Long id) {
        return customerLeadStatusService.findById(id);
    }

    @RequestMapping(value = "/customerLeadStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(CustomerLeadStatus customerLeadStatus) {
        customerLeadStatusService.save(customerLeadStatus);
        return "redirect:/customerLeadStatuses";
    }

    @RequestMapping(value = "/customerLeadStatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        customerLeadStatusService.delete(id);
        return "redirect:/customerLeadStatuses";
    }
}
