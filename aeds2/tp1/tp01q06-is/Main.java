import java.util.Scanner;

public class Main {
    public static boolean isVogal(String input) {
        String vogals = "aeiou";
        boolean resp = true;

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < vogals.length(); j++) {
                if (input.charAt(i) != vogals.charAt(j)) {
                    resp = false;
                }
            }
        }

        return resp;
    }

    public static boolean isConsoant(String input) {
        String vogals = "aeiou";
        boolean resp = true;

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < vogals.length(); j++) {
                if (input.charAt(i) == vogals.charAt(j)) {
                    resp = false;
                }
            }
        }

        return resp;
    }

    public static boolean isInteger(String input) {
        String numbers = "0123456789";
        boolean resp = false;

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < numbers.length(); j++) {
                if (input.charAt(i) == numbers.charAt(j)) {
                    resp = true;
                }
            }
        }

        return resp;
    }

    public static boolean isReal(String input) {
        boolean resp = isInteger(input);
        return resp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        while (sc.hasNextLine()) {
            input = sc.nextLine();
            String isVogal = isVogal(input) ? "SIM" : "NAO";
            String isConsoant = isConsoant(input) ? "SIM" : "NAO";
            String isInteger = isInteger(input) ? "SIM" : "NAO";
            String isReal = isReal(input) ? "SIM" : "NAO";
            
            System.out.println(isVogal + " " + isConsoant + " " + isInteger + " " + isReal);

        }

        sc.close();
    }
}