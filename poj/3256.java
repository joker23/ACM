import java.util.*;
public class Main {
	static boolean[] connect,temp;
	static int[] start;
	static LinkedList<Integer>[] graph;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int k = in.nextInt(), n = in.nextInt(),m = in.nextInt();
		start = new int[k];
		for(int i=0;i<k;i++){
			start[i] = in.nextInt();
		}graph = new LinkedList[m+1];
		for(int i=0;i<graph.length;i++){
			graph[i] = new LinkedList<Integer>();
		}while(m-->0){
			graph[in.nextInt()].add(in.nextInt());
		}connect = new boolean[n+1];
		temp = new boolean[n+1];
		Arrays.fill(connect,true);
		for(int i=0;i<start.length;i++){
			Arrays.fill(temp,false);
			temp[start[i]] = true;
			dfs(start[i]);
			for(int j=0;j<connect.length;j++){
				connect[j] = connect[j]&&temp[j];
			}
		}int ans = 0;
		for(boolean b:connect){
			if(b) ans++;
		}System.out.println(ans);
		
	}
	public static void dfs(int curr){
		for(int n:graph[curr]){
			if(temp[n]) continue;
			temp[n] = true;
			dfs(n);
		}
	}	
}
