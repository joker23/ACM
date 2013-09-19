#include <iostream>
#include <fstream>
#include <cstdlib>
#include <vector>
using namespace std;

vector<int> getDigits(int num) {
   
   vector<int> digits(10);
   while (num > 0) {
         
         int digit = (num % 10);
         digits[digit]++;
         num = num / 10;        
   }
   return digits;   
}

bool testVampire(int factor1, int factor2, int product) {

     vector<int> fac1Digits = getDigits(factor1);
     vector<int> fac2Digits = getDigits(factor2);
     vector<int> prodDigits = getDigits(product);
     
     for (int i = 0; i < 10; i++) {

         if (fac1Digits[i] + fac2Digits[i] != prodDigits[i])
            return false;
     } 
     return true;     
}

bool isVampireNumber(int n) {
     for (int fac = 1; fac * fac <= n; fac++) {
         if (n % fac == 0)
            if (testVampire(fac, n / fac, n))
                        return true;    
     }     
     return false;
}

int main() {
 
    ifstream infile("vampirenumbers.judge");
    ofstream outfile("vampire.out");
    
    while (true) {
    
          int n;
          infile >> n;
          cout << n << endl;
          if (n == 0)
             return 0;
             
          while (!isVampireNumber(n)) {
                n++;
                }
          
          outfile << n << endl;
    }  
}
