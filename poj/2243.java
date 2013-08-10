import java.util.*;

public class Main {
	static char[] dx = { '1', '2', '3', '4', '5', '6', '7', '8' };
	static char[] dy = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
	static int[] dr = { 1, 1, -1, -1, 2, 2, -2, -2 };
	static int[] dc = { 2, -2, 2, -2, 1, -1, 1, -1 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
		for (int i = 0; i < dx.length; i++) {
			dict.put(dx[i], i);
			dict.put(dy[i], i);
		}
		
		int[][] board = new int[8][8];
		while (in.hasNext()) {
			LinkedList<Integer> x =new LinkedList<Integer>();
			LinkedList<Integer> y =new LinkedList<Integer>();
			LinkedList<Integer> count = new LinkedList<Integer>();
			for (int i = 0; i < board.length; i++)
				Arrays.fill(board[i], Integer.MAX_VALUE);
			String temp = in.next();
			int startx = dict.get(temp.charAt(0));
			int starty = dict.get(temp.charAt(1));
			String temp1 = in.next();
			int goalx = dict.get(temp1.charAt(0));
			int goaly = dict.get(temp1.charAt(1));
			x.addLast(startx);
			y.addLast(starty);
			count.addLast(0);
			int currx,curry,currc;
			while (board[goalx][goaly] == Integer.MAX_VALUE) {
				currx = x.poll(); curry = y.poll(); currc = count.poll();
				try{
					if(board[currx][curry]!=Integer.MAX_VALUE)continue; 
					board[currx][curry] = currc;
				}catch(Exception e){continue;}
				for(int i=0;i<dx.length;i++){
					x.addLast(currx+dr[i]);
					y.addLast(curry+dc[i]);
					count.addLast(currc+1);
				}
			}
			System.out.println("To get from " + temp + " to " + temp1
					+ " takes " + board[goalx][goaly] + " knight moves.");
		}
	}
}
