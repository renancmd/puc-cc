import java.util.Scanner;

public class Main {

    public static boolean isAnagram(String word1, String word2) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String sortWord1 = "", sortWord2 = "";
        boolean resp = true;

        String w1 = word1.toLowerCase();
        String w2 = word2.toLowerCase();

        for (int i = 0; i < alphabet.length(); i++) {
            for (int j = 0; j < w1.length(); j++) {
                if (w1.charAt(j) == alphabet.charAt(i)) {
                    sortWord1 += w1.charAt(j);
                }
                if (w2.charAt(j) == alphabet.charAt(i)) {
                    sortWord2 += w2.charAt(j);
                }
            }
        }

        for (int j = 0; j < sortWord1.length(); j++) {
            if (sortWord1.charAt(j) != sortWord2.charAt(j)) {
                resp = false;
                break;
            }
        }

        return resp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String word1 = "", word2 = "";
            String input = sc.nextLine();
            int pos = 0;

            if (
                input.charAt(0) == 'F' &&
                input.charAt(1) == 'I' &&
                input.charAt(2) == 'M'
            ) {
                break;
            }

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) != ' ') {
                    word1 += input.charAt(i);
                } else {
                    pos = i + 3;
                    break;
                }
            }

            for (int j = pos; j < input.length(); j++) {
                word2 += input.charAt(j);
            }

            if (word1.length() == word2.length()) {
                boolean resp = isAnagram(word1, word2);
                if (resp) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            } else {
                System.out.println("SIM");
            }
        }

        sc.close();
    }
}
