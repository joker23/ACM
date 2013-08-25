import java.util.*;
public class Main_AMSGAME1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt(),n,curra,currb;
		while(test-->0){
			n = in.nextInt();
			curra = in.nextInt();
			if(n==1){
				System.out.println(curra);
				continue;
			}for(int i=0;i<n-1;i++){
				currb = in.nextInt();
				curra = gcd(curra,currb);
			}System.out.println(curra);
		}
	}
	
	public static int gcd(int a, int b){
		if(b == 0) return a;
		return gcd(b,a%b);
	}

}
