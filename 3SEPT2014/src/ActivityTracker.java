import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class ActivityTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<Integer, TreeMap<String,Integer >> info = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] element = scanner.nextLine().split(" ");
            int month = Integer.parseInt(element[0].substring(3, 5));
            String name = element[1];
            int meters = Integer.parseInt(element[2]);
            addInfo(info, month,name,meters);
        }
        printInfo(info);
    }

    private static void printInfo(TreeMap<Integer, TreeMap<String, Integer>> info) {
        for (Integer month : info.keySet()) {
            List<String> names= new ArrayList<>();
            for (String name : info.get(month).keySet()) {
                String forAdd = name+"("+info.get(month).get(name)+")";
                names.add(forAdd);
            }
            System.out.print(month+": ");
            System.out.println(String.join(", ", names));
        }

    }

    private static void addInfo(TreeMap<Integer, TreeMap<String, Integer>> info, int month, String name, int meters) {
        if (!info.containsKey(month)){
            info.put(month, new TreeMap<>());
        }
        if (!info.get(month).containsKey(name)){
            info.get(month).put(name,0);
        }
        info.get(month).put(name,info.get(month).get(name)+ meters);
    }
}
