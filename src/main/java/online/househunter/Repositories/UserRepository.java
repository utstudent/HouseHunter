package online.househunter.Repositories;

import online.househunter.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByFirstnameAndLastname(String firstname, String lastname);
}
