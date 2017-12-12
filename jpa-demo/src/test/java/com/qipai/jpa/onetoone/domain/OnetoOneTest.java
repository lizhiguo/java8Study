package com.qipai.jpa.onetoone.domain;

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
public class OnetoOneTest {
	@Autowired
	private EntityManager em;
	@Test
	public void 一对一主键连接() {
		log.debug("保存開始");
		Person p1 = new Person();
	    p1.setName("Tom");
	    
	    Department d = new Department();
	    d.setName("Design");
	    p1.setDepartment(d);
	    d.setPerson(p1);
	    
	    em.persist(p1);
	    em.persist(d);
	}
}
