/*
The game uses a standard deck of 52 cards.
The card faces are: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K and A.
The cards suits are denoted by the letters S (spades), H (hearts), D (diamonds) and C (clubs).
The player is given a hand of cards, a string (“odd” or “even”), and a magic card.
You need to count the sum of all cards at odd or even positions (positions start from 0).
Card values are the following: 2 -> 20, 3 -> 30, 4 -> 40, 5 -> 50, 6 -> 60, 7 -> 70, 8 -> 80, 9 -> 90, 10 -> 100, J -> 120, Q -> 130, K -> 140, A -> 150.
When a card’s suit is the same as the suit of the magic card its value is doubled.
When a card’s face is the same as the face of the magic card its value is tripled.
The input hand will not contain the magic card.
 */
import java.util.Scanner;

public class MagicCard {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        String oddEven=scanner.nextLine();
        String magic =scanner.nextLine();

        int add=0;
        if (oddEven.equals("odd")){
            add= 1;
        }

        String magicface=magic.substring(0, magic.length()-1);
        String magicSuit=magic.substring(magic.length()-1);

        int total =0;
        for (int i = add; i < line.length; i+=2) {
            String face = line[i].substring(0, line[i].length()-1);
            String suit = line[i].substring(line[i].length() - 1);

            boolean isFaceMatch = magicface.equals(face);
            boolean isSuitMatch= magicSuit.equals(suit);

            int cardValue = TakeCardValue(face);
            if (isFaceMatch){
                cardValue*=3;
            }
            if (isSuitMatch) {
                cardValue *= 2;
            }
            total+=cardValue;
        }
        System.out.println(total);
    }

    private static int TakeCardValue(String face) {
        switch (face){
            case "2": return 20;
            case "3": return 30;
            case "4": return 40;
            case "5": return 50;
            case "6": return 60;
            case "7": return 70;
            case "8": return 80;
            case "9": return 90;
            case "10": return 100;
            case "J": return 120;
            case "Q": return 130;
            case "K": return 140;
            case "A": return 150;
        }
        return 0;
    }
}
