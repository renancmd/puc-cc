import java.util.Scanner;

public class Main {
    public static boolean[] values;
    public static int index;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        while (sc.hasNextLine()) {
            input = sc.nextLine();
            int n = input.charAt(0) - '0';
            int j = 0;
            int start = 2 + (2 * n);
            index = start;

            if (input.length() == 1 && input.charAt(0) == '0') break;
            
            values = new boolean[n];
            
            for (int i = 2; j < n; i += 2) {
                values[j++] = (input.charAt(i) == '1');
            }
            
            boolean resp = booleanAlgebra(input);
            System.out.println(resp ? "1" : "0");
        }

        sc.close();
    }

    public static boolean booleanAlgebra(String input) {
        removeSpace(input);
        
        if (input.charAt(index) == 'n') {
            index += 4;
            boolean resp = !booleanAlgebra(input);
            index++;
            return resp;
        }
        
        if (input.charAt(index) == 'a') {
            index += 4;
            boolean resp = and(input);
            index++;
            return resp;
        }
        
        if (input.charAt(index) == 'o') {
            index += 3;
            boolean resp = or(input);
            index++;
            return resp;
        }
        
        if (input.charAt(index) >= 'A' && input.charAt(index) <= 'C') {
            return values[input.charAt(index++) - 'A'];
        }
        
        return false;
    }

    public static boolean and(String input) {
        boolean resp = true;

        while (index < input.length() && input.charAt(index) != ')') {
            resp &= booleanAlgebra(input);
            removeSpace(input);

            if (index < input.length() && input.charAt(index) == ',') {
                index++;
                removeSpace(input);
            }
        }

        return resp;
    }

    public static boolean or(String input) {
        boolean resp = false;

        while (index < input.length() && input.charAt(index) != ')') {
            resp |= booleanAlgebra(input);
            removeSpace(input);

            if (index < input.length() && input.charAt(index) == ',') {
                index++;
                removeSpace(input);
            }
        }
        
        return resp;
    }

    public static void removeSpace(String input) {
        while (index < input.length() && input.charAt(index) == ' ') {
            index++;
        }
    }
}
