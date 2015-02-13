import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	static Scanner in;
	//static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static ArrayList<Integer> list;
	static HashMap<Integer, Integer> freqTable;

	static boolean[][] board;

	public static void main(String[] args) throws IOException{
		in = new Scanner(System.in);
		//in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		int n = in.nextInt();
		board = new boolean[n][n];
		for(int i=0; i<n; i++){
			String tmp = in.next();
			for(int j=0; j<n; j++){
				if(tmp.charAt(j) == '#'){
					board[i][j] = true;
				}
			}
		}

		boolean cando = true;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(board[i][j]){
					if(!fillCross(i, j)){
						cando = false;
						break;
					}
				}
			}

			if(cando == false){
				break;
			}
		}
		if(cando) out.println("YES");
		else out.println("NO");

		out.flush();
	}

	public static boolean fillCross(int x, int y){
		try{
			//always the top square
			if(board[x][y]) board[x][y] = false;
			else return false;

			if(board[x+1][y]) board[x+1][y] = false;
			else return false;

			if(board[x+2][y]) board[x+2][y] =false;
			else return false;

			if(board[x+1][y+1]) board[x+1][y+1] = false;
			else return false;

			if(board[x+1][y-1]) board[x+1][y-1] = false;
			else return false;

			return true;
		} catch(Exception e){
			return false;
		}
	}

	public static void print(int[][] dp){
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[i].length; j++){
				System.out.print("["+dp[i][j]+"]");
			}System.out.println();
		} System.out.println();
	}

	public static void print(boolean[][] dp){
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[i].length; j++){
				System.out.print("["+(dp[i][j] ? 1 : 0)+"]");
			}System.out.println();
		} System.out.println();
	}

	public static void print(LinkedList[] graph){
		for(LinkedList li : graph){
			System.out.println(li);
		}
	}

}
