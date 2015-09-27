import java.util.*;
/*You are given an input in the format:
IP=(IP.Address) message=(A&sample&message) user=(username)
Your task is to parse the ip and the username from the input and for every user, you have to display every ip from which the corresponding user has sent a message and the count of the messages sent with the corresponding ip. In the output, the usernames must be sorted alphabetically while their IP addresses should be displayed in the order of their first appearance.
*/
public class UserLogs {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> log = new TreeMap<>();

        while (!line.equals("end")) {

            String[] elements = line.split(" ");
            String ip = take(elements[0]);
            String msg = take(elements[1]);
            String user = take(elements[2]);

            if (!log.containsKey(user)){
                log.put(user, new LinkedHashMap<>());
            }
            if (!log.get(user).containsKey(ip)){
                log.get(user).put(ip,0);
            }
            log.get(user).put(ip,log.get(user).get(ip)+1);
            line = scan.nextLine();
        }

        printInfo(log);
    }


    private static void printInfo(TreeMap<String, LinkedHashMap<String, Integer>> log) {
        for (String user : log.keySet()) {
            System.out.println(user + ":");
            List<String> infoIP = new ArrayList<>();
            for (String ip : log.get(user).keySet()) {
                infoIP.add(ip+" => "+log.get(user).get(ip));
            }
            System.out.print(infoIP.toString().substring(1,infoIP.toString().length()-1));
            System.out.println(".");
        }
    }

    private static String take(String element) {
        int index = element.indexOf("=");
        return element.substring(index+1);
    }
}
