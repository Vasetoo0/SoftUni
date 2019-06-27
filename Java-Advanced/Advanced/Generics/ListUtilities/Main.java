package Advanced.Generics.ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, 1, 2, 18, 2, -1);

        Integer maxInteger = ListUtils.getMax(nums);

        List<String> str = new ArrayList<>();
        Collections.addAll(str, "a","b","c");

        String minStr = ListUtils.getMin(str);

        System.out.println(maxInteger);
        System.out.println(minStr);
    }

}
