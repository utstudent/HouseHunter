package online.househunter.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeTypeController {
    @GetMapping("/employeetypes")
    public String goEmployeeTypes(){
        return  "employeeType";
    }
}
