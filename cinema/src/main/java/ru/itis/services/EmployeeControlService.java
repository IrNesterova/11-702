package ru.itis.services;

import ru.itis.forms.EmployeeForm;

import ru.itis.models.Employee;

import java.util.List;

public interface EmployeeControlService {
    void fireEmployee(Long id);
    void addEmployee(EmployeeForm employeeForm);
    void changeEmployee(Employee employee);
    public List<Employee> getAllEmployeers();
    public Employee getEmployeeById(Long id);
}
