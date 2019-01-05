package algo.ds.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Bfs {

	static public LinkedList<Integer>[] nodes;

	// input : n vertex && m edges
	// foreach edges input x && y vertex connected
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		int cities = Integer.parseInt(a[0]);
		int roads = Integer.parseInt(a[1]);
		nodes = new LinkedList[cities + 1];
		for (int i = 1; i < cities + 1; i++) {
			nodes[i] = new LinkedList<>();
		}
		for (int i = 0; i < roads; i++) {
			String[] val = br.readLine().split(" ");
			int x = Integer.parseInt(val[0]);
			int y = Integer.parseInt(val[1]);
			nodes[x].add(y);
			nodes[y].add(x);
		}
		int [] ans =Bfs(1, cities);
		for (int i = 1; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	private static int [] Bfs(int i, int c) {
		// TODO Auto-generated method stub
		int []nodesLen = new int[c+1];
		Arrays.fill(nodesLen, -1);
		// Le noeud de depart est de distance 0
		nodesLen[i] = 0;
		boolean[] visited = new boolean[c + 1];
		Queue<Integer> queue = new LinkedList<>();
		visited[i] = true;
		queue.add(i);

		while (queue.size() != 0) {
			i = queue.poll();
			System.out.print(i + " ");
			for (int j = 0; j < nodes[i].size(); j++) {
				int x = nodes[i].get(j);
				if (!visited[x]) {
					nodesLen[x] = nodesLen[i]+1;
					visited[x] = true;
					queue.add(x);
				}

			}
		}
		return nodesLen;
	}

}
