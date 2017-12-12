package com.qipai.jpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Embeddable
public class VacationEntry {
	@Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name="DAYS")
    private int daysTaken;
}
