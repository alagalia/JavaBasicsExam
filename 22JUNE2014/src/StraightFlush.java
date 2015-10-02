import java.util.LinkedHashSet;
import java.util.Scanner;

public class StraightFlush {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] cards = scan.nextLine().split("\\W+");
        String[] faces = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        String[] face = new String[cards.length];
        String[] suit = new String[cards.length];

        for (int i = 0; i < cards.length; i++) {
            String f1 = cards[i].substring(0, cards[i].length() - 1);
            face[i] = f1;
            String s1 = cards[i].substring(cards[i].length() - 1);
            suit[i] = s1;
        }
        boolean isFound= false;
        for (int a = 0; a < face.length; a++) {
            String aa= suit[a];
            String faa=face[a];
            for (int b = 0; b < face.length; b++) {
                String bb=suit[b];
                String fbb=face[b];
                for (int c = 0; c < face.length; c++) {
                    String cc=suit[c];
                    String fcc=face[c];
                    for (int d = 0; d < face.length; d++) {
                        String dd = suit[d];
                        String fdd=face[d];
                        for (int e = 0; e < face.length; e++) {
                            String ee= suit[e];
                            String fee=face[e];
                            if (isSuitMatch(aa,bb,cc,dd,ee)){
                                if (isFaceMatch(faces, faa, fbb , fcc, fdd, fee)){
                                    String suitMatch = suit[a];
                                    LinkedHashSet<String> match = new LinkedHashSet<>();
                                    match.add(face[a]+suitMatch);
                                    match.add(face[b]+suitMatch);
                                    match.add(face[c]+suitMatch);
                                    match.add(face[d]+suitMatch);
                                    match.add(face[e]+suitMatch);
                                    System.out.println(match);
                                    isFound=true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!isFound) {
            System.out.println("No Straight Flushes");
        }
    }

    private static boolean isFaceMatch(String[] faces, String f1, String f2, String f3, String f4, String f5) {
        boolean isMatch=false;
        for (int i = 0; i < faces.length-4; i++) {
            if (f1.equals(faces[i])&&
                    f2.equals(faces[i+1]) &&
                    f3.equals(faces[i+2]) &&
                    f4.equals(faces[i+3]) &&
                    f5.equals(faces[i+4])){
                isMatch=true;
                break;
            }
        }
        return isMatch;
    }

    private static boolean isSuitMatch(String s1, String s2, String s3, String s4, String s5) {
        return s1.equals(s2) &&
                s2.equals(s3)&&
                s3.equals(s4) &&
                s4.equals(s5);
    }
}
