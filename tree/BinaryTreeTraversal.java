package algo.ds.tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class BinaryTreeTraversal {

	
	// input number of vertex
	
	public static void main(String[] args) throws IOException {
		FastReader in = new FastReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		BinaryTree bt = new BinaryTree();
		for (int i = 0; i < n; i++) {
			bt.add(in.nextInt());
		}

		// bt.preOrder(bt.root);
		// bt.inOrder(bt.root);
		// bt.postOrder(bt.root);
		// bt.bfs(bt.root);
		out.println(bt.find(15));
		out.flush();
		out.close();
	}

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

	}

	static class BinaryTree {
		Node root;

		// Add
		public void add(int value) {
			root = addRecursive(root, value);
		}

		private Node addRecursive(Node current, int value) {

			if (current == null) {
				return new Node(value);
			} else if (value < current.value) {
				current.left = addRecursive(current.left, value);
			} else if (value > current.value) {
				current.right = addRecursive(current.right, value);
			} else {
				return current;
			}
			return current;
		}

		// Find
		public boolean find(int value) {
			return findRecursive(root, value);
		}

		private boolean findRecursive(Node current, int value) {
			if (current == null) {
				return false;
			}
			if (current.value == value) {
				return true;
			} else if (value < current.value) {
				return findRecursive(current.left, value);
			} else {
				return findRecursive(current.right, value);
			}
		}

		// BFS
		public void bfs(Node node) {
			if (node == null) {
				return;
			}
			Queue<Node> queue = new LinkedList<>();
			queue.add(node);
			while (!queue.isEmpty()) {
				node = queue.poll();
				System.out.print(" " + node.value);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}

		// DFS

		// Root - Left - Right
		public void preOrder(Node node) {
			if (node != null) {
				System.out.print(" " + node.value);
				preOrder(node.left);
				preOrder(node.right);
			}
		}
		// Left - Root - Right

		public void inOrder(Node node) {
			if (node != null) {
				inOrder(node.left);
				System.out.print(" " + node.value);
				inOrder(node.right);
			}
		}

		// Left - Right - Root
		public void postOrder(Node node) {
			if (node != null) {
				postOrder(node.left);
				postOrder(node.right);
				System.out.print(" " + node.value);
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