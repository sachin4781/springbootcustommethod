package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;


    public Employee signup(Employee employee) {
        return employeeDaoImpl.signup(employee);
    }

    public List<Employee> getdatabyname(String empname) {
        return employeeDaoImpl.getdatabyname(empname);
    }

    public Optional<Employee> getdatabyid(int empid) {
        return employeeDaoImpl.getdatabyid(empid);
    }

    public List<Employee> getalldata() {
        return employeeDaoImpl.getalldata();
    }

    public boolean signin(String empemailid, String emppassword) {

        return employeeDaoImpl.signin(empemailid, emppassword);
    }

    public Employee updatedata(Employee employee) {
        return employeeDaoImpl.updatedata(employee);
    }

    public void deletedatabyid(int empid) {
        employeeDaoImpl.deletedatabyid(empid);
    }


}
