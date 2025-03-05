import java.util.Scanner;

public class Main {
    public static boolean palindrome(String value) {
        int valueSize = value.length() - 1;
        boolean resp = false;

        for (int i = 1; i <= valueSize; i++) {
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