package online.househunter.Repositories;

import online.househunter.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "select c from Client c where " +
            "concat(c.name, c.address, c.city, c.phone, c.email) LIKE %?1%")
    List<Client> findByKeyword(String keyword);
}
