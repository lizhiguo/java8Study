package com.qipai.jpa.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee6 {
	 @Id private int id;
	  private String name;
	  private long salary;
	  
	  @Embedded 
	  @AttributeOverrides({
	      @AttributeOverride(name = "state", column = @Column(name = "PROVINCE")),
	      @AttributeOverride(name = "zip", column = @Column(name = "POSTAL_CODE"))
	  })
	  private Address address;
}
