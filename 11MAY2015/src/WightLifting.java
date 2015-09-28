import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class WightLifting {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeMap<String, TreeMap<String,Long>> players= new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scan.nextLine().split("\\s+");
            String name = line[0];
            String exercise = line[1];
            Long weight = Long.parseLong(line[2]);
            addInfo(players, name,exercise,weight);
        }

        //print result
        for (String name : players.keySet()) {
            System.out.print(name+" : ");
            List<String> allExarcises= new LinkedList<>();
            for (String exercise : players.get(name).keySet()) {
                allExarcises.add(String.format("%s - %d kg", exercise, players.get(name).get(exercise)));
            }
            String [] exercisesAsArray = allExarcises.toArray(new String[allExarcises.size()]);
            System.out.println(String.join(", ", exercisesAsArray));

        }
    }


    private static void addInfo(TreeMap<String, TreeMap<String,Long>> players, String name,String exercise, Long weight) {
        if (!players.containsKey(name)){
            players.put(name, new TreeMap<>());
        }
        if (!players.get(name).containsKey(exercise)){
            players.get(name).put(exercise,0l);
        }
        players.get(name).put(exercise, players.get(name).get(exercise)+weight);
    }
}
