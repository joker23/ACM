#include <cstdio>
using namespace std ;
const char *vowels = "aiyeou" ;
const char *cons = "bkxznhdcwgpvjqtsrlmf" ;
char remap[128] ;
int main(int argc, char *argv[]) {
   for (int i=0; i<128; i++)
      remap[i] = i ;
   for (const char *p=vowels; p[3]; p++) {
      remap[(int)*p] = p[3] ;
      remap[(int)p[3]] = *p ;
   }
   for (const char *p=cons; p[10]; p++) {
      remap[(int)*p] = p[10] ;
      remap[(int)p[10]] = *p ;
   }
   for (char i='A'; i<='Z'; i++)
      remap[(int)i] = 'A'+remap['a'+i-'A']-'a' ;
   int c ;
   while ((c=getchar()) != EOF)
      putchar(remap[c]) ;
}
