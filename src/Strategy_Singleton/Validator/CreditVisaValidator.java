package Strategy_Singleton.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditVisaValidator {

    public static boolean isValidVisaCard(String visa){

        String regex = "^4[0-9]{12}(?:[0-9]{3})?$";
        Pattern p = Pattern.compile(regex);
 
        if (visa == null) {
            return false;
        }
        
        Matcher m = p.matcher(visa);
        return m.matches();
    }
    
    public static boolean isValidCvv(String cvv) {
    	 if(cvv.length()!=3) {
         	System.out.println("unauthorized cvv");
         	throw new RuntimeException("unauthorized cvv");
         }
    	return true;
    }
    
}