import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	//IO tools
	static Scanner in;

	//static variables
	static int 	grid[][],	//the game grid
				dp[][],		//states
				n,m,		//dimensions of the board
				x,y;		//start location

	public static void main(String[] args) throws IOException{
		
		in = new Scanner(System.in);
		
		//code starts here
		n = in.nextInt();
		m = in.nextInt();

		x = in.nextInt() - 1;
		y = in.nextInt() - 1;

		grid = new int[n][m];
		dp = new int[n][m];

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				grid[i][j] = in.nextInt();
			}
		}
		
		dp[x][y] = grid[x][y];

		for(int i=x+1; i<n; i++){
			dp[i][0] = dp[i-1][0] - grid[i][0];
		}

		for(int i=y+1; i<m; i++){
			dp[0][i] = dp[0][i-1] - grid[0][i];
		}

		for(int i=x+1; i<n; i++){
			for(int j=y+1; j<m; j++){
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) - grid[i][j];
			}
		}
		
		int ans = dp[n-1][m-1];

		if(ans<0){
			System.out.println("N");
		} else{
			System.out.println("Y "+ans);
		}
		//code ends here
	}

	//helper functions
}
