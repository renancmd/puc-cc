import java.util.Scanner;

public class Main {
    public static int longestSubstring(String input) {
        int n = 0;

        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                boolean isRep = false;
                for (int k = i; k < j; k++) {
                    if (input.charAt(j) == input.charAt(k)) {
                        isRep = true;
                        break;
                    }
                }
                if (isRep) {
                    break;
                } else {
                    int tamanhoAtual = j - i + 1;
                    if (tamanhoAtual > n) {
                        n = tamanhoAtual;
                    }
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.charAt(0) == 'F' && input.charAt(1) == 'I' && input.charAt(2) == 'M') {
                break;
            }

            System.out.println(longestSubstring(input));
        }

        sc.close();
    }
}