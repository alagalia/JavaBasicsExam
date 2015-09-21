import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
We are given a sequence of rectangles in the following format:
[a1 x b1] [a2 x b2] … [an x bn]
where a1…an and b1…bn are the sides of the rectangles (positive integers). Our goal is to find three consecutive rectangles with largest total area.
 */
public class Largest3Rectangles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line= scan.nextLine();
        String pattern = "(\\d+)";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(line);
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        boolean turn = true;
        while (matcher.find()){
            if (turn){
                aList.add(Integer.parseInt(matcher.group(0)));
            } else {
                bList.add(Integer.parseInt(matcher.group(0)));
            }
            turn =!turn;
        }
        int[] a = aList.stream().mapToInt(i->i).toArray();
        int[] b = bList.stream().mapToInt(i->i).toArray();

        int maxAreas = 0;
        int maxStartIndex=0;
        for (int i = 0; i < a.length-2; i++) {
            int area1 = a[i]*b[i];
            int area2 = a[i+1]*b[i+1];
            int area3 = a[i+2]*b[i+2];
            int tempAreas= area1+area2+area3;
            if (tempAreas >maxAreas){
                maxAreas=tempAreas;
                maxStartIndex=i;
            }
        }

        System.out.println(maxAreas);
    }
}
