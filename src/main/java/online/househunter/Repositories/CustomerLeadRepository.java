package online.househunter.Repositories;

import online.househunter.Models.CustomerLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerLeadRepository extends JpaRepository<CustomerLead, Long> {

    @Query(value = "select c from CustomerLead c where " +
            "concat(c.firstname, c.lastname, c.phone, c.email, c.jobTitle, c.companyName) LIKE %?1%")
    List<CustomerLead> findByKeyword(String keyword);


    int countByCustomerLeadStatus_Description(String customerLeadStatus_Description);
}
