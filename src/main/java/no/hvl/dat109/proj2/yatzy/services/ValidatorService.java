 package no.hvl.dat109.proj2.yatzy.services;

public class ValidatorService {
    public boolean validateUsername(String username) {
        return  username != null  
                && username.length()<20
                && username.length()>2;
    }
    
    public boolean validateFullname(String fullname) {
        return fullname!=null
                && fullname.length()<40
                && fullname.length()>2;
    }
    
    public boolean validateEmail(String email) {
        return email!=null;
    }
    
    public boolean validatePassword(String pass) {
        return pass!=null && pass.length()>=8;
    }
    
    public boolean equalPassword(String pass1, String pass2) {
        return pass1.equals(pass2);
    }
    
}