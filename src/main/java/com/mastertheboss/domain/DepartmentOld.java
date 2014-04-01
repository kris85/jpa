package com.mastertheboss.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class DepartmentOld {

	@Id
	@SequenceGenerator(name = "department_seq", sequenceName = "department_seq", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy="department",cascade=CascadeType.PERSIST)
	private List<Employee_old> employees = new ArrayList<Employee_old>();
	
	
	
	public DepartmentOld() {
		super();
	}
	public DepartmentOld(String name) {
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
	public List<Employee_old> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee_old> employees) {
		this.employees = employees;
	}
}
