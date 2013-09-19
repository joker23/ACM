#include <iostream>
#include <vector>
#include <ctime>
using namespace std;

struct Node {
  int parent;
  vector<int> children;
  long weight;
};

Node nodes[1000000];

void recurse1(int current, vector<long>& dp) {
  int K = dp.size()-1;
  Node& node = nodes[current];
  vector<long> rdp;
  for (int i = 0; i < dp.size(); i++) {
    rdp.push_back(dp[i]);
  }
  for (int i = 0; i < node.children.size(); i++) {
    recurse1(node.children[i], rdp);
  }

  for (int i = 1; i <= K; i++) {
    rdp[i] = max(rdp[i], dp[i-1] >= 0 ? dp[i-1] + node.weight : -1);
  }

  dp.clear();
  for (int i = 0; i < rdp.size(); i++) {
    dp.push_back(rdp[i]);
  }
}

void recurse2(int current, int K, vector<long>& dp) {
  Node& node = nodes[current];
  int B = node.children.size();
  dp.push_back(0);
  for (int i = 1; i <= K; i++) {
    dp.push_back(-1);
  }
  for (int i = 0; i < B; i++) {
    vector<long> rdp;
    recurse2(node.children[i], K, rdp);
    vector<long> idp;
    idp.push_back(0);
    for (int j = 1; j <= K; j++) {
      idp.push_back(-1);
      for (int k = 0; k <= j; k++) {
        if (rdp[k] >= 0 && dp[j-k] >= 0) {
          idp[j] = max(idp[j], rdp[k] + dp[j-k]);
        }
      }
    }
    dp.clear();
    for (int i = 0; i < rdp.size(); i++) {
      dp.push_back(rdp[i]);
    }
  }

  dp[1] = max(dp[1], node.weight);
}

int main(int argc, char * argv[]) {
  int N, K;
  int cas = 0;
  while (cin >> N >> K) {
    if (N == 0 || K == 0) {
      break;
    }

    cas++;

    for (int i = 0; i < N; i++) {
      nodes[i].children.clear();
    }

    int root = -1;
    for (int i = 0; i < N; i++) {
      int P;
      long W;
      cin >> P >> W;
      P--;
      nodes[i].parent = P;
      nodes[i].weight = W;
      if (P >= 0) {
	nodes[P].children.push_back(i);
      } else {
	root = i;
      }
    }
    vector<long> dp;
    dp.push_back(0);
    for (int i = 1; i <= K; i++) {
      dp.push_back(-1);
    }
    recurse1(root, dp);

    // recurse2 is the O(N.K.K) algorithm
    // recurse2(root, K, dp);

    cout << max((long)0, dp[K]) << endl;
  }
  return 0;
}
