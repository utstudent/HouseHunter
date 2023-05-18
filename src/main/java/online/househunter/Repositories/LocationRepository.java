package online.househunter.Repositories;

import online.househunter.Models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query(value = "select l from Location l where " +
            "concat(l.address, l.city, l.zipcode, l.description) LIKE %?1%")
    List<Location> findByKeyword(String keyword);
}
