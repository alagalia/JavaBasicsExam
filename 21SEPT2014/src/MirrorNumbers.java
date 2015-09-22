import java.util.Scanner;
/*
You are given n 4-digit numbers. Write a program to find among these numbers all pairs of mirror numbers, such that the reversed positions of digits in the first number are equal to the positions of digits of the second number. Note that both numbers should be distinct (a ? b). Put the sign “<!>” between the numbers. For instance: 1234<!>4321, 6789<!>9876.
 */
public class MirrorNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String line = scan.nextLine();
        String[] numsStr = line.split(" ");
        boolean isFound= false;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                String left = numsStr[i];
                String right= new StringBuilder(numsStr[j]).reverse().toString();
                if (!left.equals(numsStr[j]) && left.equals(right)){
                    System.out.println(numsStr[i] + "<!>" + numsStr[j]);
                    isFound=true;
                }
            }
        }
        if (!isFound){
            System.out.println("No");
        }
    }
}
