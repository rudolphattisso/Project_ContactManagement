package fr.afpa;
import java.util.regex.*;

public class VerificationUrl {



    public static boolean isValidURL(String url) {

        

        // String regex = "https?://(?:www\\.)?[a-zA-Z0-9./]+";
        String regex = "^((https?|ftp)://)?(www\\.)?(([a-zA-Z0-9]+[\\-]?[a-zA-Z0-9]+\\.)+[a-zA-Z]{2,6})(:[0-9]{1,5})?(/.*)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String url = "ww.example.com";
        System.out.println("Is URL valid? " + isValidURL(url));
    }



}
