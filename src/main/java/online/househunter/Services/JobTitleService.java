package online.househunter.Services;

import online.househunter.Models.JobTitle;
import online.househunter.Repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;
    // Return all jobTitles
    public List<JobTitle> getJobTitles(){
        return jobTitleRepository.findAll();
    }

    // save new jobTitle
    public void save(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }

    public JobTitle edit(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
        return jobTitle;
    }
    // get by id
    public Optional<JobTitle> findById(Long id) {
        return jobTitleRepository.findById(id);
    }

    public void delete(Long id) {
        jobTitleRepository.deleteById(id);
    }
}
