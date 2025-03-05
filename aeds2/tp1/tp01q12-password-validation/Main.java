import java.util.Scanner;

public class Main {
    public static boolean hasSymbol(String input) {
        String symbols = "!@#$^";
        boolean resp = false;
        
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < symbols.length(); j++) {
                if (input.charAt(i) == symbols.charAt(j)) {
                    resp = true;
                }
            }
        }

        return resp;
    }

    public static boolean hasNumber(String input) {
        String numbers = "0123456789";
        boolean resp = true;
        
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < numbers.length(); j++) {
                if (input.charAt(i) == numbers.charAt(j)) {
                    resp = true;
                }
            }
        }

        return resp;
    }

    public static boolean hasUpperCase(String input) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean resp = true;
        
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < upperCase.length(); j++) {
                if (input.charAt(i) == upperCase.charAt(j)) {
                    resp = true;
                }
            }
        }

        return resp;
    }

    public static boolean isPasswordValid(String input) {
        boolean resp = true;
        
        if (input.length() < 8) {
            resp = false;
        } else {
            if (!hasSymbol(input) || !hasNumber(input) || !hasUpperCase(input)) {
                resp = false;
            }
        }

        return resp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.charAt(0) == 'F' && input.charAt(1) == 'I' && input.charAt(2) == 'M') {
                break;
            }
            
            if (isPasswordValid(input)) {
                System.out.println("SIM");
            } else {
                System.out.println("NÃO");
            }
        } 

        sc.close();
    }
}