import java.util.HashSet;
import java.util.Scanner;

/**
 You are a given string in a single line. Assume “words” are all sequences of Latin letters. For example in the input string "java..?|basics/*-+=javabasics" we have 3 words: "java", "basics" and "javabasics".
 Write a program to find in the input string all unique sets of 3 “words” {a, b, c}, such that a|b = c. Assume that "a|b" means to concatenate the “word” b after a. We call these “words” {a, b, c} cognate words.
 */
public class CognateWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("(\\W+|\\d+)+");
        HashSet<String> hits = new HashSet<>();
        boolean isFound =false;
        for (int a = 0; a < words.length; a++) {
            for (int b = a; b < words.length; b++) {
                for (int c = 0; c < words.length; c++) {
                    if (a!=b && b!=c){
                        String left = words[a]+words[b];
                        String leftInverse= words[b]+words[a];
                        if (left.equals(words[c])){
                            String forAdd= words[a]+"|"+words[b]+"="+words[c];
                            hits.add(forAdd);
                            isFound=true;
                            continue;
                        }
                        if (leftInverse.equals(words[c])){
                            String forAdd= words[b]+"|"+words[a]+"="+words[c];
                            hits.add(forAdd);
                            isFound=true;
                        }
                    }
                }
            }
        }
        if (!isFound){
            System.out.println("No");
        } else {
            for (String hit : hits) {
                System.out.println(hit);
            }
        }
    }
}
