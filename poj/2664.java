import java.io.*;
import java.util.*;
public class Main {
	static final int MAX = 35*35;
	static int match[],head[],num;
	static point p[];
	static boolean board[][],used[];
	public static void main(String[] args) throws IOException{
		/** 
		 * find the max bipartite matching
		 */
		int m,n,k,r,c,odd,even;
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();
		m = (int) st.nval;
		st.nextToken();
		n = (int) st.nval;
		st.nextToken();
		k = (int) st.nval;
		if(((m*n-k)&1) == 1) {System.out.println("NO");return;}
		board = new boolean[MAX][MAX];
		for(int i=0;i<board.length;i++) Arrays.fill(board[i],true);
		head = new int[MAX];
		p = new point[MAX];
		match = new int[MAX];
		used = new boolean[MAX];
		Arrays.fill(head, -1);
		num = 0;odd = 0; even = 0;
		for(int i=0;i<k;i++){
			st.nextToken();
			r = (int) st.nval;
			st.nextToken();
			c = (int) st.nval;
			board[r][c] = true;
			if(((r+c-2)&1)==1) odd++;
			else even++;
		} if(odd!=even){System.out.println("N0");return;}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(board[i][j]){
	                if(j>0&&board[i][j-1]){
	                    if(((i+j)&1)==1) add(i*n+j,i*n+j-1);
	                    else add(i*n+j-1,i*n+j);
	                }
	                if(i>0&&board[i-1][j]){
	                    if(((i+j)&1)==1) add(i*n+j,(i-1)*n+j);
	                    else add((i-1)*n+j,i*n+j);
	                }
	            }
	        }
	    }
		if(hungary(m*n)==(m*n-k)/2) System.out.println("YES");
	    else System.out.println("NO");
	}
	
	public static void add(int a,int b){
	    p[num] = new point(b,num++);
	    head[a] = num;
	}

	private static int hungary(int n){
	    Arrays.fill(match, -1);
	    int ans=0;
	    for(int i=0;i<n;i++){
	        Arrays.fill(used, false);
	        if(find(i))++ans;
	    }
	    return ans;
	}

	public static boolean find(int i){
	    for(int k=head[i];k!=-1;k=p[k].next){
	        int val=p[k].data;
	        if(!used[val]){
	            used[val]=true;
	            if(match[val]==-1||find(match[val])){
	                match[val]=i;
	                return true;
	            }
	        }
	    }return false;
	}

	
	public static class point{
		int data, next;
		public point(int data,int next){
			this.data = data;
			this.next = next;
		}
	}
}
