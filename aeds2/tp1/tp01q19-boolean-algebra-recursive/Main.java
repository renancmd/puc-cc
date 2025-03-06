import java.util.Scanner;

public class Main {
    public static boolean[] values;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equals("0")) break;
            
            int n = input.charAt(0) - '0';
            values = new boolean[n];

            int j = 0;
            int start = 2 + (2 * n);
            
            for (int i = 2; j < n; i += 2) {
                values[j++] = (input.charAt(i) == '1');
            }
            
            boolean result = evaluateExpression(input, new int[]{start});
            System.out.println(result ? "1" : "0");
        }

        sc.close();
    }

    public static boolean evaluateExpression(String input, int[] index) {
        skipSpaces(input, index);

        char currentChar = input.charAt(index[0]);
        boolean result = false;

        if (currentChar == 'n') {
            index[0] += 4;
            result = !evaluateExpression(input, index);
            index[0]++;
        } else if (currentChar == 'a') {
            index[0] += 4;
            result = processAnd(input, index);
            index[0]++;
        } else if (currentChar == 'o') {
            index[0] += 3;
            result = processOr(input, index);
            index[0]++; 
        } else if (currentChar >= 'A' && currentChar <= 'C') {
            result = values[currentChar - 'A'];
            index[0]++;
        }

        return result;
    }

    public static boolean processAnd(String input, int[] index) {
        boolean result = true;

        while (index[0] < input.length() && input.charAt(index[0]) != ')') {
            result &= evaluateExpression(input, index);
            skipSpaces(input, index);

            if (index[0] < input.length() && input.charAt(index[0]) == ',') {
                index[0]++;
                skipSpaces(input, index);
            }
        }

        return result;
    }

    public static boolean processOr(String input, int[] index) {
        boolean result = false;

        while (index[0] < input.length() && input.charAt(index[0]) != ')') {
            result |= evaluateExpression(input, index);
            skipSpaces(input, index);

            if (index[0] < input.length() && input.charAt(index[0]) == ',') {
                index[0]++;
                skipSpaces(input, index);
            }
        }

        return result;
    }

    public static void skipSpaces(String input, int[] index) {
        while (index[0] < input.length() && input.charAt(index[0]) == ' ') {
            index[0]++;
        }
    }
}
