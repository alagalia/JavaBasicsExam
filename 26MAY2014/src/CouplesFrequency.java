import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
/*
Write a program that reads a sequence of n integers and calculates and prints the frequencies of all couples of two consecutive numbers. For example, for the input sequence { 3 4 2 3 4 2 1 12 2 3 4 }, we have 10 couples (6 distinct), shown on the right with their occurrence counts and frequencies (in percentage).
 */
public class CouplesFrequency {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        String[] numsStr = line.split(" ");
        int[] nums = Stream.of(numsStr).mapToInt(Integer::parseInt).toArray();

        Map<String,Integer> seq = new LinkedHashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            String key = nums[i]+" "+ nums[i+1];
            if (!seq.containsKey(key)){
            seq.put(key,1);
            } else {
                int value = (int) seq.get(key);
                value+=1;
                seq.put(key,value);
            }
        }
        double allCouples = nums.length-1;
        for (String key : seq.keySet()) {
            double value = seq.get(key)*100/allCouples;
            System.out.printf(key + " -> %.2f%%", value);
            System.out.println();
        }
    }
}
