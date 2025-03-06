import java.util.Scanner;

public class Main {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String DECIMAL = "0123456789";
    
    public static String caesarCipher(String msg) {
        return caesarCipherHelper(msg, 0);
    }
    
    private static String caesarCipherHelper(String msg, int index) {
        if (index >= msg.length()) {
            return "";
        }

        char currentChar = msg.charAt(index);
        boolean isUpperCase = Character.isUpperCase(currentChar);
        char transformedChar = transformCharacter(Character.toLowerCase(currentChar), isUpperCase);

        return transformedChar + caesarCipherHelper(msg, index + 1);
    }

    private static char transformCharacter(char ch, boolean isUpperCase) {
        if (ALPHABET.indexOf(ch) != -1) {
            int shiftPosition = (ALPHABET.indexOf(ch) + 3) % ALPHABET.length();
            char shiftedChar = ALPHABET.charAt(shiftPosition);
            return isUpperCase ? Character.toUpperCase(shiftedChar) : shiftedChar;
        }
        
        if (DECIMAL.indexOf(ch) != -1) {
            return switch (ch) {
                case '7' -> ':';
                case '8' -> ';';
                case '9' -> '<';
                default -> DECIMAL.charAt((DECIMAL.indexOf(ch) + 3) % DECIMAL.length());
            };
        }
        
        return switch (ch) {
            case ' ' -> '#';
            case '-' -> '0';
            case '.' -> '1';
            case ',' -> '/';
            case '(' -> '+';
            case ')' -> ',';
            case '!' -> '$';
            case '?' -> 'B';
            case ':' -> '=';
            case '&' -> ')';
            case ';' -> '>';
            default -> ch;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println(caesarCipher(sc.nextLine()));
        }
        sc.close();
    }
}
