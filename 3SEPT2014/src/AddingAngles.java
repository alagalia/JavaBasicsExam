import java.util.Scanner;
import java.util.stream.Stream;

/**
 You are given n numbers representing different measurements of angles in degrees. Write a program to find among these numbers all sets of three angles that, summed together, give full circle (one or more full rotations – 360, 720, 1080,…,i x 360 degrees). */
public class AddingAngles {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        scanner.nextLine();
        String[] line = scanner.nextLine().split(" ");
        int[] nums = Stream.of(line).mapToInt(Integer::parseInt).toArray();
        boolean isFound = false;

        for (int a = 0; a < nums.length; a++) {
            for (int b = a+1; b < nums.length; b++) {
                for (int c = b+1; c < nums.length; c++) {
                    if ((nums[a]+nums[b]+nums[c])%360== 0){
                        System.out.printf("%d + %d + %d = %d degrees",
                                nums[a], nums[b], nums[c],
                                nums[a] + nums[b] + nums[c]);
                        System.out.println();
                        isFound = true;
                    }
                }
            }
        }
        if (!isFound){
            System.out.println("No");
        }
    }
}
