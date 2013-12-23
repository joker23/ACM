import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	static Scanner in;	
	public static void main(String[] args) throws IOException{
		in = new Scanner(System.in);

		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();

		//rook move
		if(x1 == x2 && y1 == y2){
			System.out.print("0 0 0");
			return;
		}
		else if( x1==x2 || y1 == y2){
			System.out.print("1 ");
		}else{
			System.out.print("2 ");
		}

		int[][] visited = new int[8][8];
		for(int i=0;i<8;i++){
			Arrays.fill(visited[i], -1);
		}
		visited[x1-1][y1-1] = 0;

		//bishop
		boolean whitex1 = x1%2 == 0;
		boolean whitey1 = y1%2 == 0;
		boolean whitex2 = x2%2 == 0;
		boolean whitey2 = y2%2 == 0;
		
		if(((whitex1 ^ whitey1) ^ (whitex2 ^ whitey2))){
			System.out.print("0 ");
		}else if(Math.abs(x1 - x2) == Math.abs(y1 - y2)){
			System.out.print("1 ");
		} else{
			System.out.print("2 ");
		}
	
		LinkedList<Integer> x = new LinkedList<Integer>();
		LinkedList<Integer> y = new LinkedList<Integer>();

		x.add(x1-1);
		y.add(y1-1);
		
		int[] dx = {1,1,1,0,0-1,-1,-1};
		int[] dy = {0,-1,1,1,-1,0,1,-1};

		while(!x.isEmpty() && visited[x2-1][y2-1] == -1){
			int currx = x.poll();
			int curry = y.poll();

			for(int i=0;i<dx.length;i++){
				int newx = currx + dx[i];
				int newy = curry + dy[i];

				try{
					if(visited[newx][newy] == -1){
						visited[newx][newy] = visited[currx][curry] + 1;
						x.add(newx);
						y.add(newy);
					}
				}catch(Exception e){

				}
			}
		}

		System.out.print(visited[x2-1][y2-1]);
	}
}
