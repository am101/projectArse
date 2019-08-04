
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed
 */
public class EmailCheck {
    
    public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
    
    public static int validate(String password) {
        
        if (password.matches(".*[0-9]{1,}.*") &&
                password.matches(".*[@#$]{1,}.*") && 
                password.length()>=6 && 
                password.length()<=20) {
            return 1;
        } else {
            return -1;
        }
        
    }
    
}
