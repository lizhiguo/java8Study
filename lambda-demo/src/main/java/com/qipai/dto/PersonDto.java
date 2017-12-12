package com.qipai.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

	private String id;
	private String name;
	private LocalDate birthDate;
	private Integer age;
}
