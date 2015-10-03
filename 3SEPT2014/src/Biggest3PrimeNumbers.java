import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 You are given n numbers in format (a1) (a2) … (an). Write a program to find the sum of the 3 biggest non-repeating prime numbers inside the input sequence. A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself. */
public class Biggest3PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String[] line = scanner.nextLine().trim().split("[^\\d+]+");
        TreeSet<Integer> nums = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < line.length; i++) {
            if (!line[i].equals("")){
                int num = Integer.parseInt(line[i]);
                if (isPrime(num)){
                    nums.add(num);
                }
            }
        }
        if (nums.size()<3){
            System.out.println("No");
        } else {
            int sum=0;
            for (int i = 0; i < 3; i++) {
                int num = nums.first();
                sum+=num;
                nums.remove(nums.first());
            }
            System.out.println(sum);
        }
    }

    private static boolean isPrime(int number) {
        return number > 1
                && IntStream.range(2, number).noneMatch(
                index -> number % index == 0);
    }


}
