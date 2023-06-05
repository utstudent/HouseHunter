package online.househunter;

import online.househunter.Models.*;
import online.househunter.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class ApplicationController {

    @Autowired private CustomerLeadService customerLeadService;
    @Autowired private HouseService houseService;
    @Autowired private HouseTypeService houseTypeService;
    @Autowired private HouseStatusService houseStatusService;
    @Autowired private EmployeeService employeeService;
    @Autowired private LocationService locationService;

    @Autowired private InvoiceService invoiceService;
    @Autowired private CustomerLeadStatusService customerLeadStatusService;

    @Autowired private SupplierService supplierService;

    @GetMapping("/index")
    public String goHome(Model model){

        List<House> houseList= houseService.getHouses();
        List<HouseType> houseTypeList = houseTypeService.getHouseTypes();
        List<HouseStatus> houseStatusList = houseStatusService.getHouseStatuses();
        List<Employee> employeeList = employeeService.getEmployees();
        List<Location> locationList = locationService.getLocations();
        List<CustomerLeadStatus> customerLeadStatusList = customerLeadStatusService.getCustomerLeadStatuses();
        List<CustomerLead> customerLeadList = customerLeadService.getCustomerLeads();
        List<Invoice> invoiceList = invoiceService.getInvoices();
        List<Supplier> supplierList = supplierService.getSuppliers();

        model.addAttribute("customerLeads",customerLeadList);
        model.addAttribute("customerLeadStatuses",customerLeadStatusList);
        model.addAttribute("houses",houseList);
        model.addAttribute("houseTypes",houseTypeList);
        model.addAttribute("houseStatuses",houseStatusList);
        model.addAttribute("employees",employeeList);
        model.addAttribute("locations",locationList);
        model.addAttribute("invoices",invoiceList);
        model.addAttribute("suppliers", supplierList);

        int rawLeadCount = customerLeadService.countByCustomerLeadStatus_Description("Raw");
        model.addAttribute("rawLeadCount", rawLeadCount);
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

    @GetMapping("/index3")
    public String index3(){

        return  "index3";
    }

    @GetMapping("/layout")
    public String layout(){
        return  "_layout";
    }
    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }

}
