package online.househunter.Controllers;

import online.househunter.Models.Country;
import online.househunter.Models.Location;
import online.househunter.Models.State;
import online.househunter.Services.CountryService;
import online.househunter.Services.LocationService;
import online.househunter.Services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {
    @Autowired private LocationService locationService;
    @Autowired private CountryService countryService;
    @Autowired private StateService stateService;

    @GetMapping("/locations")
    public String goLocations(Model model){
        List<Location> locationList = locationService.getLocations();
        List<State> stateList = stateService.getStates();
        List<Country> countryList = countryService.getCountries();

        model.addAttribute("locations",locationList);
        model.addAttribute("states",stateList);
        model.addAttribute("countries",countryList);
        return "location";
    }
    @PostMapping("/locations/addNew")
    public String addNew(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }
    @RequestMapping("locations/findById")
    @ResponseBody
    public Optional<Location> findById(Long id) {
        return locationService.findById(id);
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        locationService.delete(id);
        return "redirect:/locations";
    }
}
