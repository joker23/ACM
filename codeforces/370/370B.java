import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		boolean arr[][] = new boolean[n][101];
		LinkedList<Integer>[] list = new LinkedList[n];
		int[] call = new int[n];
		int[] player = new int[n];

		for(int i=0;i<n;i++){
			list[i] = new LinkedList<Integer>();
		}

		for(int i=0;i<n;i++){
			int tmpn = in.nextInt();
			for(int j=0;j<tmpn;j++){
				int tm = in.nextInt();
				arr[i][tm] = true;
				list[i].add(tm);
			}
			player[i] = tmpn;
		}

		for(int i=0;i<n;i++){
			Arrays.fill(call,0);
			boolean boom = false;
			for(int j: list[i]){
				for(int k=0;k<n;k++){
					if(arr[k][j]){
						call[k]++;
						if(call[k] == player[k] && k!=i){
							boom =true;
							break;
						}
					}
				} if(boom){
					break;
				}
			}
			if(boom){
				System.out.println("NO");
			}else{
				System.out.println("YES");
			}
		}
	}
}
