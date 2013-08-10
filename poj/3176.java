import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num = Integer.parseInt(in.readLine());
		int[][] tree = new int[num][num+1];
		for(int row = 0;row<num;row++){
			st = new StringTokenizer(in.readLine());
			for(int col = 0;st.hasMoreTokens();col++){
				tree[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		for(int row = 1; row<tree.length;row++){
			for(int col = 0; col<=row;col++){
				if(col == 0)
					tree[row][col] = tree[row][col]+tree[row-1][col];
				else
					tree[row][col] = Math.max(tree[row][col]+tree[row-1][col],tree[row][col]+tree[row-1][col-1]);
			}
		}
		int ret = 0;
		for(int i=0;i<tree[0].length;i++){
			ret = Math.max(ret, tree[tree.length-1][i]);
		}
		System.out.println(ret);
	}
}
