import java.util.*;
	//comment
	//TODO
public class Main{
	private static int[] dx = {1,1,-1,-1,2,2,-2,-2};
	private static int[] dy = {2,-2,2,-2,1,-1,1,-1};
	private static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		Point init, goal, curr;
		int[][] board;
		LinkedList<Point> q;
		while(test-->0){
			int temp = in.nextInt();
			board = new int[temp][temp];
			for(int i=0;i<board.length;i++){
				Arrays.fill(board[i],INF);
			} q = new LinkedList<Point>();
			init = new Point(in.nextInt(),in.nextInt());
			goal = new Point(in.nextInt(),in.nextInt());
			q.add(init);
			board[init.x][init.y] = 0;
			while(!q.isEmpty() && board[goal.x][goal.y]==INF){
				curr = q.poll();
				for(int i=0;i<dx.length;i++){
					int x = dx[i]+curr.x;
					int y = dy[i]+curr.y;
					if(x<0||x>=temp||y<0||y>=temp)
						continue;
					else if(board[x][y]==INF){
						board[x][y] = board[curr.x][curr.y]+1;
						q.add(new Point(x,y));
					}
				}
			} System.out.println(board[goal.x][goal.y]);
		}
	}

	public static class Point{
		int x,y;
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}

		public String toString(){
			return x+":"+y;
		}

		public boolean equals(Point p){
			return p.x==x && p.y==y;
		}
	}
}
	
