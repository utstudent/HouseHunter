package online.househunter.Controllers;

import online.househunter.Models.*;
import online.househunter.Services.ContactService;
import online.househunter.Services.CountryService;
import online.househunter.Services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private CountryService countryService;

    @Autowired private StateService stateService;

    @GetMapping("/contacts")
    public String goContacts(Model model, String keyword){
        List<Contact> contactList;

        if(keyword==null) {
            contactList = contactService.getContacts();
        } else {
            contactList = contactService.findByKeyword(keyword);
        }

        List<State> stateList = stateService.getStates();
        List<Country> countryList = countryService.getCountries();

        model.addAttribute("contacts",contactList);
        model.addAttribute("states",stateList);
        model.addAttribute("countries",countryList);
        return  "contact";
    }
    @PostMapping("/contacts/addNew")
    public String addNew(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }
    @RequestMapping("contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(Long id) {
        return contactService.findById(id);
    }

    @RequestMapping(value = "/contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
