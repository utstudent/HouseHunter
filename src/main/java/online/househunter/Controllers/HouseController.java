package online.househunter.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HouseController {
    @GetMapping("/houses")
    public String goHouses(){
        return  "house";
    }
}
