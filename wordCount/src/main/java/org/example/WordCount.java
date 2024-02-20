package org.example;


//Implement the method wordCount as described in the problem: This includes having identical characters and spacing.

public class WordCount{
    public static void main(String[] args) {

        System.out.println(wordCount("hello"));                 // 1
        System.out.println(wordCount("how are you?"));           // 3
        System.out.println(wordCount("    how are you?"));      // 3
        System.out.println(wordCount("how are you?     "));      // 3
        System.out.println(wordCount("how are you  ?"));         // 4
        System.out.println(wordCount("I am 3 years old"));       // 5
        System.out.println(wordCount("3 x 4 = 12"));             // 5
        System.out.println(wordCount("Characters !@#$%^&*"));     // 2
        System.out.println(wordCount("     "));                // 0
    }

    public static int wordCount(String inputString) {
        boolean inWord = false;
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);

            if (Character.isWhitespace(currentChar)) {
                inWord = false;
            } else {
                if (!inWord) {
                    inWord = true;
                    count++;
                }
            }
        }
        return count;
    }
}