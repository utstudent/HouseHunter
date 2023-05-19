package online.househunter.Services;

import online.househunter.Models.Employee;
import online.househunter.Models.User;
import online.househunter.Repositories.EmployeeRepository;
import online.househunter.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private UserRepository userRepository;
    // Return all employees
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    // save new employee
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee edit(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }
    // get by id
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    //Set the Username of the employee where firstname and lastname match
    public void assignUsername(Long id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        try {
            User user = userRepository.findByFirstnameAndLastname(
                    employee.getFirstname(),
                    employee.getLastname());
            System.out.println(user);
            employee.setUsername(user.getUsername());
            employeeRepository.save(employee);
        }
        catch (Exception ex){

        }
    }

    public Employee findByUsername(String un) {

        return employeeRepository.findByUsername(un);
    }

    public List<Employee> findByKeyword(String keyword){
        return employeeRepository.findByKeyword(keyword);
    }
}
