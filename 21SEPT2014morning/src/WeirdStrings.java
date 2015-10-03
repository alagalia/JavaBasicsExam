import java.util.Scanner;

/**
 We are given a sequence of characters S. This sequence holds junk characters.  Junk characters are:
  "\", "/", "(", ")", "|" and all empty spaces (1 or more). Your first task is to remove all junk characters.  Then you have to find all words in the resulted string. Word is considered any sequence of letters (a-z A-Z). Each of those words has weight. Each letter weight corresponds to its value in the English alphabet (a = 1, b=2…z=26). Small and capital letters have the same weight.  Your task is to find the sum of every 2 consecutive words and print on the console the 2 words with biggest sum. 
 */
public class WeirdStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine().replaceAll("[\\\\\\/()|\\s]", "");
        String[] words = line.split("[^A-Za-z]+");

        int sum = 0;
        int index = 0;
        for (int i = 0; i < words.length - 1; i++) {
            int weights = weight(words[i]) + weight(words[i + 1]);
            if (weights >= sum) {
                sum = weights;
                index = i;
            }
        }
        System.out.println(words[index]);
        System.out.println(words[index+1]);
    }

    private static int weight(String word) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += word.toLowerCase().charAt(i) - 96;
        }
        return sum;
    }
}
