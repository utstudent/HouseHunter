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
public class EmployeeController {

    @Autowired private EmployeeService employeeService;
    @Autowired private CountryService countryService;
    @Autowired private StateService stateService;
    @Autowired private EmployeeTypeService employeeTypeService;
    @Autowired private JobTitleService jobTitleService;

    @GetMapping("/employees")
    public String goEmployees(Model model, String keyword){
        List<Employee> employeeList;

        if(keyword==null) {
            employeeList = employeeService.getEmployees();
        } else {
            employeeList = employeeService.findByKeyword(keyword);
        }

        List<State> stateList = stateService.getStates();
        List<Country> countryList = countryService.getCountries();
        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();

        model.addAttribute("employees",employeeList);
        model.addAttribute("states",stateList);
        model.addAttribute("countries",countryList);
        model.addAttribute("jobTitles",jobTitleList);
        model.addAttribute("employeeTypes",employeeTypeList);
        return  "employee";
    }
    @PostMapping("/employees/addNew")
    public String addNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }
    @RequestMapping("employees/findById")
    @ResponseBody
    public Optional<Employee> findById(Long id) {
        return employeeService.findById(id);
    }

    @RequestMapping(value = "/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    //Assign Employee Username
    @RequestMapping(value = "/employees/assignUsername")
    public  String assignUsername(Long id){
        employeeService.assignUsername(id);
        return "redirect:/employees";
    }
}
