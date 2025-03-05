import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String fetchHtml(String urlString) throws Exception {
        StringBuilder content = new StringBuilder();
        URL url = new URI(urlString).toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public static int countOccurrences(String text, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        int count = 0;
        while (m.find())
            count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pageName;
        
        do {
            pageName = scanner.nextLine();
            if (pageName.equals("FIM")) break;
            String url = scanner.nextLine();

            try {
                String htmlContent = fetchHtml(url).toLowerCase();
                int[] counts = new int[26];
                String[] patterns = { "a", "e", "i", "o", "u", "á", "é", "í", "ó", "ú", "à", "è", "ì", "ò", "ù", "ã",
                        "õ", "â", "ê", "î", "ô", "û" };

                for (int i = 0; i < patterns.length; i++) {
                    counts[i] = countOccurrences(htmlContent, patterns[i]);
                }

                counts[22] = countOccurrences(htmlContent, "[bcdfghjklmnpqrstvwxyz]");
                counts[23] = countOccurrences(htmlContent, "<br>");
                counts[24] = countOccurrences(htmlContent, "<table>");

                for (int i = 0; i < 22; i++) {
                    System.out.printf("%s(%d) ", patterns[i], counts[i]);
                }
                
                System.out.printf("consoante(%d) <br>(%d) <table>(%d) %s\n", counts[22], counts[23], counts[24],
                        pageName);
            } catch (Exception e) {
                System.err.println("Erro ao processar " + url);
            }
        } while (true);
        
        scanner.close();
    }
}
