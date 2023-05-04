package online.househunter.Controllers;

import online.househunter.Models.*;
import online.househunter.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HouseController {

    @Autowired private HouseService houseService;
    @Autowired private HouseTypeService houseTypeService;
    @Autowired private HouseStatusService houseStatusService;
    @Autowired private EmployeeService employeeService;
    @Autowired private LocationService locationService;


    @GetMapping("/houses")
    public String goHouses(Model model){
        List<House> houseList = houseService.getHouses();
        List<HouseType> houseTypeList = houseTypeService.getHouseTypes();
        List<HouseStatus> houseStatusList = houseStatusService.getHouseStatuses();
        List<Employee> employeeList = employeeService.getEmployees();
        List<Location> locationList = locationService.getLocations();

        model.addAttribute("houses",houseList);
        model.addAttribute("houseTypes",houseTypeList);
        model.addAttribute("houseStatuses",houseStatusList);
        model.addAttribute("employees",employeeList);
        model.addAttribute("locations",locationList);
        return  "house";
    }
    @PostMapping("/houses/addNew")
    public String addNew(House house) {
        houseService.save(house);
        return "redirect:/houses";
    }
    @RequestMapping("houses/findById")
    @ResponseBody
    public Optional<House> findById(Long id) {
        return houseService.findById(id);
    }

    @RequestMapping(value = "/houses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(House house) {
        houseService.save(house);
        return "redirect:/houses";
    }

    @RequestMapping(value = "/houses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        houseService.delete(id);
        return "redirect:/houses";
    }
}
