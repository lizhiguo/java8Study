package com.qipai.jpa.domain;

import java.util.Date;

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
public class EmployeeTest {
	@Autowired
	private EntityManager em;
	
	@Test
	public void 保存() {
		log.debug("員工保存");
		Employee emp = new Employee();
	    emp.setName("Tom");

	    em.persist(emp);
	    
	    emp = em.find(Employee.class, emp.getId());
	    
	    Employee managedEmp = em.merge(emp);
	    managedEmp.setLastAccessTime(new Date());
	}
}
