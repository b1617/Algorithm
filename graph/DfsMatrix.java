package algo.ds.graph;

import java.io.FileReader;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class DfsMatrix {

	private static int[][] mx;
	private static int[] rows = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static int[] cols = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
	private static int score = 0;

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);
		int vertex = in.nextInt();
		int edges = in.nextInt();
		mx = new int[vertex][vertex];
		for (int i = 0; i < edges; i++) {
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			mx[x][y] = 1;
			mx[y][x] = 1;
		}
		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j < vertex; j++) {
				System.out.print(mx[i][j] + " ");
			}
			System.out.println();
		}
		boolean[][] vis = new boolean[vertex][vertex];
		int ans = 0;
		int max = 0;
		for (int i = 0; i < mx.length; ++i) {
			for (int j = 0; j < mx.length; ++j) {
				if (mx[i][j] == 1 && !vis[i][j]) {
					score = 1;
					dfs(mx, vis, i, j);
					++ans;
					max = Math.max(max, score);
				}
			}
		}
		System.out.println("Nb d'îles : " + ans + " taille max : " + max);
	}

	private static void dfs(int[][] mx, boolean[][] vis, int i, int j) {
		// les voisins possibles
		vis[i][j] = true;
		for (int k = 0; k < 8; ++k) {
			if (isPossible(mx, i + rows[k], j + cols[k], vis)) {
				++score;
				dfs(mx, vis, i + rows[k], j + cols[k]);

			}
		}

	}

	private static boolean isPossible(int[][] mx, int i, int j, boolean[][] vis) {
		return (i >= 0) && (i < mx.length) && (j >= 0) && (j < mx.length) && (mx[i][j] == 1) && (!vis[i][j]);
	}

}
