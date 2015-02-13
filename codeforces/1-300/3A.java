import java.util.*;

public class Main {
	static final int[] dx = { 1, 0, -1, 1, -1, 1, 0, -1 };
	static final int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static final String[] dir = { "RU", "U", "LU", "R", "L", "RD", "D", "LD" };
	static final int INF = Integer.MAX_VALUE;
	static boolean[][] board = new boolean[8][8];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String start = in.next(), end = in.next();
		LinkedList<Node> q = new LinkedList<Node>();
		int sc = start.charAt(0) - 'a', sr = Math.abs(start.charAt(1) - '8');
		int ec = end.charAt(0) - 'a', er = Math.abs(end.charAt(1) - '8');
		q.add(new Node(sr, sc, 0, ""));
		Node curr;
		String ret = "";
		int ret1 = 0;
		while (!q.isEmpty()) {
			curr = q.poll();
			if (curr.row == er && curr.col == ec) {
				ret = curr.path;
				ret1 = curr.w;
				break;
			}
			if (board[curr.row][curr.col]) continue;
			board[curr.row][curr.col] = true;
			for (int i = 0; i < dx.length; i++) {
				try {
					if (!board[curr.row + dy[i]][curr.col + dx[i]]) {
						q.addLast(new Node(curr.row + dy[i], curr.col + dx[i],
								curr.w + 1, curr.path + dir[i] + "\n"));
					}
				} catch (Exception e) {}
			}

		} // will always find
		System.out.println(ret1 + "\n" + ret);
	}

	private static class Node {
		int row, col, w;
		String path;

		public Node(int row, int col, int w, String path) {
			this.row = row;
			this.col = col;
			this.w = w;
			this.path = path;
		}
	}
}
