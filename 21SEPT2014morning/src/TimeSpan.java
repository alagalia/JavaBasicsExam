import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeSpan {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        String time1= scan.nextLine();
        String time2= scan.nextLine();

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long diff = date2.getTime() - date1.getTime();
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000);


        System.out.printf("%d:%02d:%02d", Math.abs(diffHours), Math.abs(diffMinutes),Math.abs( diffSeconds));

    }
}
