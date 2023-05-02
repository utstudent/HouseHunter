package online.househunter.Repositories;

import online.househunter.Models.CustomerLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerLeadRepository extends JpaRepository<CustomerLead, Long> {
}
