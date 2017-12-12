package com.qipai.jpa.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Department7 {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @OneToMany(mappedBy="department")
    private Map<EmployeeName, Employee7> employeesByName=new HashMap<>();
    
    public void addEmployee(Employee7 employee) {
    	EmployeeName empName = new EmployeeName();
        empName.setFirst_Name(employee.getFirstName());
        empName.setLast_Name(employee.getLastName());
        employeesByName.put(empName, employee);
        if (employee.getDepartment() != null) {
            employee.getDepartment().removeEmployee(employee);
        }
        employee.setDepartment(this);
    }

    public void removeEmployee(Employee7 employee) {
        Iterator iter = employeesByName.entrySet().iterator();
        while (iter.hasNext()) {
            Employee7 current = ((Map.Entry<EmployeeName,Employee7>) iter.next()).getValue();
            if (current.getId() == employee.getId()) {
                iter.remove();
                current.setDepartment(null);
            }
        }
    }
}
