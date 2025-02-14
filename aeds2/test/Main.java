import java.util.Scanner;

public class Main {
    public static boolean palindrome(String value) {
        int valueSize = value.length() - 1;
        boolean resp = false;
        String symbols = "!@#$%¨&*-'`~^";

        for (int i = 1; i <= valueSize; i++) {
            for (int j = 1; j <= symbols.length() -1 ; j++) {
                if (value.charAt(i) == symbols.charAt(j)) {
                    System.out.println(value.charAt(i));
                }
            }

            if (value.charAt(i) != value.charAt(valueSize - i)) {
                resp = false;
            } else {
                resp = true;
            }
        }
        return resp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value;

        while (sc.hasNext()) {
            value = sc.nextLine();

            if (palindrome(value)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        }

        sc.close();
    }
}