import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int d= Integer.parseInt(scan.nextLine());
        List<Integer> list = new ArrayList<>();

        String line = scan.nextLine();
        while(!line.equals("End")){
            int num = Integer.parseInt(line);
            list.add(num);
            line = scan.nextLine();
        }

        int[] nums = list.stream().mapToInt(i->i).toArray();
        Integer[] winners= new Integer[3];
        boolean isFound=false;

        int sum = Integer.MIN_VALUE;
        for (int a = 0; a < list.size(); a++) {
            for (int b = a+1; b < list.size(); b++) {
                for (int c = b+1; c < list.size(); c++) {
                    int currentSum = nums[a]+nums[b]+nums[c];
                    if(currentSum % d==0 &&currentSum>sum || currentSum==0){
                            winners[0]=nums[a];
                            winners[1]=nums[b];
                            winners[2]=nums[c];
                            sum=currentSum;
                            isFound=true;
                    }
                }
            }
        }
        if (isFound){
            System.out.printf("(%d + %d + %d) %% %d = 0", winners[0], winners[1], winners[2], d);
        } else {
            System.out.println("No");
        }
    }
}
