package com.mastertheboss.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee_old {

    @Id
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    private int id;

    private String name;

    @ManyToOne
    private DepartmentOld department;

    public Employee_old() {
    }

    public Employee_old(String name, DepartmentOld department) {
        this.name = name;
        this.department = department;
    }

    public Employee_old(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentOld getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentOld department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department=" + department.getName() + "]";
    }

}
