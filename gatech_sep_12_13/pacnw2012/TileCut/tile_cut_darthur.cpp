#include <assert.h>
#include <iostream>
#include <string>
#include <vector>
using namespace std;

int CalculateFlow(const vector<vector<int> >& graph) {
  vector<vector<int> > flow(graph.size());
  vector<vector<pair<int, int> > > rgraph(graph.size());
  for (int i = 0; i < graph.size(); ++i) {
    for (int j = 0; j < graph[i].size(); ++j) {
      flow[i].push_back(0);
      rgraph[graph[i][j]].push_back(make_pair(i, j));
    }
  }

  int total_flow = 0;
  while (true) {
    vector<int> src_v(graph.size(), -2);
    vector<pair<int, int> > src_e(graph.size());
    src_v[0] = -1;
    vector<int> q(1, 0);
    int q_pos = 0;
    while (q_pos < q.size()) {// && src_v[1] == -2) {
      int v1 = q[q_pos++];
      for (int i = 0; i < graph[v1].size(); ++i) {
	int v2 = graph[v1][i];
	if (!flow[v1][i] && src_v[v2] == -2) {
	  src_v[v2] = v1;
	  src_e[v2] = make_pair(v1, i);
	  q.push_back(v2);
	}
      }
      for (int i = 0; i < rgraph[v1].size(); ++i) {
	int v2 = rgraph[v1][i].first, j = rgraph[v1][i].second;
	if (flow[v2][j] && src_v[v2] == -2) {
	  src_v[v2] = v1;
	  src_e[v2] = make_pair(v2, j);
	  q.push_back(v2);
	}
      }
    }
    if (src_v[1] == -2) {
      // Let's prove this answer is not too low.
      assert(src_v[0] != -2);
      assert(src_v[1] == -2);
      int min_cut = 0;
      for (int i = 0; i < graph.size(); ++i)
	for (int j = 0; j < graph[i].size(); ++j) {
	  int i2 = graph[i][j];
	  if (src_v[i] != -2 && src_v[i2] == -2) ++min_cut;
	}
      assert(total_flow == min_cut);
      return total_flow;
    }

    ++total_flow;
    int v = 1;
    while (v != 0) {
      int &f = flow[src_e[v].first][src_e[v].second];
      f = 1 - f;
      v = src_v[v];
    }
  }
}

int main() {
  while (true) {
    vector<string> board;
    string temp;
    while (getline(cin, temp) && !temp.empty()) {
      board.push_back(temp);
      assert(temp.size() == board[0].size());
    }
    if (board.empty()) return 0;

    int R = board.size(), C = board[0].size();
    vector<vector<int> > adjacent(R * C * 2 + 2);

    int dx[4] = {-1, 0, 1, 0};
    int dy[4] = {0, -1, 0, 1};
    for (int y = 0; y < R; ++y)
      for (int x = 0; x < C; ++x) {
	char ch1 = board[y][x];
	int pos1 = (y * C + x) * 2 + 2;
	assert(pos1 >= 0 && pos1 + 1 < adjacent.size());
	adjacent[pos1].push_back(pos1 + 1);
	if (ch1 == 'W') adjacent[0].push_back(pos1);
	if (ch1 == 'N') adjacent[pos1+1].push_back(1);
	for (int d = 0; d < 4; ++d) {
	  int y2 = y + dy[d], x2 = x + dx[d];
	  if (y2 < 0 || x2 < 0 || y2 >= R || x2 >= C) continue;
	  char ch2 =  board[y2][x2];
	  if (ch1 == 'W' && ch2 != 'I') continue;
	  if (ch1 == 'I' && ch2 != 'N') continue;
	  if (ch1 == 'N') continue;
	  int pos2 = (y2 * C + x2) * 2 + 2;
	  adjacent[pos1 + 1].push_back(pos2);
	}
      }

    cout << CalculateFlow(adjacent) << endl;
  }
}
