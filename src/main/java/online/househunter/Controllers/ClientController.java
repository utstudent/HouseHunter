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
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private CountryService countryService;
    @Autowired private StateService stateService;

    @GetMapping("/clients")
    public String goClients(Model model, String keyword){
        List<Client> clientList;

        if(keyword==null) {
            clientList = clientService.getClients();
        } else {
            clientList = clientService.findByKeyword(keyword);
        }


        List<State> stateList = stateService.getStates();
        List<Country> countryList = countryService.getCountries();

        model.addAttribute("clients",clientList);
        model.addAttribute("states",stateList);
        model.addAttribute("countries",countryList);
        return  "client";
    }
    @PostMapping("/clients/addNew")
    public String addNew(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }
    @RequestMapping("clients/findById")
    @ResponseBody
    public Optional<Client> findById(Long id) {
        return clientService.findById(id);
    }

    @RequestMapping(value = "/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}
