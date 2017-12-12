package com.qipai.jpa.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Professor {
	@EmbeddedId
	private ProfessorId id;

	private String name;

	private long salary;
	public Professor(String country, int id) {
	    this.id = new ProfessorId(country, id);
	  }
}
