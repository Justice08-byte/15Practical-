import java.io.*;
import java.util.*;

public class Anagrams{

    public static void main(String[] args){
        // Dictionary to store their word list and signatures
        Map<String, List<String>> anagramMap = new HashMap<>();
        try {
            // 1. Read the file
            BufferedReader reader = new BufferedReader(new FileReader("joyce1922_ulysses-1.text"));
            String line;
            // 2. Process each line
            while ((line = reader.readLine()) != null){
                // Split line into words
                String[] words = line.split("\\s+");
                for (String word : words){
                    // 3. Clean the word
                    String cleanedWord = cleanWord(word);
                    if (!cleanedWord.isEmpty()){
                        // 4. Create signature
                        String signature = alphabetize(cleanedWord);

                        // 5. Store in HashMap
                        if (!anagramMap.containsKey(signature)){
                            List<String> wordList = new ArrayList<>();
                            wordList.add(cleanedWord);
                            anagramMap.put(signature, wordList);
                        } else{
                            anagramMap.get(signature).add(cleanedWord);
                        }
                    }
                }
            }
            reader.close();

            // 6. Generate output
            generateOutput(anagramMap);

        }
        catch(IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    // Clean a word by removing punctuations but keeping apostrophes
    private static String cleanWord(String word){
        Remove punctuation (keep letters, apostrophes, and hyphens if desired)
        String cleaned = word.replaceAll("[^a-zA-Z']", "").toLowerCase();
        return cleaned;
    }
    // Create a signature by sorting letters alphabetically
    private static String alphabetize(String word){
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
    // Generate the anagrams-1.tex file and print anagram lists
    private static void generateOutput(Map<String, List<String>> anagramMap){
        try{
            PrintWriter writer = new PrintWriter(new FileWriter("anagrams-1.tex"));

            // LaTeX header
            writer.println("\\documentclass{article}");
            writer.println("\\begin{document}");
            writer.println("\\section*{Anagrams in Ulysses}");
            writer.println("\\begin{description}");

            // Sort signatures for consistent output
            List<String> signatures = new ArrayList<>(anagramMap.keySet());
            Collections.sort(signatures);
        }
    }
}