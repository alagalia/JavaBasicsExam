import java.util.Scanner;

/**
 * Created by Dell on 29.9.2015 ã..
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