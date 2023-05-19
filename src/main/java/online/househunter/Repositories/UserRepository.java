package online.househunter.Repositories;

import online.househunter.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByFirstnameAndLastname(String firstname, String lastname);

    @Query(value = "select u from User u where " +
            "concat(u.firstname, u.lastname, u.email, u.username) LIKE %?1%")
    List<User> findByKeyword(String keyword);
}
