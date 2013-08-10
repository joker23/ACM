import java.awt.Point;
import java.util.*;

public class Main {
	final static int[] dx = { 1, -1, 0, 0, 1, -1, 1, -1 };
	final static int[] dy = { 0, 0, 1, -1, 1, 1, -1, -1 };

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		for(int test = 0;test<num;test++){
			int n = in.nextInt();
			char[][] board = new char[n][n];
			for(int i=0;i<n;i++) Arrays.fill(board[i],'?');
			board[n/2][n/2] = '.';
			int numMines = in.nextInt();
			while(numMines-->0){
				board[in.nextInt()-1][in.nextInt()-1] = '*';
			}
			int qb=0, qe=1;
			int[] iq= new int[99999];
			int[] jq= new int[99999];
		    iq[0] = jq[0] = n/2;
		    
		    while( qe > qb ){
		      int I = iq[qb], J = jq[qb++];
		      board[I][J] = '.';
		      for(int k=0; k<2; k++ )
		    	  for( int i=Math.max(I-1,0); i<Math.min(I+2,n); i++ )
		    		  for( int j=Math.max(J-1,0); j<Math.min(J+2,n); j++ )
		    			  if(k>0  &&  board[i][j] == '?' ){
		    				  board[i][j] = ' ';
		    				  iq[qe] = i;
		    				  jq[qe++] = j;
		    			  } else if( board[i][j] == '*' ){
		    				  board[I][J] = '#';
		    				  k=i=j=n;
		    			  }
		    }
			System.out.println("Scenario #"+(test+1)+":");
			print(board);
		}
	}

	private static void print(char board[][]) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
