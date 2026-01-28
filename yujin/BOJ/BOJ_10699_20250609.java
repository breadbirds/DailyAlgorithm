package Algo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class BOJ_10699_20250609 {
	
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		String formatted = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println(formatted);
		
	}

}
