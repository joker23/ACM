#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;

int main(int argc, char * argv[]) {
  int N, M;
  double before[10];
  double after[10];
  while (cin >> N >> M) {
    if (M == 0 && N == 0) {
      break;
    }

    for (int i = 0; i < M; i++) {
      before[i] = 0.0;
    }

    for (int iii = 0; iii < N; iii++) {
      char type;
      cin >> type;
      if (type == 'S') {
        int dist;
        cin >> dist;
        for (int i = 0; i < M; i++) {
          int max_changes = (dist/100 >= M ? M - 1 : dist/100);
          int least = (i - max_changes >= 0 ? i - max_changes : 0);
          int most = (i + max_changes < M ? i + max_changes : M - 1);

          after[i] = before[i] + dist;
          for (int j = least; j <= most; j++) {
            int diff = i > j ? i - j : j - i;
            double hyp = sqrt((double)dist*(double)dist + (100*diff*diff));
            if (after[i] > before[j] + hyp) {
              after[i] = before[j] + hyp;
            }
          }
        }
      } else {
        double inside_rad;
        cin >> inside_rad;
        for (int i = 0; i < M; i++) {
          double dist_from_left = (10*i) + 5;
          double radius = 0;
          if (type == 'L') {
            radius = inside_rad + dist_from_left;
          } else if (type == 'R') {
            radius = inside_rad + (10*M - dist_from_left);
          } else {
            cerr << "Incorrect judge data" << endl;
          }
          after[i] = before[i] + (M_PI*radius/2);
        }
      }

      for (int i = 0; i < M; i++) {
        before[i] = after[i];
      }
    }

    double min = before[0];
    for (int i = 1; i < M; i++) {
      if (min > before[i]) {
        min = before[i];
      }
    }

    printf("%.2lf\n", min);
  }

  return 0;
}
