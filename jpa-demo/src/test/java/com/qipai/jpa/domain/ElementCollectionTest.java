package com.qipai.jpa.domain;

import java.util.HashMap;
import java.util.Map;

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
public class ElementCollectionTest {
	@Autowired
	private EntityManager em;
	@Test
	public void 保存Map映射到数据库() {
		log.debug("保存開始");
		Employee2 e2 = new Employee2();
		e2.setName("king-test");
		e2.setSalary(20l);
		Map<String, String> phoneNumbers = new HashMap<>();
		phoneNumbers.put("home", "123456789");
		phoneNumbers.put("work", "059212267");
		e2.setPhoneNumbers(phoneNumbers);
		em.persist(e2);
	}
	@Test
	public void 獲得Map映射到数据() {
		Employee2 e2 = em.find(Employee2.class, 1);
		e2.getPhoneNumbers().forEach((k,v)->log.debug("key : " + k + "; value : " + v));
	}
	
	@Test
	public void 通用目标实体() {
		Employee3 emp = new Employee3();
	    emp.setName("name");
	    emp.setSalary(12345);
	    
	    VacationEntry v = new VacationEntry();
	    v.setDaysTaken(10);
	    
	    emp.getVacationBookings().add(v);
	    emp.getNickNames().add("Tester");
	    em.persist(emp);
	}
	
	@Test
	public void 通用类型的Map映射() {
		Employee4 e = new Employee4();
	    e.setName("Tom");
	    Department d = new Department();
	  
	    d.setName("test");
	    d.getEmployees().put(e, e.getId());
	    
	    
	    em.persist(e);    
	    em.persist(d);
	}
}
