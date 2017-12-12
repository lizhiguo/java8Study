package com.qipai.jpa.domain;

import java.util.Date;

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
public class Employee {

	@Id
	@GeneratedValue(generator="fff")
	@GenericGenerator(name="fff",strategy="uuid")
    private String id;
    private String name;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccessTime;
}
