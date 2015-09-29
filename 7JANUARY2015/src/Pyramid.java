import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Pyramid {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int theNum = scan.nextInt();
        scan.nextLine();
        List<Integer> result = new ArrayList<>();
        result.add(theNum);
        for (int i = 0; i < n-1; i++) {
            String[] numsStr = scan.nextLine().trim().split("\\s+");
            int[] nums = Stream.of(numsStr).mapToInt(Integer::parseInt).toArray();
            TreeSet<Integer> biggerNums= new TreeSet<>();
            for (int num : nums) {
                if (num>theNum){
                    biggerNums.add(num);
                }
            }
            if (biggerNums.size()!=0){
                theNum=biggerNums.first();
                result.add(theNum);
            } else {
                theNum++;
            }
        }
        System.out.println(result.toString().substring(1,result.toString().length()-1));
    }
}
