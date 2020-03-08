package Advanced.SetsAndMaps;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String, List<String>>> userLogs = new TreeMap<>();

        String input;

        while (!"end".equals(input = scanner.nextLine())) {

            String[] data = input.split("\\s+");
            String[] ipInfo = data[0].split("=");
            String[] messageInfo = data[1].split("=");
            String[] userInfo = data[2].split("=");

            String ip = ipInfo[1];
            String message = messageInfo[1];
            String user = userInfo[1];

            if(!userLogs.containsKey(user)) {
                userLogs.put(user, new LinkedHashMap<>());
                userLogs.get(user).put(ip, new ArrayList<>());
                userLogs.get(user).get(ip).add(message);
            } else {
                if(!userLogs.get(user).containsKey(ip)) {
                    userLogs.get(user).put(ip, new ArrayList<>());
                    userLogs.get(user).get(ip).add(message);
                } else {
                    userLogs.get(user).get(ip).add(message);
                }
            }
        }
        userLogs.forEach((key,value) -> {
            System.out.println(key + ":");
            int counter = 0;
            for (Map.Entry<String, List<String>> kvp : value.entrySet()) {
                if(counter++ < value.size() - 1) {
                    System.out.print(String.format("%s => %s, ",kvp.getKey(), kvp.getValue().size()));
                } else {
                    System.out.println(String.format("%s => %s.",kvp.getKey(), kvp.getValue().size()));
                }
            }
        });
    }
}
