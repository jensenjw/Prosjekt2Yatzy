 package no.hvl.dat109.proj2.yatzy.services;

public class ValidatorService {
    public boolean validateFirstName(String fornavn) {
        return  fornavn != null  
                && fornavn.length()<20
                && fornavn.length()>2
                && fornavn.matches("^[A-Z���][A-Za-z���]*[-\s]?[A-Z���]?[A-Za-z���]*$");            
    }
    
    public boolean validateLastName(String etternavn) {
        return etternavn!=null
                && etternavn.length()<20
                && etternavn.length()>2
                && etternavn.matches("^[A-Z���][A-Za-z���]*[-\s]?[A-Z���]?[A-Za-z���]*$");
    }
    
    public boolean validateMobile(String nr) {
        return nr!=null&&nr.matches("^[0-9]{8}$");
    }
    
    public boolean validatePassword(String pass) {
        return pass!=null && pass.length()>8;
    }
    
    public boolean equalPassword(String pass1, String pass2) {
        return pass1.equals(pass2);
    }
    
    public boolean validateGender(String gender) {
        return gender!=null && (gender.equals("Female")||gender.equals("Male"));
    }

}