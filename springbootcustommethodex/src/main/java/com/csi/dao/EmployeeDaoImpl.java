package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee signup(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getdatabyname(String empname) {
        return employeeRepository.findByEmpname(empname);
    }

    public Optional<Employee> getdatabyid(int empid) {
        return employeeRepository.findById(empid);
    }

    public List<Employee> getalldata() {
        return employeeRepository.findAll();
    }

    public boolean signin(String empemailid, String emppassword) {
        boolean flag = false;

        Employee employee = employeeRepository.findByEmpemailidAndEmppassword(empemailid, emppassword);

        if (employee != null && employee.getEmpemailid().equals(empemailid) && employee.getEmppassword().equals(emppassword)) {
            flag = true;
        }
        return flag;
    }

    public Employee updatedata(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deletedatabyid(int empid) {
        employeeRepository.deleteById(empid);
    }

}
