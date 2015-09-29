import java.util.*;
/*
You are given a sequence of n companies in format <company> <nuts> <amount>.Write a program that prints all companies by name alphabetically. For each company print the type of nuts they ordered and sum the ordered amounts. Order the nuts by order of appearance. Print the result in the following format: <company>: <nut> <amount>kg, <nut> <amount>kg,…
 */
public class Nuts {

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeMap<String, LinkedHashMap<String,Integer>> companies= new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scan.nextLine().split("\\s+");
            String company = line[0];
            String nuts = line[1];
            String quantityAsString = line[2].replace("kg","");
            Integer quantity = Integer.parseInt(quantityAsString);
            addInfo(companies, company,nuts,quantity);
        }

        //print result
        for (String name : companies.keySet()) {
            System.out.print(name+": ");
            List<String> allExarcises= new LinkedList<>();
            for (String exercise : companies.get(name).keySet()) {
                allExarcises.add(String.format("%s-%dkg", exercise, companies.get(name).get(exercise)));
            }
            String [] exercisesAsArray = allExarcises.toArray(new String[allExarcises.size()]);
            System.out.println(String.join(", ", exercisesAsArray));

        }

    }

    private static void addInfo(TreeMap<String, LinkedHashMap<String,Integer>> players, String name,String exercise, Integer weight) {
        if (!players.containsKey(name)){
            players.put(name, new LinkedHashMap<>());
        }
        if (!players.get(name).containsKey(exercise)){
            players.get(name).put(exercise,0);
        }
        players.get(name).put(exercise, players.get(name).get(exercise)+weight);
    }
}
