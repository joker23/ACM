#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int nums[12];
bool done[12];
int hexagram[12];
int ways;

int find(int x) {
  for (int i = 0; i < 12; i++) {
    if (nums[i] == x && !done[i]) {
      return i;
    }
  }
  return -1;
}

void recurse(int pos) {
  if (pos == 8) {
    hexagram[8] = hexagram[4] + hexagram[6] + hexagram[7] - hexagram[1] - hexagram[2];
    int ind8 = find(hexagram[8]);
    if (ind8 < 0) {
      return;
    } else {
      done[ind8] = true;
    }
    hexagram[9] = hexagram[3] + hexagram[5] + hexagram[7] - hexagram[1] - hexagram[2];
    int ind9 = find(hexagram[9]);
    if (ind9 < 0) {
      done[ind8] = false;
      return;
    } else {
      done[ind9] = true;
    }
    hexagram[10] = hexagram[0] + hexagram[2] + hexagram[4] - hexagram[5] - hexagram[6];
    int ind10 = find(hexagram[10]);
    if (ind10 < 0) {
      done[ind8] = false;
      done[ind9] = false;
      return;
    } else {
      done[ind10] = true;
    }
    hexagram[11] = hexagram[0] + hexagram[1] + hexagram[3] - hexagram[5] - hexagram[6];
    int ind11 = find(hexagram[11]);
    if (ind11 < 0) {
      done[ind8] = false;
      done[ind9] = false;
      done[ind10] = false;
      return;
    } else {
      done[ind11] = true;
    }
    if (hexagram[1] + hexagram[2] + hexagram[8] + hexagram[9] == hexagram[5] + hexagram[6] + hexagram[10] + hexagram[11]) {
      ways++;
    }

    done[ind8] = false;
    done[ind9] = false;
    done[ind10] = false;
    done[ind11] = false;

/*   cerr << ways << ": ";
   for (int i = 0; i < 12; i++) {
     cerr << hexagram[i] << " ";
    }
    cerr << endl;
*/
  } else {
    if (hexagram[pos] > 0) {
      recurse(pos+1);
      return;
    }
    for (int i = 0; i < 12; i++) {
      if (!done[i]) {
        hexagram[pos] = nums[i];
        done[i] = true;
        recurse(pos+1);
        done[i] = false;
        hexagram[pos] = 0;
      }
    }
  }
}

int main(int argc, char * argv[]) {
  while (true) {
    for (int i = 0; i < 12; i++) {
      cin >> nums[i];
    }
    if (nums[0] == 0) {
      break;
    }

    int swapper;
    for (int i = 0; i < 12; i++) {
      for (int j = 10; j >= i; j--) {
        if (nums[j] > nums[j+1]) {
          swapper = nums[j];
          nums[j] = nums[j+1];
          nums[j+1] = swapper;
        }
      }

      done[i] = false;
      hexagram[i] = 0;
    }

    hexagram[0] = nums[0];
    done[0] = true;
    ways = 0;

    for (int i = 1; i < 12; i++) {
      hexagram[1] = nums[i];
      done[i] = true;
      for (int j = i + 1; j < 12; j++) {
        hexagram[2] = nums[j];
        done[j] = true;
        recurse(3);
        done[j] = false;
        hexagram[2] = 0;
      }
      done[i] = false;
      hexagram[1] = 0;
    }

    done[0] = false;
    hexagram[0] = 0;

    hexagram[1] = nums[0];
    done[0] = true;
    for (int i = 1; i < 12; i++) {
      hexagram[2] = nums[i];
      done[i] = true;
      for (int j = i + 1; j < 12; j++) {
        hexagram[3] = nums[j];
        done[j] = true;
        recurse(0);
        done[j] = false;
        hexagram[3] = 0;
      }
      done[i] = false;
      hexagram[2] = 0;
    }
    done[0] = false;
    hexagram[1] = 0;

    cout << ways << endl;
  }
}
