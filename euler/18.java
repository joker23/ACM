
import java.util.*;

public class Main{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		int[][] arr = new int[15][15];
		for(int i=0;i<arr.length; i++){
			for(int j=0; j<=i; j++){
				arr[i][j] = in.nextInt();
			}
		}
		int ans = 0;
		for(int i=1;i<15; i++){
			for(int j=0; j<=i; j++){
				int sub = 0;
				if(j>0){
					sub = Math.max(sub, arr[i-1][j-1]);
				}
				sub = Math.max(sub, arr[i-1][j]);
				arr[i][j]+=sub;
				ans = Math.max(ans, arr[i][j]);
			}
		}
		System.out.println(ans);
	}
}
