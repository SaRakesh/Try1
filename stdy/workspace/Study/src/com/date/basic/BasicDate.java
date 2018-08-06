package com.date.basic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

public class BasicDate {

	public static void main(String[] args) {
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());
		ZoneId zone = ZoneId.of("US/Eastern");
		System.out.println(LocalTime.now(zone));
		 Set<String> stream = ZoneId.getAvailableZoneIds();
		 Arrays.sort(stream.toArray());
		//System.out.println(stream); Asia/Kolkata
	}
}
