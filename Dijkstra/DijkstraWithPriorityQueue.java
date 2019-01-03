package algo.ds;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.*;
import java.util.*;

public class DijkstraWithPriorityQueue {
	
//	Input                		
//nbVertex nbEdges 									3 2
//foreach nbEdges: 	edges edges weight 				1 2 3	
//													3 1	4			

	static List<Node>[] nodes;

	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("src/test.txt");
		FastReader in = new FastReader(file);
		// FastReader in = new FastReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int vertex = in.nextInt();
		int edges = in.nextInt();
		nodes = new ArrayList[vertex + 1];
		for (int i = 1; i <= vertex; i++) {
			nodes[i] = new ArrayList<>();
		}
		for (int i = 1; i <= edges; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int w = in.nextInt();
			Node n = new Node(y, w);
			Node m = new Node(x, w);
			nodes[x].add(n);
			nodes[y].add(m);
		}
		int[] val = dijkstra(1);
		int last = vertex;
		List<Integer> ans = new ArrayList<>();
		ans.add(last);
		if (val[last] == 0) {
			out.println(-1);
		} else {
			while (last != 1) {
				last = val[last];
				ans.add(last);
			}
			for (int i = ans.size() - 1; i >= 0; i--) {
				out.print(ans.get(i) + " ");
			}
		}
		out.flush();
		out.close();
	}

	private static int[] dijkstra(int source) {
		// TODO Auto-generated method stub
		int len = nodes.length;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[len];
		int[] dist = new int[len];
		int[] prev = new int[len];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;
		pq.add(new Node(source, 0));
		while (!pq.isEmpty()) {
			Node e = pq.remove();
			visited[e.y] = true;
			for (Node x : nodes[e.y]) {
				int w = dist[e.y] + x.w;
				if (!visited[x.y] && dist[x.y] > w) {
					dist[x.y] = w;
					pq.add(new Node(x.y, dist[x.y]));
					prev[x.y] = e.y;
				}
			}
		}
		return prev;
	}

	static class Node implements Comparable<Node> {
		int y;
		int w;

		public Node(int y, int w) {
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node n) {
			// TODO Auto-generated method stub

			return this.w - n.w;
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