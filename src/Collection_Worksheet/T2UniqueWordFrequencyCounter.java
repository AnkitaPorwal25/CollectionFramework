package Collection_Worksheet;
import java.util.*;

public class T2UniqueWordFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input - Technology is evolving rapidly. With new innovations emerging every day, it is important to stay informed. Artificial intelligence, machine learning, and data science are transforming industries. As technology advances, the way we live and work continues to change.
        // Prompt user for input
        System.out.println("Enter a paragraph:");

        String paragraph = scanner.nextLine();

        // Normalize text: lowercase and remove punctuation
        String cleaned = paragraph.toLowerCase().replaceAll("[^a-z\\s]", "");

        // Split into words by one or more whitespace characters
        String[] words = cleaned.split("\\s+");

        // Map to store word frequency
        Map<String, Integer> wordFreq = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
            }
        }

        // TreeSet to store and sort unique words
        Set<String> sortedWords = new TreeSet<>(wordFreq.keySet());

        // Output
        System.out.println("\nTotal unique words: " + wordFreq.size());
        System.out.println("\nWord frequencies (alphabetical order):");

        for (String word : sortedWords) {
            System.out.println(word + ": " + wordFreq.get(word));
        }

        scanner.close();
    }
}



// we can use treeMap as it is going to be a best solution as it provides a default sorting sorder while storing Keys(words in this case)
// and removes need of applying TreeSet and Map alternatively.