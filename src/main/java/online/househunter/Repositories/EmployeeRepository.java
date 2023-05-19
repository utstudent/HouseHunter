package online.househunter.Repositories;

import online.househunter.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByUsername(String un);

    @Query(value = "select e from Employee e where " +
            "concat(e.username, e.firstname, e.lastname, e.email, e.phone) LIKE %?1%")
    List<Employee> findByKeyword(String keyword);
}
