package Advanced.Generics.GenericScale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scale<String> strScale = new Scale<>("c","b");
        System.out.println(strScale.getHeavier());

        Scale<Integer> intScale = new Scale<>(3,2);
        System.out.println(intScale.getHeavier());
    }

}
