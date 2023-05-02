package online.househunter.Services;

import online.househunter.Models.CustomerLeadStatus;
import online.househunter.Repositories.CustomerLeadStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerLeadStatusService {

    @Autowired
    private CustomerLeadStatusRepository customerLeadStatusRepository;

    // Return all CustomerLeadStatus
    public List<CustomerLeadStatus> getCustomerLeadStatuses(){

        return customerLeadStatusRepository.findAll();
    }

    // save new CustomerLeadStatus
    public void save(CustomerLeadStatus customerLeadStatus) {

        customerLeadStatusRepository.save(customerLeadStatus);
    }

    public CustomerLeadStatus edit(CustomerLeadStatus customerLeadStatus) {
        customerLeadStatusRepository.save(customerLeadStatus);
        return customerLeadStatus;
    }
    // get by id
    public Optional<CustomerLeadStatus> findById(Long id) {

        return customerLeadStatusRepository.findById(id);
    }

    public void delete(Long id) {
        customerLeadStatusRepository.deleteById(id);
    }
}
