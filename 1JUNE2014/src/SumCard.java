import java.util.Scanner;
/*
The game uses a standard deck of 52 cards. The card faces are: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K and A. The cards suits are denoted by the letters S (spades), H (hearts), D (diamonds) and C (clubs). The player is given a hand of cards and he needs to count their sum. Card values are the following: 2 -> 2, 3 -> 3, 4 -> 4, 5 -> 5, 6 -> 6, 7 -> 7, 8 -> 8, 9 -> 9, 10 -> 10, J -> 12, Q -> 13, K -> 14, A -> 15 (the card suits are ignored). When two or more cards of the same face come sequentially, their values are counted twice.
For example, the hand "2C 2H 2D AS 10H 10C 2S KD" has value (2 + 2 + 2) * 2 + 15 + (10 + 10) * 2 + 2 + 14 = 83.
Write a program that takes a hand of cards and counts their sum.

 */
public class SumCard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] facesArray = scan.nextLine().split(" ");

        int sum = 0;
        int counter = 1;
        int prev = takeValueFace(facesArray[0]);

        for (int i = 1; i < facesArray.length; i++) {
            int current = takeValueFace(facesArray[i]);
            if (prev == current) {
                counter++;
            } else {
                if (counter > 1) {
                    sum += prev * counter * 2;
                    counter = 1;
                } else {
                    sum += prev;
                }
            }
            if (i == facesArray.length - 1){
                if ( prev==current){
                    sum += current * counter * 2;
                }else {
                    sum+=current;
                }
            }
            prev = current;
        }
        PrintResult(facesArray, sum);
    }

    private static void PrintResult(String[] facesArray, int sum) {
        if (facesArray.length==1) {
            System.out.println(takeValueFace(facesArray[0]));
        } else {
        System.out.println(sum);
        }
    }

    private static int takeValueFace(String face) {
        if (face.startsWith("2")) return 2;
        if (face.startsWith("3")) return 3;
        if (face.startsWith("4")) return 4;
        if (face.startsWith("5")) return 5;
        if (face.startsWith("6")) return 6;
        if (face.startsWith("7")) return 7;
        if (face.startsWith("8")) return 8;
        if (face.startsWith("9")) return 9;
        if (face.startsWith("10")) return 10;
        if (face.startsWith("J")) return 12;
        if (face.startsWith("Q")) return 13;
        if (face.startsWith("K")) return 14;
        if (face.startsWith("A")) return 15;
        throw new IllegalArgumentException("Invalid card: " + face);

    }
}
