package com.csi.repository;

import com.csi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    public List<Employee> findByEmpname(String empname);

    public Employee findByEmpemailidAndEmppassword(String empemailid, String emppassword);


}
