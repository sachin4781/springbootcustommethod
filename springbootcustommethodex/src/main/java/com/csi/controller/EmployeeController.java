package com.csi.controller;

import com.csi.exception.RecondNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;


    @PostMapping("/signup")

    public ResponseEntity<Employee> signup(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeServiceImpl.signup(employee));
    }

    @GetMapping("/signin/{empemailid}/{emppassword}")

    public ResponseEntity<Boolean> signin(@PathVariable String empemailid, @PathVariable String emppassword) {
        return ResponseEntity.ok(employeeServiceImpl.signin(empemailid, emppassword));
    }


    @GetMapping("/getdatabyname/{empname}")
    public ResponseEntity<List<Employee>> getdatabyname(@PathVariable String empname) {
        return ResponseEntity.ok(employeeServiceImpl.getdatabyname(empname));
    }


    @GetMapping("/getdatabyid/{empid}")
    public ResponseEntity<Optional<Employee>> getdatabyid(@PathVariable int empid) {
        return ResponseEntity.ok(employeeServiceImpl.getdatabyid(empid));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getalldata() {
        return ResponseEntity.ok(employeeServiceImpl.getalldata());
    }

    @PutMapping("/updatedata/{empid}")
    public ResponseEntity<Employee> updatedata(@RequestBody Employee employee, @PathVariable int empid) {

        Employee employee1 = employeeServiceImpl.getdatabyid(empid).orElseThrow(() -> new RecondNotFoundException("Employee Id Does Not Exist.."));

        employee1.setEmpname(employee.getEmpname());
        employee1.setEmpaddress(employee.getEmpaddress());
        employee1.setEmpsalary(employee.getEmpsalary());
        employee1.setEmpdob(employee.getEmpdob());
        employee1.setEmppassword(employee.getEmppassword());
        employee1.setEmpemailid(employee.getEmpemailid());
        employee1.setEmpcontactnumber(employee.getEmpcontactnumber());
        employee1.setEmppancardnumber(employee.getEmppancardnumber());

        return ResponseEntity.ok(employeeServiceImpl.updatedata(employee1));
    }

    @DeleteMapping("/deletedatabyid/{empid}")
    public ResponseEntity<String> deletedatabyid(@PathVariable int empid) {
        employeeServiceImpl.deletedatabyid(empid);
        return ResponseEntity.ok("Data Deleted SuccssFully..");
    }


}
