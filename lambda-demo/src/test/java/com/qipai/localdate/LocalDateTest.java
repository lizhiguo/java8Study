package com.qipai.localdate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalDateTest {

	/**
	 * 1）将java.util.Date转换为ZonedDateTime。
     * 2）使用它的toLocalDate（）方法从ZonedDateTime获取LocalDate。
	 */
	@Test
	public void 時間API使用_date轉換成LocalDate() {
		log.debug("date轉換成LocalDate");
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();

		// atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
		LocalDate localDate = instant.atZone(zoneId).toLocalDate();
		System.out.println("Date = " + date);
		System.out.println("LocalDate = " + localDate);
	}
	/**
	 * 1）使用ZonedDateTime将LocalDate转换为Instant。
     * 2）使用from（）方法从Instant对象获取Date的实例
	 */
	@Test
	public void LocalDate轉換成Date() {
		ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);

        Date date = Date.from(zdt.toInstant());

        System.out.println("LocalDate = " + localDate);
        System.out.println("Date = " + date);
	}
	
	
}
