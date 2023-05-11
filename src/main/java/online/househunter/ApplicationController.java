package online.househunter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String goHome(){
        return  "index";
    }

    @GetMapping("/blank")
    public String goToBlank(){
        return  "pages-blank";
    }

    @GetMapping("/table")
    public String goToTable(){
        return  "tables-data";
    }

    @GetMapping("/table2")
    public String goToTable2(){
        return  "tables-general";
    }

    @GetMapping("/form")
    public String goToFormsLayout(){
        return  "forms-layouts";
    }
    @GetMapping("/form2")
    public String goToFormsEditors(){
        return  "forms-editors";
    }

    @GetMapping("/form3")
    public String goToFormsElements(){
        return  "forms-elements";
    }

    @GetMapping("/form4")
    public String goToFormsValidation(){
        return  "forms-validation";
    }

    @GetMapping("/modal")
    public String goToModal(){
        return  "components-modal";
    }

    @GetMapping("/buttons")
    public String goToButtons(){
        return  "components-buttons";
    }
    @GetMapping("/userprofile")
    public String goToUserProfiles(){
        return  "users-profile";
    }

    @GetMapping("/login")
    public String login(){
        return  "login";
    }

    @GetMapping("/logout")
    public String logout(){

        return  "login";
    }
    @GetMapping("/register")
    public String register(){

        return  "register";
    }
}
