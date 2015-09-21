import java.util.Scanner;

public class PythagoreanNumbers {
/*
Write a program to find all such triples (called Pythagorean numbers) among a set of integer numbers.
 */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]= scan.nextInt();
        }

        boolean isMatch= false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int a= nums[i];
                    int b= nums[j];
                    int c = nums[k];
                    if (a<=b && a*a+b*b==c*c){
                        System.out.printf("%1$d*%1$d + %2$d*%2$d = %3$d*%3$d", a,b,c);
                        System.out.println();
                        isMatch=true;
                    }
                }
            }
        }
            if (!isMatch){
                System.out.println("No");
            }
    }
}
