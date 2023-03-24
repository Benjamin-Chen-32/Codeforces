import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class Interview {
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
 
        StringTokenizer tk = new StringTokenizer(in.readLine());
        int t = Integer.parseInt(tk.nextToken());
 
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(in.readLine());
            tk = new StringTokenizer(in.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(tk.nextToken());
            }
            int[] prefix = new int[n];
            prefix[0] = a[0];
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] + a[i];
            }
            int l = 0;
            int r = n;
            while (l < r) {
                int mid = (l / 2) + (r / 2) + ((l % 2 + r % 2) / 2);
                out.print("? " + (mid + 1));
                for (int i = 1; i <= mid + 1; i++) {
                    out.print(" " + i);
                }
                out.println();
                out.flush();
                int resp = Integer.parseInt(in.readLine());
                if (resp != prefix[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            out.println("! " + (l + 1));
            out.flush();
        }
 
        in.close();
        out.close();
    }
}