package online.househunter.Repositories;

import online.househunter.Models.CustomerLeadStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerLeadStatusRepository extends JpaRepository<CustomerLeadStatus, Long> {
}
