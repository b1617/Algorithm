package algo.ds.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class CycleDetectionGraph {
// Directed Graph -> DFS and Stack : Return true if visited &&  present in the Stack
	public static LinkedList<Integer>[] nodes;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FastReader in = new FastReader(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int vertex = in.nextInt();
		int edges = in.nextInt();
		nodes = new LinkedList[vertex + 1];
		for (int i = 1; i <= vertex; i++) {
			nodes[i] = new LinkedList<>();
		}
		for (int i = 0; i < edges; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			nodes[x].add(y);
			nodes[y].add(x);
		}
		out.println(isCyclicUndirectedGraph() ? "YES" : "NO");
		out.println(isCyclicDirectedGraph() ? "Yes" : "Nos");
		out.flush();
		out.close();

	}

	private static boolean isCyclicUndirectedGraph() {
		// TODO Auto-generated method stub
		int len = nodes.length;
		boolean[] visited = new boolean[len];
		for (int j = 1; j < len; j++) {
			if (!visited[j]) {
				if (isCyclicUndirectedGraphUtil(j, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isCyclicUndirectedGraphUtil(int j, boolean[] visited, int parent) {
		// TODO Auto-generated method stub
		visited[j] = true;
		for (int k = 0; k < nodes[j].size(); k++) {
			int x = nodes[j].get(k);
			if (!visited[x]) {
				if (isCyclicUndirectedGraphUtil(x, visited, j)) {
					return true;
				}
			} else if (x != parent) {
				System.out.println(x + " " + parent);
				return true;
			}
		}
		return false;
	}

	private static boolean isCyclicDirectedGraph() {
		int len = nodes.length;
		boolean[] visited = new boolean[len];
		boolean[] stack = new boolean[len];
		for (int i = 1; i < len; i++) {
			if (!visited[i]) {
				if (isCyclicDirectedGraphUtil(i, visited, stack)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean isCyclicDirectedGraphUtil(int i, boolean[] visited, boolean[] stack) {
		if (!visited[i]) {
			visited[i] = true;
			stack[i] = true;
			for (int j = 0; j < nodes[i].size(); j++) {
				int x = nodes[i].get(j);
				if (!visited[x]) {
					if (isCyclicDirectedGraphUtil(x, visited, stack)) {
						return true;
					}
				} else {
					if (stack[x]) {
						return true;
					}
				}
			}
		}
		stack[i] = false;
		return false;
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
