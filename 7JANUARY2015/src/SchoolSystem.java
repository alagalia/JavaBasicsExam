import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/*
 Write a program that reads a list of student grade entries and prints the average grade of every subject for each student.
 */

public class SchoolSystem {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeMap<String, TreeMap<String,List<Double>>> students= new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scan.nextLine().split("\\s+");
            String name = line[0]+" "+ line[1];
            String subject = line[2];
            int grade = Integer.parseInt(line[3]);
            addInfo(students, name, subject, grade);
        }

        //print preparation
        for (String name : students.keySet()) {
            List<String> subjGrades= new ArrayList<>();
            System.out.print(name + ": ");
            for (String subject : students.get(name).keySet()) {
                List<Double> grades= students.get(name).get(subject);
                double avgGrade = takeAverageGreade(grades);
                String forAddInList = String.format(subject+" - %.2f", avgGrade);
                subjGrades.add(forAddInList);
            }
            System.out.println(subjGrades);
        }

    }

    private static double takeAverageGreade(List<Double> grades) {
        double sum = 0;
        for(double d : grades) {
            sum += d;
        }
        return (sum / grades.size());
    }

    private static void addInfo(TreeMap<String, TreeMap<String,List<Double>>> students, String name,String subject, double grade) {
        if (!students.containsKey(name)){
            students.put(name, new TreeMap<>());
        }
        if (!students.get(name).containsKey(subject)){
            students.get(name).put(subject,new ArrayList<>());
        }
        List<Double> grades= students.get(name).get(subject);
        grades.add(grade);
        students.get(name).put(subject, grades);
    }
}
