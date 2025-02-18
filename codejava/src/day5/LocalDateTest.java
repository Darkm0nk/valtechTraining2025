package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class LocalDateTest {
	
	@Test
	
	void localDateTime() {
		LocalDateTime independenceDay = LocalDateTime.of(1947, 8,15,9,15,10);
		System.out.println("independenceDayUp :: "+ independenceDay);
	}
	@Test
	void test() {
		
		LocalDate independenceDay = LocalDate.of(1947, 8, 15);
		System.out.println("independenceDay:: "+ independenceDay);
		
		LocalDate preIndependenceDay = independenceDay.minusDays(1);
		System.out.println("preIndependenceDay:: "+preIndependenceDay);
		
		LocalDate PostIndependenceDay = preIndependenceDay.plusDays(2);
		System.out.println("PostIndependenceDay:: "+PostIndependenceDay);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		System.out.println(dtf.format(PostIndependenceDay));
		System.out.println(LocalDate.parse("1947-08-15"));
	}

}
