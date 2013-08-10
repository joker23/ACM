import java.util.*;
import java.io.*;
public class Main {
	static final int dx[] = {1,-1,3,-3};
	static final char dir[] = {'r','l','d','u'};
	static final String GOAL = "12345678x";
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		LinkedList<Node> q = new LinkedList<Node>();
		HashSet<String> visited = new HashSet<String>();
		String board="",s;
		char d[],tmp;
		int pos = 0;
		for(int i = 0;st.hasMoreTokens();i++){
			s=st.nextToken();
			if(s.equals("x")) pos = i;
			board+=s;
		} Node curr = new Node(board,pos,"");
		q.addLast(curr);
		boolean found = false;
		while(!q.isEmpty()){
			curr = q.poll();
			if(curr.state.equals(GOAL)){
				found = true;
				break;
			} if(visited.contains(curr.state))continue;
			visited.add(curr.state);
			for(int i= 0; i<dx.length;i++){
				d = curr.state.toCharArray();
				if(curr.pos+dx[i]>=0&&curr.pos+dx[i]<curr.state.length()){
					if(i==1&&curr.pos%3==0) continue;
					if(i==0&&(curr.pos+1)%3==0) continue;
					tmp = d[curr.pos];
					d[curr.pos] = d[curr.pos+dx[i]];
					d[curr.pos+dx[i]] = tmp;
					s = String.valueOf(d);
					if(!visited.contains(s))
						q.addLast(new Node(s,curr.pos+dx[i],curr.path+dir[i]));
				}
			}
		}if(found) System.out.println(curr.path);
		else System.out.println("unsolvable");
		
		
	}
	private static class Node{
		String state, path;
		int pos;
		public Node(String state, int pos,String path){
			this.state = state;
			this.path = path;
			this.pos = pos;
		}
	}
}
