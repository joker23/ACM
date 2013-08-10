import java.util.*;
import java.io.*;
public class Main {
	//TLE
	static List<Integer>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(in.readLine().trim()),q = Integer.parseInt(in.readLine().trim());
		graph =  new LinkedList[n+1];
		for(int i=0;i<graph.length;i++) graph[i] = new LinkedList<Integer>();
		String command;
		while(q-->0){
			st = new StringTokenizer(in.readLine());
			command = st.nextToken();
			if(command.equals("Q")) query(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			else if(command.equals("I")) insert(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			else delete(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}	
	}
	
	private static void query(int a, int b){
		LinkedList<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		q.add(a);
		int curr;
		boolean found = false;
		while(!q.isEmpty()&&!found){
			curr = q.poll();
			if(visited.contains(curr)) continue;
			visited.add(curr);
			if(curr == b){
				found =true;
				break;
			} for(int i: graph[curr]){
				if(!visited.contains(i))
					q.addLast(i);
			}
		}if(found) System.out.println("Y");
		else System.out.println("N");
	}
	
	private static void insert(int a, int b){
		graph[a].add(b);
		graph[b].add(a);
	}
	
	private static void delete(int a, int b){
		graph[a].remove((Integer)b);
		graph[b].remove((Integer)a);
	}
}
