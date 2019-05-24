package Advanced.StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BrowserHistory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> URLstack = new ArrayDeque<>();

        String input;

        while (!"Home".equalsIgnoreCase(input = reader.readLine())) {

            if(!"back".equalsIgnoreCase(input)) {

                URLstack.push(input);
                System.out.println(input);
            } else {

                if(URLstack.size() > 1) {
                    URLstack.pop();
                    System.out.println(URLstack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }
        }
    }

}
