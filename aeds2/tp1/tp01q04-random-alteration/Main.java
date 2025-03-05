import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String randomAlteration(String input, Random gerador) {
        String newText = "";
        char letter1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
        char letter2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == letter1) {
                newText += letter2;
            } else {
                newText += input.charAt(i);
            }
        }

        return newText;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random gerador = new Random();
        String input;
        gerador.setSeed(4);

        while (sc.hasNextLine()) {
            input = sc.nextLine();
            if (input.charAt(0) == 'F' && input.charAt(1) == 'I' && input.charAt(2) == 'M') {
                break;
            }
            System.out.println(randomAlteration(input, gerador));
        }

        sc.close();

    }
}