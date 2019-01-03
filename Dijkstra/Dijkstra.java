package algo.ds;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.*;
import java.util.*;

public class Dijkstra {

//	Input                		
//nbVertex nbEdges 									3 2
//foreach nbEdges: 	edges edges weight 				1 2 3	
//													3 1	4	
	
	static List<Nodes>[] nodes;
	static int pred[];

	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("src/test.txt");
		FastReader in = new FastReader(file);
		// FastReader in = new FastReader(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int vertex = in.nextInt();
		int edges = in.nextInt();
		nodes = new ArrayList[vertex + 1];
		pred = new int[vertex + 1];
		for (int i = 1; i <= vertex; i++) {
			nodes[i] = new ArrayList<>();
		}
		for (int i = 0; i < edges; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int d = in.nextInt();
			Nodes n = new Nodes(x, y, d);
			nodes[x].add(n);
		}
		int[] ans = dijkstra(1);

		for (int i = 1; i < ans.length; i++) {
			out.println(i + " " + ans[i]);
		}
		
		out.flush();
		out.close();

	}

	private static int[] dijkstra(int source) {
		// TODO Auto-generated method stub
		int len = nodes.length;
		boolean[] visited = new boolean[len];
		int[] distance = new int[len];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;
		for (int i = 1; i < len; i++) {
			int nextMin = getNextMinimunVertex(distance, visited);
			if (nextMin == -1) {
				continue;
			}
			visited[nextMin] = true;
			for (int j = 0; j < nodes[nextMin].size(); j++) {
				int u = nodes[nextMin].get(j).y;
				int d = distance[nextMin] + nodes[nextMin].get(j).distance;
				if (distance[u] > d) {
					distance[u] = d;
					pred[u] = nextMin;
				}
			}
		}
		return distance;
	}

	private static int getNextMinimunVertex(int[] dist, boolean[] vis) {
		int x = Integer.MAX_VALUE;
		int ret = -1;
		for (int i = 1; i < vis.length; i++) {
			if (!vis[i] && dist[i] < x) {
				x = dist[i];
				ret = i;
			}

		}
		return ret;
	}

	static class Nodes {
		int distance;
		int x;
		int y;

		public Nodes(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
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