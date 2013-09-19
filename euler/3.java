import java.util.*;
import java.io.*;

public class Main {
	static Scanner in;
	public static void main(String[] args){
		long n = 600851475143L;
		
		while(n%3 == 0){
		 	n /= 3;
		}
		while((n&1) == 0){
			n = n >> 1;
		}
		int ans = 1;
		for(int i = 6; n!=1; i+=6){
			if(n%(i-1) == 0 && isprime(i-1)){
				while(n%(i-1) == 0){
					n/=i-1;
				}
				ans = i-1;
			}
			if(n%(i+1) == 0 && isprime(i+1)){
				while(n%(i+1) == 0){
					n/=i+1;
				}
				ans = i+1;
			}
		}
		System.out.println(ans);
	}

	static boolean isprime(int n){
		if((n&1) == 0) return false;
		if(n%3 == 0) return false;
		for(int i = 6; i*i< n ; i+=6){
			if(n%(i-1) == 0 || n%(i+1) == 0){
				return false;
			}
		}return true;
	}
}
