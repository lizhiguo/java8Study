package com.qipai.jpa.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee5 {

	@Id private int id;
    private String name;
    private long salary;
    
    @Embedded 
    private Address address;
}
