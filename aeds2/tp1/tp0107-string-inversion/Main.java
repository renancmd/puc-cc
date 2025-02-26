import java.util.Scanner;

public class Main {
    public static String stringInversion(String input) {
        String inversion = "";
        int n = input.length();

        for (int i = 1; i <=     n; i++) {
            inversion += input.charAt(n - i);
        }

        return inversion;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        while (sc.hasNextLine()) {
            input = sc.nextLine();
            if (input.charAt(0) == 'F' && input.charAt(1) == 'I' && input.charAt(2) == 'M') {
                break;
            }
            System.out.println(stringInversion(input));
        }

        sc.close();
    }
}