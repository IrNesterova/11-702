package cinema.respositories;

import cinema.Models.Employee;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Optional<Employee> findByUsername(String username);
}
