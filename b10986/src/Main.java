import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nm = new String[2];
		nm = bf.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int[] arr = new int[n + 1];
		String[] line = new String[n];
		line = bf.readLine().split(" ");
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(line[i - 1]);
		}
	
		long[] acc = new long[n + 1];
		acc[1] = arr[1];
		for(int i = 1; i <= n; i++) {
			acc[i] = acc[i - 1] + arr[i];
		}
		
		long[][] memo = new long[n + 1][n + 1];
		int count = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n - (i - 1); j++) {
				memo[i][j] = acc[j + i - 1] - acc[j - 1];
				if(memo[i][j] % m == 0) { count++; }
			}
		}
		bw.write(Integer.toString(count));
		bw.close();
	}
}