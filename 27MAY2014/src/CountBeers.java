import java.util.Scanner;

/**
 * Created by Dell on 30.9.2015 ã..
 */
public class CountBeers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int beerSum=0;
        while (!line.equals("End")){
            String[] elements = line.split(" ");
            int quantity = Integer.parseInt(elements[0]);
            String format = elements[1];
            if (format.equals("stacks")){
                beerSum += quantity*20;
            } else {
                beerSum+=quantity;
            }
            line=scanner.nextLine();
        }
        System.out.println(beerSum/20 + " stacks + " + beerSum%20+ " beers");
    }
}
