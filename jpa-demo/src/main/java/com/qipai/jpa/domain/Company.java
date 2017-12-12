package com.qipai.jpa.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Company {
	@Id
	private int id;

	@Embedded
	private Address address;
}
