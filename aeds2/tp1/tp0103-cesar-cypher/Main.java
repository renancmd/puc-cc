import java.util.Scanner;

public class Main {
    public static String caesarCipher(String msg) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String decimal = "0123456789";
        String cipher = "";
        int n = msg.length();

        for (int i = 0; i < n; i++) {
            char currentChar = msg.charAt(i);
            boolean isUpperCase = Character.isUpperCase(currentChar);
            boolean found = false;
            for (int j = 0; j < alphabet.length(); j++) {
                if (Character.toLowerCase(currentChar) == alphabet.charAt(j)) {
                    int shiftPosition = j + 3;
                    shiftPosition %= alphabet.length();
                    char shiftedChar = alphabet.charAt(shiftPosition);
                    cipher += isUpperCase ? Character.toUpperCase(shiftedChar) : shiftedChar;
                    found = true;
                    break;
                }
            }

            for (int k = 0; k < decimal.length(); k++) {
                if (currentChar == decimal.charAt(k)) {
                    if (currentChar == '7') {
                        cipher += ":";
                    } else if (currentChar == '8') {
                        cipher += ";";
                    } else if (currentChar == '9') {
                        cipher += "<";
                    } else {
                        int shiftPosition = k + 3;
                        currentChar = decimal.charAt(shiftPosition);
                        cipher += currentChar;
                    }
                    found = true;
                    break;
                }
            }

            if (currentChar == ' ') {
                cipher += "#";
            } else if (currentChar == '-') {
                cipher += "0";
            } else if (currentChar == '.') {
                cipher += "1";
            } else if (currentChar == ',') {
                cipher += "/";
            } else if (currentChar == '(') {
                cipher += "+";
            } else if (currentChar == ')') {
                cipher += ",";
            } else if (currentChar == '!') {
                cipher += "$";
            } else if (currentChar == '?') {
                cipher += "B";
            } else if (currentChar == ':') {
                cipher += "=";
            } else if (!found) {
                cipher += currentChar;
            } else if (currentChar == '&') {
                cipher += ")";
            } else if (currentChar == ';') {
                cipher += ">";
            } else if (currentChar == '-') {
                cipher += "0";
            }

        }
        return cipher;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message;

        // System.out.println(caesarCipher(message));

        while (sc.hasNextLine()) {
            message = sc.nextLine();
            System.out.println(caesarCipher(message));
        }

        sc.close();
    }
}
