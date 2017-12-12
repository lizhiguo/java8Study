package com.qipai.jpa.domain;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qipai.jpa.config.AppConfig;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
@Transactional
@Rollback(false)
@Slf4j
public class EmbeddedTest {
	@Autowired
	private EntityManager em;
	@Test
	public void 保存Map映射到数据库() {
		log.debug("保存開始");
		Employee5 emp = new Employee5();
	    emp.setName("name");
	    emp.setSalary(12345);
	    

	    Address p = new Address();
	    p.setCity("New York");

	    emp.setAddress(p);
	    em.persist(emp);
	}
	
	@Test
	public void 保存嵌入式共享() {
		Employee6 emp = new Employee6();
	    emp.setName("name");
	    emp.setSalary(12345);
	    

	    Address p = new Address();
	    p.setCity("New York");

	    emp.setAddress(p);
	    
	    Company c = new Company();
	    c.setAddress(p);
	    c.setId(1);
	    
	    em.persist(emp);
	    em.persist(c);
	}
	
	@Test
	public void 嵌入式ID示例() {
		Professor emp = new Professor("US", 1);
	    emp.setName("Tom");
	    emp.setSalary(1);
	    em.persist(emp);
	}
	@Test
	public void 嵌入式键映射() {
		Employee7 e = new Employee7();
	    e.setFirstName("Tom");

	    Department7 d = new Department7();
	  
	    d.setName("test");
	    
	    e.setDepartment(d);
	    
	    EmployeeName name = new EmployeeName();
	    name.setFirst_Name("Tom");
//	    d.getEmployees().put(name, e);
	    
	    
	    em.persist(e);    
	    em.persist(d);
	}
	
}
