public class Main{

	public static void main(String[] args){
		int count = 0;
		for(int i = 2; ; i++){
			if(isPrime(i)){
				count++;
				if(count == 10001){
					System.out.println(i);
					break;
				}
			}
		}
	}

	public static boolean isPrime(long n){
		if(n%2 == 0 && n!=2){
			return false;
		}
		else if(n%3 == 0 && n!=3){
			return false;
		}
		else{
			for(int i = 6; (i-1)*(i-1) <= n; i+=6){
				if((n% (i-1)) == 0){
					return false;
				}
				else if((n % (i+1)) == 0){
					return false;
				}
			}return true;
		}

	}
}
