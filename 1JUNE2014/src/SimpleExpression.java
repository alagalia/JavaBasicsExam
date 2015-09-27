import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pat = Pattern.compile("((\\d+\\.*\\d*)|([-+]))");
        Matcher matcher = pat.matcher(scan.nextLine());
        List<String> allMatches= new ArrayList<>();
        while (matcher.find()) {
            allMatches.add(matcher.group());
        }
        String[] elements = allMatches.toArray(new String[allMatches.size()]);

        BigDecimal sum =  new BigDecimal(elements[0]);

        for (int i = 1; i < elements.length-1; i+=2) {
            BigDecimal num = new BigDecimal(elements[i+1]);
            String sign = elements[i];
            switch (sign){
                case "-": sum=sum.subtract(num); break;
                case "+": sum=sum.add(num); break;
            }
        }
        System.out.printf(new DecimalFormat("#.#######").format(sum));

    }
}