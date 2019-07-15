package OOP.InterfaceAndAbstraction.Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        for (String number : numbers) {
            if (isValidNumber(number)) {
                return "Calling... " + number;
            }
        }
        return "Invalid number!";
    }

    @Override
    public String browse() {
        for (String url : urls) {
            if(isValidUrl(url)) {
                return "Browsing: " + url + "!";
            }
        }
        return "Invalid URL!";
    }

    private boolean isValidUrl(String url) {
        for (int i = 0; i < url.length(); i++) {
            if(Character.isDigit(url.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
