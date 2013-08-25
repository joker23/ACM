import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
public class Main_MatchSticks {

	public static void main(String[] args) throws NumberFormatException, IOException{
		DecimalFormat format = new DecimalFormat("#.0");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(in.readLine().trim());
		double[] board = new double[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<board.length;i++){
			board[i] = Integer.parseInt(st.nextToken());
		}n = Integer.parseInt(in.readLine().trim());
		while(n-->0){
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());
			double min = Integer.MAX_VALUE;
			for(int i = start;i<=finish;i++){
				min = Math.min(min,board[i]);
			}if(board.length==1){
				System.out.println((double)min);
				continue;
			} for(int i = start;i<=finish;i++){
				board[i]= (double)(board[i]-min)/2;
			} double ret = Integer.MIN_VALUE;
			for(int i=0;i<board.length;i++){
				ret = Math.max(ret, board[i]);
			}System.out.println(format.format(ret+min));
		}
	}
}
