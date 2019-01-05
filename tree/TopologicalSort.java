package algo.ds.tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class TopologicalSort {

	static List<Integer>[] nodes;
	
	// input 
	// n vertex && m edges
	// for each edges x && y vertex connected 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FastReader in = new FastReader(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int vertex = in.nextInt();
		int edges = in.nextInt();
		nodes = new ArrayList[vertex];
		for (int i = 0; i < vertex; i++) {
			nodes[i] = new ArrayList<>();
		}
		for (int i = 0; i < vertex; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			nodes[x].add(y);
		}
		dfs();
		out.flush();
		out.close();

	}

	private static void dfs() {
		int len = nodes.length;
		boolean[] visited = new boolean[len];
		int[] start = new int[len];
		int[] finish = new int[len];
		Stack<Integer> stack = new Stack<>();
		int res = 0;

		for (int j = 0; j < len; j++) {
			if (!visited[j]) {
				res = dfsUtil(j, visited, start, finish, res, stack);
			}
		}
		for (int j = 0; j < len; j++) {
			System.out.println("Vertex " + j + "  " + start[j] + " " + finish[j]);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " -> ");
		}

	}

	private static int dfsUtil(int j, boolean[] visited, int[] start, int[] finish, int res, Stack<Integer> stack) {
		start[j] = ++res;
		visited[j] = true;
		for (int i = 0; i < nodes[j].size(); i++) {
			int u = nodes[j].get(i);
			if (!visited[u]) {
				res = dfsUtil(u, visited, start, finish, res, stack);
			}
		}
		finish[j] = ++res;
		stack.push(j);
		return res;
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
