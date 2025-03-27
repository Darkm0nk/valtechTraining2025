package practiceAssignment.codility;

import java.util.*;

public class SortSentenceByVowelCount {
    
    private static int countVowels(String sentence) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char ch : sentence.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<String> sentence = Arrays.asList(
            "Hello world",
            "java is programming language",
            "sorting sentences "
        );

        sentence.sort((s1, s2) -> Integer.compare(countVowels(s1), countVowels(s2)));

        System.out.println("Sorted sentences based on vowel count:");
        for (String s : sentence) {
            System.out.println(sentence + " (Vowels: " + countVowels(s) + ")");
        }
    }
}

