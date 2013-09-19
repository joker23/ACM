#include <iostream>
#include <string>
#include <vector>
using namespace std;

int abs(int n) { return n >= 0 ? n : -n; }

void Solve(int rings, const vector<vector<int> >& raw_runes) {
  for (int i = 0; i < raw_runes.size(); ++i) {
    for (int j = 0; j < 3; ++j) {
      if (raw_runes[i][j] == 0) {
	cout << "INVALID: NULL RING" << endl;
	return;
      }
    }
  }

  for (int i = 0; i < raw_runes.size(); ++i) {
    for (int j = 0; j < 3; ++j) {
      if (abs(raw_runes[i][j]) > rings) {
	cout << "INVALID: RING MISSING" << endl;
	return;
      }
    }
  }

  vector<int> rune_on(raw_runes.size(), 0), rune_off(raw_runes.size(), 0);
  for (int i = 0; i < raw_runes.size(); ++i) {
    for (int j = 0; j < 3; ++j) {
      int v = abs(raw_runes[i][j]) - 1;
      if ( (rune_on[i] & (1 << v)) || (rune_off[i] & (1 << v)) ) {
	cout << "INVALID: RUNE CONTAINS A REPEATED RING" << endl;
	return;
      }
      if (raw_runes[i][j] > 0) {
	rune_on[i] |= (1 << v);
      } else {
	rune_off[i] |= (1 << v);
      }
    }
  }

  int full_bm = (1 << rings) - 1;
  for (int bm_on = 0; bm_on <= full_bm; ++bm_on) {
    int bm_off = full_bm - bm_on;

    bool satisfied = true;
    for (int i = 0; i < rune_on.size() && satisfied; ++i) {
      if ( !(rune_on[i] & bm_on) && !(rune_off[i] & bm_off) )
	satisfied = false;
    }
    if (satisfied) {
      cout << "RUNES SATISFIED!" << endl;
      return;
    }
  }

  cout << "RUNES UNSATISFIABLE! TRY ANOTHER GATE!" << endl;
}

int main() {
  int T, rings, runes, temp;
  cin >> T;
  for (int tc = 0; tc < T; ++tc) {
    cin >> rings >> runes;
    vector<vector<int> > raw_runes(runes, vector<int>(4));
    for (int i = 0; i < runes; ++i)
      for (int j = 0; j < 4; ++j)
	cin >> raw_runes[i][j];
    Solve(rings, raw_runes);
  }
}
