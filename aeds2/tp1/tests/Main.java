import java.util.Scanner;

public class Main {

    // public static void isAnagram(String word1, String word2) {
    //     String alphabet = "abcdefghijklmnopqrstuvwxyz";
    //     String sortWord1 = "", sortWord2 = "";
    //     // boolean resp = false;

    //     word1.toLowerCase();
    //     word2.toLowerCase();

    //     if (word1.length() == word2.length()) {
    //         for (int i = 0; i < alphabet.length(); i++) {
    //             for (int j = 0; j < word1.length(); j++) {
    //                 if (word1.charAt(j) == alphabet.charAt(i)) {
    //                     sortWord1 += word1.charAt(j);
    //                 } else if (word2.charAt(j) == alphabet.charAt(i)) {
    //                     sortWord2 += word2.charAt(j);
    //                 }
    //             }
    //         }
    //     }

    //     if (sortWord1 == sortWord2) {
    //         System.out.println(sortWord1 + " " + sortWord2);
    //     }
    //     // return resp;
    // }

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

            System.out.println(word1 + " " + word2);
            // isAnagram(word1, word2);
            // if (resp) {
            //     System.out.println("SIM");
            // } else {
            //     System.out.println("NAO");
            // }
        }

        sc.close();
    }
}
