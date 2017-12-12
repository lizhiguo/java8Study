package com.qipai.jpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Person {
	@Id
	@GeneratedValue(generator="xxx")
	@GenericGenerator(name="xxx",strategy="uuid")
	private String id;
	@Column(name = "NAME",length=40,unique=true, nullable=false,columnDefinition = "VARCHAR(40)")
	private String name;
	@Column(precision=8, scale=2) 
	private float hourlyRate;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	private Integer age;
	public Person(String name, Date birthDate, Integer age) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.age = age;
	}

}
