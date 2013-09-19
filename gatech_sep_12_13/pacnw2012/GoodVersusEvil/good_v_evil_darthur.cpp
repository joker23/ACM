#include <iostream>
#include <vector>
using namespace std;

int good_value[] = {1, 2, 3, 3, 4, 10};
int bad_value[] = {1, 2, 2, 2, 3, 5, 10};

int Dot(const vector<int>& cnt, int* values) {
  int x = 0;
  for (int i = 0; i < cnt.size(); ++i) x += cnt[i] * values[i];
  return x;
}

int main() {
  int T;
  cin >> T;
  for (int tc = 1; tc <= T; ++tc) {
    vector<int> good_cnt(6), bad_cnt(7);
    for (int j = 0; j < good_cnt.size(); ++j) cin >> good_cnt[j];
    for (int j = 0; j < bad_cnt.size(); ++j) cin >> bad_cnt[j];
    int G = Dot(good_cnt, good_value);
    int B = Dot(bad_cnt, bad_value);
    cout << "Battle " << tc << ": ";
    if (G > B)
      cout << "Good triumphs over Evil" << endl;
    else if (B > G)
      cout << "Evil eradicates all trace of Good" << endl;
    else
      cout << "No victor on this battle field" << endl;
  }
  return 0;
}
