package online.househunter.Services;

import online.househunter.Models.CustomerLead;
import online.househunter.Repositories.CustomerLeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerLeadService {

    @Autowired
    private CustomerLeadRepository customerLeadRepository;
    // Return all customerLeads
    public List<CustomerLead> getCustomerLeads(){
        return customerLeadRepository.findAll();
    }

    // save new customerLead
    public void save(CustomerLead customerLead) {
        customerLeadRepository.save(customerLead);
    }

    public CustomerLead edit(CustomerLead customerLead) {
        customerLeadRepository.save(customerLead);
        return customerLead;
    }
    // get by id
    public Optional<CustomerLead> findById(Long id) {
        return customerLeadRepository.findById(id);
    }

    public void delete(Long id) {
        customerLeadRepository.deleteById(id);
    }
}
