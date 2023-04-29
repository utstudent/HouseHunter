package online.househunter.Controllers;

import online.househunter.Models.HouseType;
import online.househunter.Services.HouseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HouseTypeController {

    @Autowired
    private HouseTypeService houseTypeService;

    @GetMapping("/houseTypes")
    public String goHouseTypes(Model model){
        List<HouseType> houseTypeList = houseTypeService.getHouseTypes();

        model.addAttribute("houseTypes",houseTypeList);
        return "houseType";
    }
    @PostMapping("/houseTypes/addNew")
    public String addNew(HouseType houseType) {
        houseTypeService.save(houseType);
        return "redirect:/houseTypes";
    }
    @RequestMapping("houseTypes/findById")
    @ResponseBody
    public Optional<HouseType> findById(Long id) {
        return houseTypeService.findById(id);
    }

    @RequestMapping(value = "/houseTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(HouseType houseType) {
        houseTypeService.save(houseType);
        return "redirect:/houseTypes";
    }

    @RequestMapping(value = "/houseTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        houseTypeService.delete(id);
        return "redirect:/houseTypes";
    }
}
