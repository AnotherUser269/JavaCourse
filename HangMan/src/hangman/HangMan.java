package hangman;

import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class HangMan {
    static final Path filePath = Path.of("src/resources/words.txt");
    static final Path stagesPath = Path.of("src/resources/stages.txt");
    static final String allLetters = "qwertyuiopasdfghjklzxcvbnm";

    private static Map<Integer, String> stages = new HashMap<Integer, String>();

    public static void main(String[] args) throws IOException{
        // Loading all words
        final ArrayList<String> words = new ArrayList<>(Files.readAllLines(filePath));

        // Loading all stages 
        int stageIndex = 0;
        
        for(String line: Files.readAllLines(stagesPath)) {
            stages.put(stageIndex, line.replace("\\n", "\n"));
            stageIndex ++;
        }

        // Game logic
        final String secretWord = generateWord(words);
        ArrayList<String> bannedLetters = new ArrayList<String>();

        String[] currentProgress = new String[secretWord.length()];
        Arrays.fill(currentProgress, "_");

        int fails = 0;

        String userLetter = "";
        String userWord = "";

        Scanner scanner = new Scanner(System.in);

        while(!(userWord.equals(secretWord)) && fails != 6) {
            showStatistics(fails, bannedLetters, currentProgress);

            System.out.print("Enter a letter: ");
            userLetter = scanner.nextLine().toLowerCase();

            if(!(bannedLetters.contains(userLetter)) && userLetter.length() == 1) {
                if(allLetters.contains(userLetter)){
                    if (secretWord.contains(userLetter)) {
                        for(int i=0; i<secretWord.length(); i++) {
                            if (secretWord.charAt(i) == userLetter.charAt(0)) {
                                currentProgress[i] = userLetter;
                            }
                        }
                    }
                    else {
                        bannedLetters.add(userLetter);
                        fails ++;
                    }

                    userWord = String.join("", currentProgress);
                }
            }

        }

        showStatistics(fails, bannedLetters, currentProgress);

        if(fails==6){
            System.out.println("You lost! The word was: " + secretWord);
        }
        else {
            System.out.println("You won! Congrats!");
        }

    }


    static String generateWord(ArrayList<String> words) {
        // Returns a secret word

        int listSize = words.size();

        Random random = new Random();
        int randIndex = random.nextInt(listSize);

        String randomWord = words.get(randIndex);

        return randomWord;
    }

    static void showStatistics(int fails, ArrayList<String> bannedLetters, String[] currentWord) {
        // Prints current state of the game
        int lives = 6 - fails;

        System.out.print("\033[H\033[2J");
        System.out.println(stages.get(fails));

        System.out.println("\n<Statistics>\n\n" +
                             "\n- Lives: " + lives +
                             "\n- Banned letters: " + String.join("", bannedLetters) +
                             "\n- Current progress: " + String.join("", currentWord) + "\n");

    }
 
}