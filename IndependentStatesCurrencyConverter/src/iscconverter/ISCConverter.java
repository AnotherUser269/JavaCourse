package iscconverter;
import java.util.*;

public class ISCConverter {
    public static void main(String[] args) {
        double RUB = 1.0;    // Рубли
        double KZT = 0.1536; // Казахстан
        double BYN = 0.0364; // Беларусь
        double UAH = 0.4964; // Украина

        // Filling the HashMap
        Map<String, Double> currencies = new HashMap<String, Double>();
        currencies.put("RUB", RUB);
        currencies.put("KZT", KZT);
        currencies.put("BYN", BYN);
        currencies.put("UAH", UAH);
        
        // Logic
        System.out.print("Welcome to the currency converter!\n" +
                         "Everything is up-to-date on 24.09.2025.\n\n" +

                         "Please choose 2 currencies from the following list:\n\n" +

                         "1) RUB\n" + 
                         "2) KZT\n" + 
                         "3) BYN\n" + 
                         "4) UAH\n" +

                         "\nAnd write a special notation: amount CURRENCY1 -> CURRENCY2\n" +

                         "\n> Your input: ");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        String[] data = userInput.split(" ");

        if (data.length != 4 || !(data[2].equals("->"))) {
            System.out.println("\nYou didn't followed the notation.");
        }
        else {
            try {
                double amount = Double.valueOf(data[0]);

                String cur1 = data[1].toUpperCase();
                String cur2 = data[3].toUpperCase();

                if(!(currencies.containsKey(cur1)) || !(currencies.containsKey(cur2))) {
                    System.out.println("\nYou have provided a wrong currency!");
                }
                else {
                    double convertedAmount = amount*currencies.get(cur1)/currencies.get(cur2);

                    System.out.println("\n" + amount + " " + cur1 + " = " + convertedAmount + " " + cur2);
                }
            }
            catch (NumberFormatException ex){
                System.out.println("\nYou have provided a wrong amount!");
            }
            catch (Exception e) {
                System.out.println("\nSomething went wrong.");
            }
        }   

    }
}