package com.qipai.jpa.onetoone.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "test_dept")
public class Department {
	@Id
	@GeneratedValue(generator="xxx")
	@GenericGenerator(name="xxx",strategy="uuid")
	private String id;

	private String name;

	@OneToOne(mappedBy = "department")
	private Person person;
}
