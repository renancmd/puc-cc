import java.util.Scanner;

public class Main {
    public static boolean isPalindrome(String input, int left, int right) {
        boolean resp;

        if (left >= right) {
            resp = true;
        } else if (input.charAt(left) != input.charAt(right)) {
            resp = false;
        } else {
            resp = isPalindrome(input, left + 1, right - 1);
        }

        return resp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.nextLine();
            boolean result = isPalindrome(input, 0, input.length() - 1);
            if (result) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        }
        
        sc.close();
    }
}