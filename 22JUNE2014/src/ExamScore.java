import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Dell on 2.10.2015 ã..
 */
public class ExamScore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            scan.nextLine(); scan.nextLine(); scan.nextLine();
        String[] element = scan.nextLine().split("\\s*\\|\\s*");
        TreeMap<Integer, TreeMap<String , Double>> info = new TreeMap<>();
        while (element.length==4){
            String name = element[1];
            int score = Integer.parseInt(element[2]);
            double grade = Double.parseDouble(element[3]);
            addInfo(info, name, score, grade);
            element = scan.nextLine().split("\\s*\\|\\s*");
        }
        printInfo(info);
    }

    private static void printInfo(TreeMap<Integer, TreeMap<String, Double>> info) {
        for (Integer score : info.keySet()) {
            System.out.printf(score+" -> ");
            List names= new ArrayList<>();
            double sumGrades=0;
            for (String name : info.get(score).keySet()) {
                names.add(name);
                sumGrades+=info.get(score).get(name);
            }
            double grade = sumGrades/info.get(score).keySet().size();
            System.out.print(names);
            System.out.printf("; avg=%.2f", grade);
            System.out.println();
        }
    }

    private static void addInfo(TreeMap<Integer, TreeMap<String, Double>> info, String name, int score, double grade) {
        if (!info.containsKey(score)){
            info.put(score, new TreeMap<>());
        }
        if (!info.get(score).containsKey(name)){
            info.get(score).put(name, grade);
        }
    }
}
