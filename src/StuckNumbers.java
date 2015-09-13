import java.util.Scanner;
/*
You are given n numbers. Write a program to find among these numbers all sets of 4 numbers {a, b, c, d}, such that a|b == c|d, where a ? b ? c ? d. Assume that "a|b" means to append the number b after a. We call these numbers {a, b, c, d} stuck numbers: if we append a and b, we get the same result like if we append c and d. Note that the numbers a, b, c and d should be distinct (a ? b ? c ? d).
 */
public class StuckNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String line =scan.nextLine();
        String[] nums = line.split(" ");
        boolean isFound = false;

        for (String num : nums) {
            for (String num1 : nums) {
                for (String num2 : nums) {
                    for (String num3 : nums) {
                        String left = num + num1;
                        String right = num2 + num3;
                        if (left.equals(right) &&
                                !num.equals(num1) &&
                                !num.equals(num2) &&
                                !num.equals(num3) &&
                                !num1.equals(num2) &&
                                !num1.equals(num3) &&
                                !num2.equals(num3)) {
                            System.out.printf("%s|%s==%s|%s", num, num1, num2, num3).println();
                            isFound = true;
                        }
                    }
                }
            }
        }
        if (!isFound){
            System.out.println("No");
        }
    }
}
