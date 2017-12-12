package com.qipai.jpa.repo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
import com.qipai.jpa.domain.Person;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
@Transactional
@Rollback(false)
@Slf4j
public class PersonRepoTest {

	@Autowired
	private IPersonRepo repo;
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void 保存() {
		log.debug("数据保存");
		ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);

        Date date = Date.from(zdt.toInstant());
        
		repo.save(new Person("king222",date,28));
	}
	
	@Test
	public void 保存2() {
		log.debug("数据保存2");
		Person p = new Person();
		p.setAge(20);
		p.setHourlyRate(2000.50321f);
		p.setName("king2");
		entityManager.persist(p);
	}
}
