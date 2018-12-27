package ru.itis.services;

import ru.itis.forms.EmployeeForm;
import ru.itis.models.Employee;
import ru.itis.repositories.EmployeeRepository;

import java.util.List;

public class EmployeeControlServiceImpl implements EmployeeControlService{
    public EmployeeRepository employeeRepository;

    public EmployeeControlServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public void fireEmployee(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public void addEmployee(EmployeeForm employeeForm) {
        Employee employee = Employee.builder()
                .username(employeeForm.getUsername())
                .first_name(employeeForm.getFirst_name())
                .last_name(employeeForm.getLast_name())
                .hashPassword(employeeForm.getPassword())
                .sex(employeeForm.getSex())
                .photo(employeeForm.getPhoto())
                .build();
        employeeRepository.save(employee);
    }

    @Override
    public void changeEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public List<Employee> getAllEmployeers() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findOne(id);
    }

}
