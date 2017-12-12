package com.qipai.query.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private String id;
	private String name;
	private LocalDate birthDate;
	private Integer age;

}
