package online.househunter.Controllers;

import online.househunter.Models.JobTitle;
import online.househunter.Services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {
    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/jobTitles")
    public String goJobTitles(Model model){
        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();

        model.addAttribute("jobTitles",jobTitleList);
        return "jobTitle";
    }
    @PostMapping("/jobTitles/addNew")
    public String addNew(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitles";
    }
    @RequestMapping("jobTitles/findById")
    @ResponseBody
    public Optional<JobTitle> findById(Long id) {
        return jobTitleService.findById(id);
    }

    @RequestMapping(value = "/jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "/jobTitles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        jobTitleService.delete(id);
        return "redirect:/jobTitles";
    }
}
