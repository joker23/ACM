import java.util.*;
public class Main_Witua_and_Math {
	/**
	 * find all the prime numbers
	 * @param args
	 */
	public static void main(String[] args){
		double max = Integer.MIN_VALUE;
		for(long i=2;i<100;i++){
			if(((double)phi(i)/i)>max){
				System.out.println(i+":"+((double)phi(i)/i));
				max = (double)phi(i)/i;
			}
		}
	}
	
	
	static long phi(long n){
		long ret = n;
		if(n%2==0){ //kill all 2s
				ret/=2;
				do{n/=2;}while(n%2==0);
		} if(n%3==0){ //kill all 3s
				ret=ret/3*2;
				do{n/=3;}while(n%3==0);
		} int stop = (int) Math.sqrt(n)+2;
		for(long i=6;i<=stop;i+=6){ //all primes
				if(n%(i-1)==0){
					ret = ret/(i-1)*(i-2);
					while(n%(i-1)==0) n/=i-1;
					stop = (int) Math.sqrt(n)+2;
				} if(n%(i+1)==0){
					ret = ret/(i+1)*i;
					while(n%(i+1)==0) n/=i+1;
					stop = (int) Math.sqrt(n)+2;
				}
		} if(n!=1) ret = ret/n*(n-1);
		return ret;
	}
}
