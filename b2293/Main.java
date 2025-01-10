import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        dp[0] = 1;
        int[] coins = new int[n];
        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n; i++) {
            for(int j= coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
