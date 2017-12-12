package com.qipai.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class ProfessorId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String country;

	@Column(name = "EMP_ID")
	private int id;
}
