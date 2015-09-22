/*
You are given a sequence of n companies in format |<company> - <amount> - <product>|.
Write a program that prints all companies in alphabetical order.
For each company print the product type and their aggregated ordered amounts.
Order the products by order of appearance.
Print the result in the following format: <company>: <product>-<amount>, <product>-<amount>,…
 */
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OfficeStuff {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String regex = "\\b([A-Za-z0-9]+)\\b";
        Pattern pat= Pattern.compile(regex);

        Map<String, LinkedHashMap<String, Integer>> all = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String line = scanner.nextLine();
            Matcher matcher= pat.matcher(line);

            matcher.find();
            String companyName = matcher.group();
            matcher.find();
            int amount = Integer.parseInt(matcher.group());
            matcher.find();
            String product = matcher.group();


            if (!all.containsKey(companyName)){
                LinkedHashMap<String, Integer> order = new LinkedHashMap<>();
                order.put(product,amount);
                all.put(companyName,order);
            }else{
                if (!all.get(companyName).containsKey(product)){
                    all.get(companyName).put(product,amount);
                } else {
                    int currentAmount = all.get(companyName).get(product);
                    all.get(companyName).put(product,currentAmount+amount);
                }
            }
        }
        for (String s : all.keySet()) {
            System.out.print(s);
            System.out.print(": ");
            List<String> productForJoin= new LinkedList<>();
            for (String product : all.get(s).keySet()) {
                productForJoin.add(String.format("%s-%d", product, all.get(s).get(product)));
            }
            String [] products = productForJoin.toArray(new String[productForJoin.size()]);
            System.out.println(String.join(", ", products));
        }
    }
}

