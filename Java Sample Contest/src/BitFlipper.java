import java.math.BigInteger;
import java.util.Scanner;

public class BitFlipper {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        String num = dec2bin_i(line);
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            if (i<=num.length()-3){
                if (num.charAt(i)==num.charAt(i+1) &&
                        num.charAt(i+1)==num.charAt(i+2) &&
                        num.charAt(i)==48){
                    sb.append("111");
                    i+=2;
                } else if (num.charAt(i)==num.charAt(i+1) &&
                        num.charAt(i+1)==num.charAt(i+2) &&
                        num.charAt(i)==49){
                    sb.append("000");
                    i+=2;
                } else {
                    sb.append(num.charAt(i));
                }
            } else {
                sb.append(num.charAt(i));
            }
        }
        String result = sb.toString();
        System.out.println(new BigInteger(result,2));
    }
    public static String dec2bin_i (String dec) {
        long number = Long.parseLong(dec);
        String dig;
        StringBuilder bin = new StringBuilder();

        while (number > 0) {
            if (number % 2 == 1)
                dig = "1";
            else
                dig = "0";
            bin = bin.append(dig);
            number /= 2;
        }
        StringBuilder sb = new StringBuilder();
        if (bin.length()<64){
            for (int i = 0; i < 64 - bin.length(); i++) {
                sb.append("0");
            }
        }
        sb.append(bin.toString());
        return sb.toString();
    }

}
