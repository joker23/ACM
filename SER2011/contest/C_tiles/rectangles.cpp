#include<iostream>
#include<cstdlib>
#include<vector>
#include<climits>
using namespace std;

const int primes[] = {2,3,5,7,11,13,17,19,23,29,31,37}; // this should be more than enough
const  long long MAX_VALUE = 1000000000000000L;

 long long best = MAX_VALUE;

void testNumber(vector<int> factors) {
     
      long long num = 1;
     for (int i = 0; i < factors.size(); i++) {
              
         int prime = primes[factors.size()-1-i];
         for (int j = 0; j < (factors[i] - 1); j++) {
             if (num >= MAX_VALUE / prime)
                return; // this answer is too big
             num *= prime;                 
         }         
     }
     best = min(best,num);
}

void tryFactor(vector<int> factors, int minFactor, int number) {
     
     if (number == 1) {
          testNumber(factors);
          return;
     }
     
     if (number < minFactor) {
          return;     
     }
     
     for (int fac = minFactor; fac <= number; fac++) {         
         if (number % fac == 0) {
              factors.push_back(fac);
              tryFactor(factors, fac, number/fac);                                  
              factors.pop_back();
         }
         
     }
     
     
}
     

int main() {
    
    int num = 0;
    while (true) {
          
          cin >> num;
          if (num == 0)
             return 0;          
          if (num == 1) 
             cout << "1" << endl;
          else {
                                                                      
              best = MAX_VALUE;
              vector<int> vec;
              tryFactor(vec, 2, 2*num);
              tryFactor(vec, 2, 2*num-1);
              cout << best << endl;
          }
    }
    return 0;
}
