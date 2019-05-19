package algo.ds.graph;

import java.util.*;

public class DfsRecursive {

	private static List<Integer>[] nodes;
	private static boolean[] vis;
	private static int[] distance;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		nodes = new ArrayList[n];
		vis = new boolean[n];
		distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for (int i = 0; i < n; ++i) {
			nodes[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			nodes[x].add(y);
			nodes[y].add(x);
		}
		dfs(0, 0);
		distance[0] = 0;
		for (int i = 0; i < n; ++i) {
			System.out.print(distance[i] + " ");
		}
	}

	private static void dfs(int x, int lev) {
		vis[x] = true;
		for (int i = 0; i < nodes[x].size(); ++i) {
			int j = nodes[x].get(i);
			if (!vis[j] && lev + 1 < distance[j]) {
				distance[j] = lev + 1;
				dfs(j, lev + 1);
			}
		}
	}
}
