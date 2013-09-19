#include <assert.h>
#include <iostream>
#include <vector>
using namespace std;

typedef long long ll;

int main() {
  ll H, base_size, top_size, s[3];
  while (cin >> H >> base_size >> top_size) {
    assert(top_size <= base_size);
    ll B = 0;
    cin >> s[0] >> s[1] >> s[2];
    vector<ll> best(H+1, 0);
    for (int h = 1; h <= H; ++h) {
      best[h] = 0;
      ll max_size = top_size + (H-h) * (base_size - top_size) / H;
      for (int si = 0; si < 3; ++si) {
	if (s[si] > h) continue;
	ll base = best[h - s[si]];
	ll used_size = (max_size / s[si]) * s[si];
	base += used_size * used_size * s[si];
	best[h] = max(best[h], base);
	B = max(B, best[h]);
      }
    }
    cout << B << endl;
  }
}
