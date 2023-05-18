package online.househunter.Controllers;

import online.househunter.Models.Country;
import online.househunter.Models.State;
import online.househunter.Services.CountryService;
import online.househunter.Services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/states")
    public String goStates(Model model, String keyword){
        List<State> stateList;

        if (keyword==null) {
            stateList = stateService.getStates();
        } else{
            stateList = stateService.findByKeyword(keyword);
        }

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("states",stateList);
        model.addAttribute("countries",countryList);
        return  "state";
    }
    @PostMapping("/states/addNew")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/states";
    }
    @RequestMapping("states/findById")
    @ResponseBody
    public Optional<State> findById(Long id) {
        return stateService.findById(id);
    }

    @RequestMapping(value = "/states/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "/states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        stateService.delete(id);
        return "redirect:/states";
    }
}
