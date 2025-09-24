package passwordgen;
import java.util.*;

public class PasswordGenerator {
    public static void main (String[] args) {
        System.out.println("Welcome to the password generator.\n");
        
        System.out.println("Please, provide a length in 8-12 range: ");
        Scanner scanner = new Scanner(System.in);
        
        try {
            int passwordLength = scanner.nextInt();
            
            if(!(passwordLength <= 12 && passwordLength >= 8)) {
                 throw new InputMismatchException();
            }
            
            String[] password = generatePassword(passwordLength);
            
            System.out.println("Your password: " + "".join("", password));
        }
        catch (InputMismatchException e) {
            System.out.println("You have provided a wrong length");
        }
        catch (Exception ex) {
            System.out.println("Something went wrong.");
        }
        
    }
    
    public static String[] generatePassword (int passwordLength) {
        // Generates an empty password and fills it
        
        String[] password = new String[passwordLength];
        Arrays.fill(password, "empty");
        
        Random random = new Random();
        char symbol;
        
        while (!checkIfStrong(password)) {
            for(int i=0; i<passwordLength; i++) {
                symbol = (char) (random.nextInt(94)+33);
                password[i] = String.valueOf(symbol);
            }
        }
        
        return password;
    }
    
    public static boolean checkIfStrong(String[] password) {
        // Checks all conditions of a string password
        
        boolean numberFlag = false;
        boolean capLetterFlag = false;
        boolean lowLetterFlag = false;
        boolean specialSymbolFlag = false;
        
        int asciiValue;
        
        for(int i=0; i<password.length; i++){
            if(password[i].equals("empty")) {
                return false;
            }
            
            asciiValue = (int) password[i].charAt(0);
            
            if (48 <= asciiValue && asciiValue <= 57) {
                numberFlag = true;
            }
            else if (97 <= asciiValue && asciiValue <= 122)  {
                lowLetterFlag = true;
            }
            else if (65 <= asciiValue && asciiValue <= 90) {
                capLetterFlag = true;
            }
            else {
                specialSymbolFlag = true;
            }
        }
        
        boolean strongFlag = numberFlag && capLetterFlag && lowLetterFlag && specialSymbolFlag;
        
        return strongFlag;
    }
}