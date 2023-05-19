package online.househunter.Controllers;

import online.househunter.Models.*;
import online.househunter.Services.SupplierService;
import online.househunter.Services.CountryService;
import online.househunter.Services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CountryService countryService;

    @Autowired private StateService stateService;

    @GetMapping("/suppliers")
    public String goSuppliers(Model model, String keyword){
        List<Supplier> supplierList;

        if (keyword==null) {
            supplierList = supplierService.getSuppliers();
        } else {
            supplierList = supplierService.findByKeyword(keyword);
        }

        List<State> stateList = stateService.getStates();
        List<Country> countryList = countryService.getCountries();

        model.addAttribute("suppliers",supplierList);
        model.addAttribute("states",stateList);
        model.addAttribute("countries",countryList);
        return  "supplier";
    }
    @PostMapping("/suppliers/addNew")
    public String addNew(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }
    @RequestMapping("suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(Long id) {
        return supplierService.findById(id);
    }

    @RequestMapping(value = "/suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/suppliers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
