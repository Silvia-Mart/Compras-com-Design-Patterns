package Strategy_Singleton.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator {

	public static boolean isValid(String date) {
	      try {
	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
	         LocalDate d = LocalDate.parse(date, formatter);    
	         return true;
	      } catch (DateTimeParseException e) {
	        return false;
	      }   
	   }
}