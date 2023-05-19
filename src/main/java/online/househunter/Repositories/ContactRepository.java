package online.househunter.Repositories;

import online.househunter.Models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "select c from Contact c where " +
            "concat(c.firstName, c.lastName, c.address, c.city, c.phone, c.email) LIKE %?1%")
    List<Contact> findByKeyword(String keyword);
}
