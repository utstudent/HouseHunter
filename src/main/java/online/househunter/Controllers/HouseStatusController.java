package online.househunter.Controllers;

import online.househunter.Models.HouseStatus;
import online.househunter.Services.HouseStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HouseStatusController {

    @Autowired
    private HouseStatusService houseStatusService;

    @GetMapping("/houseStatuses")
    public String goHouseStatuses(Model model){
        List<HouseStatus> houseStatusList = houseStatusService.getHouseStatuses();

        model.addAttribute("houseStatuses",houseStatusList);
        return "houseStatus";
    }
    @PostMapping("/houseStatuses/addNew")
    public String addNew(HouseStatus houseStatus) {
        houseStatusService.save(houseStatus);
        return "redirect:/houseStatuses";
    }
    @RequestMapping("houseStatuses/findById")
    @ResponseBody
    public Optional<HouseStatus> findById(Long id) {
        return houseStatusService.findById(id);
    }

    @RequestMapping(value = "/houseStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(HouseStatus houseStatus) {
        houseStatusService.save(houseStatus);
        return "redirect:/houseStatuses";
    }

    @RequestMapping(value = "/houseStatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        houseStatusService.delete(id);
        return "redirect:/houseStatuses";
    }
}
