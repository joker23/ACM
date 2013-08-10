import java.util.*;

public class Main {

	static final int MAXV = 100000, MAXE = 400000;
	static int to[], nxt[], last[], E, bridges;
	static int level[], par[], low[];
	static boolean visited[], bridge[];

	static void add_edge(int u, int v) {
		to[E] = v; nxt[E] = last[u]; last[u] = E++;
		to[E] = u; nxt[E] = last[v]; last[v] = E++;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N, M, Q;
		to = new int[MAXE]; nxt = new int[MAXE];
		last = new int[MAXV]; level = new int[MAXV];
		par = new int[MAXV]; low = new int[MAXV];
		visited = new boolean[MAXV]; bridge = new boolean[MAXV];
		for (int tc = 1;; tc++) {
			N = in.nextInt();
			M = in.nextInt();
			if (N + M == 0)
				break;
			Arrays.fill(last, -1);
			E = 0;
			// MAKES THE GRAPH
			for (int i = 0, u, v; i < M; ++i) {
				u = in.nextInt();
				v = in.nextInt();
				add_edge(u - 1, v - 1);
			}

			Arrays.fill(visited, false);
			Arrays.fill(bridge, false);
			par[0] = -1;
			bridges = 0;
			dfs(0, 0);
			System.out.println("Case " + (tc) + ":");
			Q = in.nextInt();

			for (int q = 0, u, v; q < Q; ++q) {
				u = in.nextInt();
				v = in.nextInt();
				update(u - 1, v - 1);
				System.out.println(bridges);
			}
			System.out.println();
		}
	}

	static void dfs(int cur, int lvl) {
		visited[cur] = true;
		level[cur] = low[cur] = lvl;
		boolean rep = false;

		for (int e = last[cur]; e != -1; e = nxt[e]) {
			if (to[e] == par[cur] && !rep)
				rep = true;
			else if (visited[to[e]])
				low[cur] = Math.min(low[cur], level[to[e]]);
			else {
				par[to[e]] = cur;
				dfs(to[e], lvl + 1);
				low[cur] = Math.min(low[cur], low[to[e]]);

				if (low[to[e]] > lvl) {
					bridge[to[e]] = true;
					++bridges;
				}
			}
		}
	}

	static void update(int u, int v) {
		if (level[u] < level[v]) {
			int temp = u; u = v; v = temp;
		} while (level[u] != level[v]) {
			if (bridge[u]) {
				--bridges;
				bridge[u] = false;
			}u = par[u];
		} while (u != v) {
			if (bridge[u]) {
				--bridges; bridge[u] = false;
			} if (bridge[v]) {
				--bridges; bridge[v] = false;
			}
			u = par[u]; v = par[v];
		}
	}
}
