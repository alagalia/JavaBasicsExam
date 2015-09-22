import java.util.Arrays;
import java.util.Scanner;
/*
In Geometry a triangle is real if the sum of the shortest two sides is larger than the longest side. Write a program that checks three real numbers if there is a possible triangle to be built from them. You are given lines of three real numbers. The last line will hold “End”. Print all the possibilities in the format “a+b>c”. Where a and b are the shortest sides and c is the longest.
 */
public class PossibleTriangles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isFound= false;

        while (true) {
            String line =scan.nextLine();
            if (line.equals("End")){
                break;
            }
            String[] input = line.split(" ");

            Double[] side = new Double[]{Double.parseDouble(input[0]), Double.parseDouble(input[1]), Double.parseDouble(input[2])};
            Arrays.sort(side);
            if(side[0]+side[1]>side[2]){
                System.out.printf("%.2f+%.2f>%.2f", side[0],side[1],side[2]);
                System.out.println();
                isFound=true;
            }
        }
        if (!isFound){
            System.out.println("No");
        }
    }
}
