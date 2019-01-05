package algo.ds.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Dfs {

	static LinkedList<Integer>[] nodes;

	public static void main(String[] args) throws Exception {

		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		int cities = Integer.parseInt(a[0]);
		int edges = Integer.parseInt(a[1]);
		nodes = new LinkedList[cities + 1];
		for (int i = 1; i < cities + 1; i++) {
			nodes[i] = new LinkedList<>();
		}
		for (int i = 0; i < edges; i++) {
			String[] roads = br.readLine().split(" ");
			int x = Integer.parseInt(roads[0]);
			int y = Integer.parseInt(roads[1]);
			nodes[x].add(y);
			//nodes[y].add(x); 
		}
		dfs(0);

	}

	private static void dfs(int i) {
		int size = nodes.length;
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[size];
		visited[i] = true;
		stack.push(i);
		while (!stack.isEmpty()) {
			i = stack.pop();
			System.out.print(i + " ");
			for (int j = 0; j < nodes[i].size(); j++) {
				int x = nodes[i].get(j);
				if (!visited[x]) {
					stack.add(x);
					visited[x] = true;
				}
			}
		}

	}

}
