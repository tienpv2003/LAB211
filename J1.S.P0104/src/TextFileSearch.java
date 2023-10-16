import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the file path: ");
        String filePath = scanner.nextLine();
        System.out.println("Please enter the string to search: ");
        String searchStr = scanner.nextLine();

        List<String> foundWords = findMatchingWords(filePath, searchStr);

        if (foundWords != null) {
            if (foundWords.isEmpty()) {
                System.out.println("Not found word");
            } else {
                System.out.println("\nSearch result: ");
                for (String word : foundWords) {
                    System.out.println("\t" + word);
                }
            }
        }

        scanner.close();
    }

    private static List<String> findMatchingWords(String filePath, String searchStr) {
        List<String> matchingWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.contains(searchStr)) {
                        matchingWords.add(word);
                    }
                }
            }
            
        } catch (IOException e) {
            System.err.println("Cannot find the file");
            return null;
        }
        return matchingWords;
    }
}
