package online.househunter.Repositories;

import online.househunter.Models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query(value = "select c from Country c where " +
            "concat(c.description, c.capital, c.continent, c.code, c.nationality) LIKE %?1%")
    List<Country> findByKeyword(String keyword);
}
