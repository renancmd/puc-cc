import java.util.Scanner;

public class Main {

    public static int sumDigits(String input) {
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            result += input.charAt(i) - '0';
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        while (sc.hasNextLine()) {
            input = sc.nextLine();

            if (
                input.charAt(0) == 'F' &&
                input.charAt(1) == 'I' &&
                input.charAt(2) == 'M'
            ) {
                break;
            }

            System.out.println(sumDigits(input));
        }

        sc.close();
    }
}
