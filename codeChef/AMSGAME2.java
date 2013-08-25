import java.util.Scanner;


public class Main_AMSGAME2 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt(),n;
		while(test-->0){
			n = in.nextInt();
			arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = in.nextInt();
			} int ans = 0;
			for(int i = 0;i<n;i++){
				for(int j=i+1;j<n;j++){
					if(solve(i,j))ans++;
				}
			}System.out.println(ans);
		}
	}
	
	public static boolean solve(int start,int end){
		int curra, currb;
		curra = arr[start];
		if(arr.length==1){
			return arr[start] == 1;
		}for(int i=start;i<end-1;i++){
			currb = arr[i+1];
			curra = gcd(curra,currb);
		}return curra==1;
	}
	
	public static int gcd(int a, int b){
		if(b == 0) return a;
		return gcd(b,a%b);
	}


}
