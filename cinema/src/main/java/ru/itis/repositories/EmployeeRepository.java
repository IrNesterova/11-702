package ru.itis.repositories;

import ru.itis.models.Employee;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee> {
    Employee findByUsername(String username);
}
