import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "numbers.txt";

        try (RandomAccessFile file = new RandomAccessFile(filename, "rw")) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                double value = sc.nextDouble();
                file.writeDouble(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
            sc.close();
            return;
        }

        try (RandomAccessFile file = new RandomAccessFile(filename, "r")) {
            long fileSize = file.length();
            long position = fileSize - 8;

            while (position >= 0) {
                file.seek(position);
                double value = file.readDouble();
                System.out.println(value);
                position -= 8;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
