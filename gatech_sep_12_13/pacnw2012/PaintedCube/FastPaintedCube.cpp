#include <iostream>
#include <string>
#include <vector>
#include <cstring>
using namespace std ;
const int MAXDIMEN = 20 ;
const int MAXSQUARES = 20 ;
int toindex[MAXDIMEN+2][MAXDIMEN+2] ;
int xpos[32], ypos[32] ;
/*
 *   Layout of state:
 *      Low five bits:  position index
 *      Next six bits:  cube face paint
 *      Remaining 20 bits:  square paint
 *
 *   The six bits of the cube state are given in the order (from
 *   low order bits):
 *
 *      down back left up front right
 *
 *   Moving left (x -1) shifts down -> right -> up -> left -> down
 *             This is 0 -> 5 -> 3 -> 2
 *   Moving up (y -1) shifts down -> front -> up -> back
 *             This is 0 -> 4 -> 3 -> 1
 */
typedef unsigned int state ;
int dx[] = { -1, 1, 0, 0 } ;
int dy[] = { 0, 0, -1, 1 } ;
const int CHOOSE26_6 = 230230 ;
const int MAXBITS = (MAXSQUARES + 6) ;
char world[CHOOSE26_6 * MAXSQUARES + 32] ;
int base[8192], addto[8192], bc[8192] ;
int cnts[14] ;
int cubetransform[4][64] ;
int indx(state v) {
  return base[v >> 18] + addto[8191 & (v >> 5)] + (v & 31) ;
}
int process(vector<string> &b) {
  int h = b.size();
  int w = b[0].size() ;
  state initstate = 0 ;
  state goalstate = 0x3f << 5 ;
  int ind = 6 + 5 - 1 ;
  memset(toindex, 0, sizeof(toindex)) ;
  memset(world, 0, sizeof(world)) ;
  for (int y=0; y<h; y++)
    for (int x=0; x<w; x++) {
      if (b[y][x] != '#') {
	ind++ ;
	xpos[ind] = x+1 ;
	ypos[ind] = y+1 ;
	toindex[y+1][x+1] = ind ;
      }
      switch (b[y][x]) {
      case '.':
	break ;
      case 'P':
	initstate |= 1<<ind ;
	break ;
      case 'G':
	goalstate += ind ;
	break ;
      case 'C':
	initstate += ind ;
	break ;
      case '#':
	break ;
      default:
	cerr << "Unexpected val " << b[y][x] << endl ;
	abort() ;
      }
    }
  ind++ ;
  int sq = ind - 11 ;
  int bp = sq + 6 ;
  int pos = sq ;
  for (int i=0; i<6; i++)
     pos = pos * (bp - i) / (i + 1) ;
  vector<state> s0, s1 ;
  world[indx(initstate)] = 1 ;
  s0.push_back(initstate) ;
  for (int dist=1; ; dist++) {
    if (s0.size() == 0)
      break ;
    for (int s0i=0; s0i<s0.size(); s0i++) {
      int start = s0[s0i] ;
      int p = start & 0x1f ;
      int cs = (start >> 5) & 0x3f ;
      for (int d=0; d<4; d++) {
	int nx = xpos[p] + dx[d] ;
	int ny = ypos[p] + dy[d] ;
	int np = toindex[ny][nx] ;
	if (np == 0)
	  continue ;
	int ncs = cubetransform[d][cs] ;
	int dest = (start & ~0x7ff) ;
	// transfer paint?  would be from cs bit 0 to/from the index
	if (((dest >> np) & 1) != (ncs & 1)) {
	  dest ^= 1<<np ;
	  ncs ^= 1 ;
	}
	dest += (ncs << 5) + np ;
	int mind = indx(dest) ;
	if (world[mind] == 0) {
	  if (dest == goalstate)
	    return dist ;
	  world[mind] = 1 ;
	  s1.push_back(dest) ;
	}
      }
    }
    s0.clear() ;
    swap(s0, s1) ;
  }
  return -1 ;
}
int rot[4][4] = { { 0,5,3,2 }, { 0,2,3,5 }, { 0,4,3,1 }, { 0,1,3,4 }} ;
int main(int argc, char *argv[]) {
   string s ;
   vector<string> board ;
   for (int d=0; d<4; d++) {
     for (int i=0; i<4; i++)
       cubetransform[d][1<<rot[d][i]] = 1<<rot[d][(i+1)&3] ;
     for (int i=0; i<6; i++)
       if (cubetransform[d][1<<i] ==0)
	 cubetransform[d][1<<i] = 1<<i ;
     for (int i=1; i<64; i++)
       if (cubetransform[d][i] == 0)
	 cubetransform[d][i] = cubetransform[d][i&-i] +
	   cubetransform[d][i&(i-1)] ;
   }
   cnts[0] = 1 ;
   for (int i=1; i<8192; i++) {
     bc[i] = bc[i & (i - 1)] + 1 ;
     addto[i] = cnts[bc[i]]++ ;
   }
   int at = 0 ;
   for (int i=0; i<8192; i++) {
     if (bc[i] <= 6) {
       base[i] = at ;
       at += cnts[6-bc[i]] ;
     }
   }
   for (int i=0; i<8192; i++) {
     base[i] *= MAXSQUARES ;
     addto[i] *= MAXSQUARES ;
   }
   while (1) {
      getline(cin, s) ;
      if (cin.eof() || s.size() <= 1) {
	cout << process(board) << endl ;
	board.clear() ;
	if (cin.eof())
	  break ;
      } else {
	board.push_back(s) ;
      }
   }
}
