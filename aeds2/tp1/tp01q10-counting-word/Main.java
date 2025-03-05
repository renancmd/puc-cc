import java.util.Scanner;

public class Main {

    public static int countingWords(String input) {
        int counter = 1;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String input = sc.nextLine();

            if (
                input.charAt(0) == 'F' &&
                input.charAt(1) == 'I' &&
                input.charAt(2) == 'M'
            ) {
                break;
            }

            System.out.println(countingWords(input));
        }

        sc.close();
    }
}
