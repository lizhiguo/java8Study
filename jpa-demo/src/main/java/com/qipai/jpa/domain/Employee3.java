package com.qipai.jpa.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee3 {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private long salary;

    // Using a targetClass instead of generics
    @ElementCollection(targetClass=VacationEntry.class)
    private Collection<VacationEntry> vacationBookings = new LinkedList<>();

    // Using generics in place of a targetClass
    @ElementCollection
    private Set<String> nickNames = new HashSet<>();
}
