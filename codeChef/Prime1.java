import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		while(num-->0){
			int start = in.nextInt();
			int end = in.nextInt();
			if(start > 10){
				boolean[] primes = new boolean[(int) Math.ceil(Math.sqrt(end))];
				Arrays.fill(primes,true); primes[0] = false; primes[1] = false;
				for(int i=2;i*i<=primes.length; i++){
					if(primes[i])
						for(int j=i*2;j<primes.length;j+=i)
							primes[j] = false;
				}

				boolean[] isPrime = new boolean[end-start];
				Arrays.fill(isPrime,true);
				for(int i=2;i<primes.length;i++){
					if(primes[i]){
						int s = (int) Math.ceil((double)start/i);
						for(int index = s*i -start; index<isPrime.length;index+=i)
							isPrime[index] =false;
					}
				}
				for(int i = 0; i<isPrime.length;i++)
					if(isPrime[i]) System.out.println(i+start);
				System.out.println();
				continue;
			}
			else{
				boolean[] isPrime = new boolean[end+1];
				Arrays.fill(isPrime, true);
				for(int i=2; i*i<=end;i++)
					if(isPrime[i])
						for(int j=2*i;j<=end;j+=i)
							isPrime[j] = false;
				for(int i=2;i<isPrime.length;i++)
					if(isPrime[i]) System.out.println(i);
				System.out.println();
			}
		}
	}

}
