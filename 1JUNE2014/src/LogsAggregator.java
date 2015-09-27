/*
Write a program to aggregate the logs data and print for each user the total duration of his sessions and a list of unique IP addresses in format "<user>: <duration> [<IP1>, <IP2>, …]". Order the users alphabetically. Order the IPs alphabetically.
 */
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeMap<String, Integer> durations= new TreeMap<>();
        TreeMap<String, TreeSet<String>> ipAdres= new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scan.nextLine().split("\\s+");
            String ip = line[0];
            String user = line[1];
            int dur = Integer.parseInt(line[2]);

            AddDuration(durations, user, dur);
            AddIp(ipAdres, user, ip);
        }
        for (String user : ipAdres.keySet()) {
            System.out.print(user);
            System.out.print(": "+durations.get(user)+" ");
            System.out.println(ipAdres.get(user));
        }
        System.out.println();
    }

    private static void AddIp(TreeMap<String, TreeSet<String>> ipAdres, String user, String ip) {
        if (!ipAdres.containsKey(user)){
            ipAdres.put(user, new TreeSet<>());
        }
        ipAdres.get(user).add(ip);
    }

    private static void AddDuration(TreeMap<String, Integer> durations,String user, int dur) {
        if (!durations.containsKey(user)){
            durations.put(user,0);
        }
        durations.put(user, durations.get(user)+dur);
    }
}
