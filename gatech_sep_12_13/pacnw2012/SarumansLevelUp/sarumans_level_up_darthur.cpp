#include <iostream>
#include <vector>
using namespace std;

typedef long long ll;
vector<ll> memo(200, -1);

ll SolveMain(int digits, int target) {
  if (digits == 0) return (target == 0? 1 : 0);
  int key = digits * 3 + target;
  if (memo[key] >= 0) return memo[key];
  memo[key] = SolveMain(digits - 1, target) +
    SolveMain(digits - 1, (target+2)%3);
  return memo[key];
}

ll Solve(ll n) {
  vector<int> bits;
  if (n == 0) return 0;
  while (n > 0) {
    bits.push_back(n % 2);
    n /= 2;
  }

  int bc = 0;
  ll result = 0;
  for (int i = bits.size() - 1; i >= 0; --i) {
    if (bits[i] == 1) result += SolveMain(i, (3000 - bc) % 3);
    bc += bits[i];
  }
  if ((bc % 3) == 0) ++result;
  return result - 1;
}

int main() {
  ll n;
  while (cin >> n) {
    cout << "Day " << n << ": Level = " << Solve(n) << endl;
  }
}
