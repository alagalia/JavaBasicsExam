import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dell on 30.9.2015 ã..
 */
public class LongestOddEvenSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Pattern pat = Pattern.compile("(\\d+)");
        Matcher m = pat.matcher(line);
        List<Integer> numsAsList= new ArrayList<>();
        while (m.find()){
            numsAsList.add(Integer.parseInt(m.group()));
        }

        int[] num = numsAsList.stream().mapToInt(i->i).toArray();
        int counter=1;
        int currentCounter=1;
        for (int i = 0; i < num.length - 1; i++) {
            if (isOddEven(num[i],num[i+1])){
                currentCounter++;
            } else if(currentCounter>counter){
                counter=currentCounter;
                currentCounter=1;
            } else {
                currentCounter=1;
            }
        }
        if (currentCounter>counter){
            counter=currentCounter;
        }
        System.out.println(counter);
    }

    private static boolean isOddEven(int i, int i1) {
        boolean result=false;
        if ((i%2==0 && i1%2!=0) ||
                i%2!=0 && i1%2==0 ||
                i==0 ||
                i1==0){
            result=true;
        }
        return result;
    }
}
