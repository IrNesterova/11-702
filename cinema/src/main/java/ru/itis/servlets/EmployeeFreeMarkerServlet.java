package ru.itis.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.forms.EmployeeForm;
import ru.itis.forms.movieForm;
import ru.itis.forms.screeningForm;
import ru.itis.models.Employee;
import ru.itis.models.Movie;
import ru.itis.models.Screening;
import ru.itis.repositories.*;
import ru.itis.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "employeeList", urlPatterns = {"/employeeList"})
public class EmployeeFreeMarkerServlet extends HttpServlet {
    private static final String ADD_USER_VIEW = "ftl/addEmployee.ftl";
    private static final String UPDATE_USER_VIEW = "ftl/updateEmployee.ftl";
    private static final String LIST_USERS_VIEW = "ftl/screeningList.ftl";

    private EmployeeControlService employeeControlService;
    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/cinematest");
        EmployeeRepository employeeRepository = new EmployeeRepositoryJbdcImpl(dataSource);
        this.employeeControlService = new EmployeeControlServiceImpl(employeeRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employeeList = employeeControlService.getAllEmployeers();
        req.setAttribute("employeeList", employeeList);

        String action = req.getParameter("action");
        String DELETE_ACTION = "deleteEmployee";
        String ADD_ACTION = "addEmployee";
        String EDIT_ACTION = "editEmployee";
        String path = "";
        if (DELETE_ACTION.equals(action)){
            Long id = Long.parseLong(req.getParameter("id_employee"));
            employeeControlService.fireEmployee(id);
        } else if (EDIT_ACTION.equals(action)){
            Long id = Long.parseLong(req.getParameter("id_employee"));
            Employee employee = employeeControlService.getEmployeeById(id);
            req.setAttribute("employee", employee);
            path = UPDATE_USER_VIEW;
        } else if (ADD_ACTION.equals(action)){
            path = ADD_USER_VIEW;
        } else {
            path = "/ftl/employeeList.ftl";
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String ADD_ACTION = "addEmployee";
        String EDIT_ACTION = "editEmployee";
        if (ADD_ACTION.equals(action)) {
            Long id_movie = Long.parseLong(req.getParameter("id"));
            String first_name = req.getParameter("first_name");
            String last_name = req.getParameter("last_name");
            String sex = req.getParameter("sex");
            EmployeeForm employeeForm = EmployeeForm.builder()
                    .first_name(first_name)
                    .last_name(last_name)
                    .sex(sex)
                    .build();
            employeeControlService.addEmployee(employeeForm);
            resp.sendRedirect("employee");
        } else if (EDIT_ACTION.equals(action)) {

            Long movieId = Long.parseLong(req.getParameter("id_employee"));
            Employee employee = employeeControlService.getEmployeeById(movieId);

            employee.setFirst_name(req.getParameter("first_name"));
            employee.setLast_name(req.getParameter("last_name"));
            employee.setSex(req.getParameter("sex"));
            employeeControlService.changeEmployee(employee);
            resp.sendRedirect("employee");
        }
    }
}
