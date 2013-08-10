package Solved;
import java.util.*;
import java.io.*;
public class LETTERS {
	private final static int[] dr = {0,0,1,-1};
	private final static int[] dc = {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine());
		char[][] board = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		boolean[][] visited = new boolean[board.length][board[0].length];
		for(int i=0;i<board.length;i++){
			String b = in.readLine();
			for(int j=0;j<b.length();j++){
				board[i][j] = b.charAt(j);
			}
		}
		fill(board,visited,board[0][0],true);
		System.out.println(solve(0,0,board,visited,1,0));
	}
	
	private static int solve(int row, int col, char[][] board, boolean[][] visited,int moves,int max){
		if(!canMove(row,col,visited)){
			return Math.max(moves,max);
		}
		for(int i=0;i<dr.length;i++){
			try{
				int nrow = row + dr[i];
				int ncol = col + dc[i];
				if(!visited[nrow][ncol]){
					fill(board,visited,board[nrow][ncol],true);
					max = solve(nrow,ncol,board,visited,moves+1,max);
					fill(board,visited,board[nrow][ncol],false);
				}
			}
			catch(Exception e){}
		}
		return max;
		
	}
	
	private static boolean canMove(int row,int col,boolean[][] visited){
		boolean ret = false;
		for (int i=0;i<dr.length;i++){
			try{
				if(!visited[row+dr[i]][col+dc[i]])
					return true;
			}
			catch(Exception e){continue;}
		}
		return ret;
	}
	
	private static void fill(char[][] board, boolean[][] visited,char flag, boolean value){
		for(int i=0;i<visited.length;i++)
			for(int j=0;j<visited[i].length;j++)
				if(board[i][j] == flag)
					visited[i][j] = value;
	}
}
