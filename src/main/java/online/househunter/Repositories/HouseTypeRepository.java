package online.househunter.Repositories;

import online.househunter.Models.HouseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseTypeRepository extends JpaRepository<HouseType, Long> {
}
