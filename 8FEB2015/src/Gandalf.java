import java.util.Scanner;

/**
 * Created by Dell on 28.9.2015 ã..
 */
public class Gandalf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Mood= Integer.parseInt(scan.nextLine());
        String[] line = scan.nextLine().toLowerCase().split("([^A-Za-z])");
        for (int i = 0; i < line.length; i++) {
            if (!line[i].equals("")){
                int effect = takeEfect(line[i]);
                Mood+=effect;
            }
        }
        System.out.println(Mood);
        System.out.println(moodAsText(Mood));
    }

    private static String moodAsText(int mood) {
        if (mood<-5){
            return "Angry";
        } else if (mood>=-5 && mood<0){
            return "Sad";
        } else if (mood>=0 && mood<15){
            return "Happy";
        }
            return "Special JavaScript mood";
    }

    private static int takeEfect(String s) {
        switch (s){
            case "cram": return 2;
            case "lembas": return 3;
            case "apple": return 1;
            case "melon": return 1;
            case "honeycake": return 5;
            case "mushrooms": return -10;
        }
        return -1;
    }
}
