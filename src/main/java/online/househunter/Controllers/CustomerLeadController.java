package online.househunter.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerLeadController {
    @GetMapping("/customerLeads")
    public String goLeads(){
        return  "customerLead";
    }
}
