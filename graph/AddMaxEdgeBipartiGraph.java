package algo.ds.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//input
//	5
//	1 2
//	2 3
//	3 4
//	4 5
//answer : 2

public class AddMaxEdgeBipartiGraph {

	private static List<Integer>[] nodes;
	private static boolean[] vis;
	private static long left = 0;
	private static long right = 0;

	public static void main(String[] args) throws IOException {
		FastReader in = new FastReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		nodes = new ArrayList[n + 1];
		for (int i = 0; i <= n; ++i) {
			nodes[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			nodes[x].add(y);
			nodes[y].add(x);
		}
		vis = new boolean[n + 1];
		dfs(1, 0);
		out.println((left * right) - (n - 1));
		out.flush();
		out.close();

	}

	private static void dfs(int x, int lev) {
		if (lev % 2 == 0) {
			++left;
		} else {
			++right;
		}
		vis[x] = true;
		for (int i = 0; i < nodes[x].size(); ++i) {
			int j = nodes[x].get(i);
			if (!vis[j]) {
				dfs(j, lev + 1);
			}
		}
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

		public int[] nextIntArray(int n) throws IOException {
			int[] ret = new int[n];
			for (int i = 0; i < n; i++) {
				ret[i] = nextInt();
			}
			return ret;
		}

		public long[] nextIntLong(int n) throws IOException {
			long[] ret = new long[n];
			for (int i = 0; i < n; i++) {
				ret[i] = nextLong();
			}
			return ret;
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
