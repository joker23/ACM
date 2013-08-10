import java.util.*;	
public class Main {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int curr;
		for(;;){
			curr = in.nextInt();
			if(curr == 0)break;
			if(isPrime(curr-2)){
				System.out.println(curr+" = "+2+" + "+(curr-2));
				continue;
			} if(isPrime(curr-3)){
				System.out.println(curr+" = "+3+" + "+(curr-3));
				continue;
			}boolean found = false;
			for(int i = 6;i<curr;i+=6){
				if(isPrime(i-1)&&isPrime(curr-(i-1))){
					System.out.println(curr+" = "+(i-1)+" + "+(curr-(i-1)));
					found =true;
					break;
				}if(isPrime(i+1)&&isPrime(curr-(i+1))){
					System.out.println(curr+" = "+(i+1)+" + "+(curr-(i+1)));
					found =true;
					break;
				}
			}if(!found)System.out.println("Goldbach's conjecture is wrong.");
		}
	}
	
	public static boolean isPrime(int n){
		if(n==2||n==3) return true;
		if(n%2==0 || n%3==0|| n<2) return false;
		int stop = (int) Math.sqrt(n)+2;
		for(int i=6;i<=stop;i+=6){
			if(n%(i+1)==0||n%(i-1)==0) return false;
		}return true;
	}
}
