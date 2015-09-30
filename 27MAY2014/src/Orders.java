import java.util.*;
/*
    You are given a sequence of n orders in format <customer> <amount> <product>.
    Write a program that prints all products in the order of their first appearance.
    For each product print the customers and their aggregated ordered amounts.
    Order the customers by name alphabetically.
    Print the result in the following format: <product>: <customer> <amount>, <customer> <amount>, …
     For each product print the customers ordered this product in alphabetical order.
*/
public class Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); scanner.nextLine();

        LinkedHashMap<String, TreeMap<String, Integer>> all = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            String name = line[0];
            int quantity = Integer.parseInt(line[1]);
            String product = line[2];
            addInfo(all,name,quantity,product);
        }

        printInfo(all);

    }

    private static void printInfo(LinkedHashMap<String, TreeMap<String, Integer>> all) {
        for (String s : all.keySet()) {
            System.out.print(s);
            System.out.print(": ");
            List<String> productForJoin= new LinkedList<>();
            for (String product : all.get(s).keySet()) {
                productForJoin.add(String.format("%s %d", product, all.get(s).get(product)));
            }
            String [] products = productForJoin.toArray(new String[productForJoin.size()]);
            System.out.println(String.join(", ", products));
        }
    }

    private static void addInfo(LinkedHashMap<String, TreeMap<String, Integer>> all, String name, int quantity, String product) {
        if (!all.containsKey(product)){
            all.put(product, new TreeMap<>());
        }
        if (!all.get(product).containsKey(name)){
            all.get(product).put(name,0);
        }
        all.get(product).put(name, all.get(product).get(name)+quantity);
    }
}
