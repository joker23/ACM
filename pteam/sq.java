
import java.util.*;

public class Main{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		int r,c,max;
		boolean u;
		while((r = in.nextInt()) + (c=in.nextInt()) > 0){
			max = 0;
			u = false;
			int[][] arr = new int[r][c];
			for(int i=0; i<r; i++){
				for(int j =0; j<c; j++){
					arr[i][j] = in.nextInt();
					if(arr[i][j] == 1){
						u = true;
					}
				}
			}
			if(u){
				max++;
			}
			for(int i=1; i<r; i++){
				for(int j =1; j<c; j++){
					if(arr[i][j] == 1)
						arr[i][j] += Math.min(arr[i-1][j-1], Math.min(arr[i][j-1], arr[i-1][j]));
					max = Math.max(max, arr[i][j]);
				}
			}
			System.out.println(max);
		}
	}

}
