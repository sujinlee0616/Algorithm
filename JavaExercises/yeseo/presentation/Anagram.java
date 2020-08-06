package presentation;
import java.util.*;
import java.io.*;
public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int[] ana = new int[52];
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            boolean result = true;

            if (s1.length() != s2.length()) {
                bw.write(s1 + " & " + s2 + " are NOT anagrams.\n");
                continue;
            }

            for (int i = 0; i < s1.length(); i++) {
                int c = s1.charAt(i);
                if (c >= 65 && c <= 90) {
                    ana[c - 65]++;
                } else if (c >= 97 && c <= 122) {
                    ana[c - 71]++;
                }
            }

            for (int i = 0; i < s2.length(); i++) {
                int c = s2.charAt(i);
                if (c >= 65 && c <= 90) {
                    ana[c - 65]--;
                } else if (c >= 97 && c <= 122) {
                    ana[c - 71]--;
                }
            }

            for (int i = 0; i < 52; i++) {
                if (ana[i] != 0) {
                    result = false;
                    break;
                }
            }
            if (result == true) {
                bw.write(s1 + " & " + s2 + " are anagrams.\n");
            } else {
                bw.write(s1 + " & " + s2 + " are NOT anagrams.\n");
            }
        }
        bw.flush();
        bw.close();
    }
}