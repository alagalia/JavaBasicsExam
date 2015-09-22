/*
You are given a line of usernames, between one of the following symbols: space, “/”, “\”, “(“, “)”. First you have to export all valid usernames. A valid username starts with a letter and can contain only letters, digits and “_”. It cannot be less than 3 or more than 25 symbols long. Your task is to sum the length of every 2 consecutive valid usernames and print on the console the 2 valid usernames with biggest sum of their lengths, each on a separate line.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        String regex = "\\b(?!\\d)(\\w{3,25})\\b";
        Pattern pat= Pattern.compile(regex);
        Matcher matcher= pat.matcher(line);
        List<String> names = new ArrayList<>();

        while (matcher.find()){
            names.add(matcher.group());
        }

        String [] name = names.toArray(new String[names.size()]);

        int maxLenght=0;
        int index=0;
        for (int i = 0; i < name.length-1; i++) {
            int firstName=name[i].length();
            int secondName=name[i+1].length();
            int lenght=firstName+secondName;
            if (lenght>maxLenght){
                maxLenght=lenght;
                index=i;
            }
        }
        System.out.println(name[index]);
        System.out.println(name[index+1]);
    }
}
