package online.househunter.Repositories;

import online.househunter.Models.HouseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseStatusRepository extends JpaRepository<HouseStatus, Long> {
}
