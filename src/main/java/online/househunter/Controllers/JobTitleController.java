package online.househunter.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobTitleController {
    @GetMapping("/jobtitles")
    public String goJobTitles(){
        return  "jobTitle";
    }
}
