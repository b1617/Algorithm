package algo.ds.kadane;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Kadane {
	// input : list of positive && negative number : ex : 1 -2 4 -3 5
	// Maximum sub array with negative and positive integer
	// O(n)
	public static void main(String[] args) throws IOException {
		FastReader in = new FastReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		out.println(kadane(arr));
		out.flush();
		out.close();

	}

	private static int kadane(int[] arr) {
		int maxGlobal = arr[0];
		int maxCurrent = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
			maxGlobal = Math.max(maxCurrent, maxGlobal);
		}
		return maxGlobal;

	}

	static class FastReader {
		StringTokenizer st;
		BufferedReader br;

		public FastReader(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public FastReader(FileReader fileReader) {
			br = new BufferedReader(fileReader);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

}