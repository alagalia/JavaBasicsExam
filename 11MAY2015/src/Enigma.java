/*
You are given N lines of encrypted messages.
The messages will contain ASCII characters.
In each message, only the Latin letters and special characters will be encrypted.
The numbers and whitespace will not be encrypted.
Your task is to write a program to decrypt the messages.
The formula for the decrypting each letter is X = k + m, where X is the ASCII code of the decrypted letter,
k is the ASCII code of the encrypted character and m is the integer half of the length of the input line,
without the numbers and whitespace.
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Enigma {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            int count = GetNumberOfDigsAndWhiteSpaces(line);
            int m = (line.length()-count)/2;
            StringBuilder sb= new StringBuilder();
            for (int j = 0; j < line.length(); j++) {
                char ch=line.charAt(j);
                if(Character.isDigit(ch)){
                    sb.append(ch);
                    continue;
                }
                if (ch!=' '){
                    int k = (int)ch;
                    int x=k+m;
                    sb.append(Character.toString ((char) x));
                } else {
                    sb.append(ch);
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static int GetNumberOfDigsAndWhiteSpaces(String line) {
        String paternWhiteSpaceDig= "[\\d|\\s]";
        Pattern pat=Pattern.compile(paternWhiteSpaceDig);
        Matcher m = pat.matcher(line);
        int count = 0;
        while (m.find()) {
            count++;
        }
        return count;
    }
}
