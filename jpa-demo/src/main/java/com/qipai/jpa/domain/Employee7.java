package com.qipai.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Employee7 {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="F_NAME")
    private String firstName;
    @Column(name="L_NAME")
    private String lastName;    
    private long salary;
    
    @ManyToOne
    private Department7 department;
}
