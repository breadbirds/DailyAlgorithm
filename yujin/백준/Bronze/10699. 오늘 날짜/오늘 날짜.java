import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
	
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		String formatted = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println(formatted);
		
	}

}

