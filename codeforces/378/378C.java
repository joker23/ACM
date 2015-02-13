import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	//static Scanner in;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	//some variables
	static boolean[][]	visited;	//visited list (this will be important)
	static char[][]		map;		//graph that was given
	static int			n, m, k, num, count;
	static int[]		dx = {1, -1, 0, 0},
						dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		
		//in = new Scanner(System.in);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		//code starts here
		st = new StringTokenizer(in.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		count = 0; //number already visited
		map = new char[n][m];
		visited = new boolean[n][m];

		int initx = 0, inity = 0;
		int emptyCount = 0;
		boolean found = false;
		for(int i=0; i<n; i++){
			String tmp = in.readLine().trim();
			for(int j=0; j<m; j++){
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == '.'){
					emptyCount ++ ;
					if(!found){
						found = true;
						initx = i;
						inity = j;
					}
				}
			}
		}
		
		//this is the number of empty spaces we want for the final ans;
		num = emptyCount - k;
		
		dfs(initx, inity);
		//ans
		char[][] ans = new char[n][m];
		
		for(int i=0;i<n; i++){
			for(int j=0;j<m;j++){
				if(visited[i][j]){
					ans[i][j] = '.';
				} else{
					if(map[i][j] == '#'){
						ans[i][j] = 'X';
						ans[i][j] = 'X';
						ans[i][j] = 'X';
						ans[i][j] = '#';
					} else{
						ans[i][j] = 'X';
					}
				}
			}
		}
		
		print(ans);
		//code ends here
		out.flush();
	}

	private static void dfs(int x, int y){
		if(count == num){
			return;
		}
		visited[x][y] = true;
		count ++;
		for(int i=0; i<dx.length; i++){
			int newx = x + dx[i];
			int newy = y + dy[i];

			if(newx>=0 && newx<n && newy>=0 && newy<m && !visited[newx][newy] && map[newx][newy]!='#'){
				dfs(newx, newy);
			}
		}
	}

	private static void print(char ans[][]){
		for(int i=0;i<ans.length; i++){
			for(int j=0;j<ans[i].length; j++){
				out.print(ans[i][j]);
			} out.println();
		}
	}

	
}
