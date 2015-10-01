import java.math.BigInteger;
import java.util.Scanner;

public class Tribonachi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger num1 = BigInteger.valueOf(Integer.parseInt(scan.nextLine()));
        BigInteger num2 = BigInteger.valueOf(Integer.parseInt(scan.nextLine()));
        BigInteger num3 = BigInteger.valueOf(Integer.parseInt(scan.nextLine()));

        int n = Integer.parseInt(scan.nextLine());
        BigInteger trib = BigInteger.valueOf(0);
        if (n==1){
            System.out.println(num1);
        }
        if (n==2){
            System.out.println(num2);
        }
        if (n==3){
            System.out.println(num3);
        }


        for (int i = 0; i < n-3; i++) {
            trib = num1.add(num2);
            trib = trib.add(num3);
            num1=num2;
            num2=num3;
            num3=trib;
        }
        System.out.println(trib);
    }
}
