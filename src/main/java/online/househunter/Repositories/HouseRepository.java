package online.househunter.Repositories;

import online.househunter.Models.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    @Query(value = "select h from House h where " +
            "concat(h.yearBuilt, h.houseType.description, h.houseStatus.description, h.inCharge.firstname, h.location.address, h.yearBuilt) LIKE %?1%")
    List<House> findByKeyword(String keyword);

    //h.houseType.description, h.houseStatus.description, h.inCharge.firstname, h.yearBuilt, h.location.description
}
