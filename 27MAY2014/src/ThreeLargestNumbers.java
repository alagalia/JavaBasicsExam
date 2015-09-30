import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 You are given n numbers. Write a program to print the largest, the second largest and the third largest among them.
 */
public class ThreeLargestNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigDecimal[] nums = new BigDecimal[n];

        for (int i = 0; i < n; i++) {
            BigDecimal num = new BigDecimal(scanner.nextLine());
            nums[i]= num;
        }
        Arrays.sort(nums, Collections.reverseOrder());

        int printLen = nums.length<3 ? nums.length : 3;
        for (int i = 0; i <printLen; i++) {
            System.out.println(nums[i].toPlainString());
        }

    }
}
