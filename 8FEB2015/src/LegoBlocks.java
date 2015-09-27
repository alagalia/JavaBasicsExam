/*
You are given two jagged arrays. Each array represents a Lego block containing integers. Your task is first to reverse the second jagged array and then check if it would fit perfectly in the first jagged array. 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LegoBlocks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String [][] left = new String [n][];
        String [][] right = new String [n][];
        int blocks=0;

        for (int row = 0; row < n; row++) {
            left[row]= scan.nextLine().trim().split("\\s+");
            blocks+=left[row].length;
        }
        for (int row = 0; row < n; row++) {
            String line = scan.nextLine();
            right[row]=new StringBuilder(line).reverse().toString().trim().split("\\s+");
            blocks+=right[row].length;
        }

        if (hasFit(left,right)){
            for (int i = 0; i <n ; i++) {
                printLine(left[i],right[i]);

            }
        } else {
            System.out.println("The total number of cells is: "+    blocks);
        }

    }

    private static void printLine(String[] left, String[] right) {
        List<String> list = new ArrayList<String>(Arrays.asList(left));
        list.addAll(Arrays.asList(right));
        Object [] c = list.toArray();
        System.out.println(Arrays.toString(c));
    }

    private static boolean hasFit(String[][] left, String[][] right) {
        int lenght = left[0].length+right[0].length;
        for (int i = 1; i < left.length; i++) {
            if (left[i].length+right[i].length!=lenght){
                return false;
            }
        }
        return true;
    }

}
