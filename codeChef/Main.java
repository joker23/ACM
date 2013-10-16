
import java.util.*;

public class Main{
	static Scanner in;
	public static void main(String[] args){
		in = new Scanner(System.in);
		int test = in.nextInt();
		while(test --> 0){
			int n = in.nextInt();
			int[][] graph = new int[2*n+2][2*n+2];
			for(int i = 1; i<=n; i++){
				graph[0][i] = 1;
				graph[n+i][2*n+1] = 1;
			}
			
		}
	}
	
	private static void print(int[][] graph){
		for(int i=0; i<graph.length; i++){
			for(int j=0; j<graph[i].length; j++){
				System.out.print("["+graph[i][j]+"]");
			}System.out.println();
		}System.out.println();
	}
	
}

