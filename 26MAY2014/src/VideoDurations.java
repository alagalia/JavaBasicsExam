import java.util.Scanner;

public class VideoDurations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalMin = 0;
        while (true) {
            String line =scan.nextLine();
            if (line.equals("End")){
                break;
            }
            String[] input = line.split(":");
            int hour = Integer.parseInt(input[0]);
            int min = Integer.parseInt(input[1]);
            totalMin += hour*60 + min;
        }
        int totalHour =totalMin/60;
        totalMin %=60;
        System.out.printf("%d:%02d", totalHour, totalMin);
    }
}
