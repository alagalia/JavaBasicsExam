import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] line = scan.nextLine().split("\\s+");
        Double result = 0d;
        for (int i = 0; i < line.length; i++) {
            char left = line[i].charAt(0);
            char right = line[i].charAt(line[i].length()-1);
            double num = Long.parseLong(line[i].substring(1,line[i].length()-1));
            if (Character.isLowerCase(left)){
                num*=left-96;
            } else {
                num/=left-64;
            }
            if (Character.isLowerCase(right)){
                num+=right-96;
            } else {
                num-=right-64;
            }
            result+=num;
        }
        System.out.printf("%.2f",result);
    }

}
