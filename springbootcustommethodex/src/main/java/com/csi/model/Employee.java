package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue

    private int empid;

    private String empname;

    private String empaddress;

    private double empsalary;

    @Column(unique = true)
    private long empcontactnumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empdob;

    @Column(unique = true)
    private String empuid;

    @Column(unique = true)
    private String emppancardnumber;

    @Column(unique = true)
    private String empemailid;

    private String emppassword;


}
