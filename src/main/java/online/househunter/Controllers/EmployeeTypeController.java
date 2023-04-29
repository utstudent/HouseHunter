package online.househunter.Controllers;

import online.househunter.Models.EmployeeType;
import online.househunter.Services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {
    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/employeeTypes")
    public String goEmployeeTypes(Model model){
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();

        model.addAttribute("employeeTypes",employeeTypeList);
        return "employeeType";
    }
    @PostMapping("/employeeTypes/addNew")
    public String addNew(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }
    @RequestMapping("employeeTypes/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(Long id) {
        return employeeTypeService.findById(id);
    }

    @RequestMapping(value = "/employeeTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value = "/employeeTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        employeeTypeService.delete(id);
        return "redirect:/employeeTypes";
    }
}
