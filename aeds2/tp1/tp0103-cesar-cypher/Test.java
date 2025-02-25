import java.util.Scanner;

public class Test {
    public static String caesarCipher(String msg) {
        String decimal = "0123456789";
        String cipher = "";
        
        for (int i = 0; i < msg.length(); i++) {
            char currentChar = msg.charAt(i);
            for (int k = 0; k < decimal.length(); k++) {
                if (currentChar == decimal.charAt(k)) {
                    char shiftedChar = currentChar;
                    if (shiftedChar == '7') {
                        cipher += ":";
                    } else if (shiftedChar == '8') {
                        cipher += ";";
                    } else if (shiftedChar == '9') {
                        cipher += "<";
                    } else {
                        int shiftPosition = k + 3;
                        shiftedChar = decimal.charAt(shiftPosition);
                        cipher += shiftedChar;
                        break;
                    }
                }
            }
        }
        return cipher;
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = "123";

        System.out.println(caesarCipher(message));

        sc.close();
    }
}