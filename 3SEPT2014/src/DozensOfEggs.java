import java.util.Scanner;

/**
 Pencho has a chicken farm and sells eggs to monopolist grocery chains around Bulgaria. According to standards, he needs to bundle all his eggs weekly produce in dozens of 12 eggs. Help him bundle the eggs and count the final weekly produce. */
public class DozensOfEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int beerSum=0;

        for (int i = 0; i <7 ; i++){
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int quantity = Integer.parseInt(elements[0]);
            String format = elements[1];
            if (format.equals("dozens")){
                beerSum += quantity*12;
            } else {
                beerSum+=quantity;
            }
        }
        System.out.println(beerSum/12+ " dozens + " + beerSum%12+ " eggs");
    }
}
