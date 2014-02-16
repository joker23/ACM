import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	//IO tools
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;

	//static variables
	static int n, k;
	static Fighter[] fighters;
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		//code starts here
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		fighters = new Fighter[n];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(in.readLine());
			fighters[i] = new Fighter(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	
		int minEffort = Integer.MAX_VALUE;
		for(int i=0; i < 1<<(n+1); i++){
			int place = findPlace(i);
			if(place <= k){
				int effort = findEffort(i);
				minEffort = Math.min(minEffort, effort);
			}
		}
		
		if(minEffort == Integer.MAX_VALUE){
			out.println(-1);
		} else{
			out.println(minEffort);
		}

		out.flush();
	}

	private static int findPlace(int beaten){
		int points = 0;
		for(int i=0; i<n; i++){
			if((beaten & (1<<i)) > 0 ){
				points ++;
			}
		}
		
		int place = n + 1;
		for(int i=0; i < n; i++){
			int opponent = ((beaten & (1<<i)) > 0) ? fighters[i].p : fighters[i].p + 1;
			if(points > opponent){
				place --;
			}
			else if (points == fighters[i].p){
				if((beaten & (1 << i)) > 0){
					place --;
				}
			}
		}

		return place;
	}

	private static int findEffort(int beaten){
		int effort = 0;
		for(int i=0; i<n; i++){
			if((beaten & (1<<i)) > 0 ){
				effort += fighters[i].e;
			}
		}
		return effort;
	}

	private static class Fighter implements Comparable<Fighter>{
		Integer p, e;

		public Fighter(int p, int e){
			this.p = p;
			this.e = e;
		}

		public int compareTo(Fighter f){
			return this.e.compareTo(f.e);
		}
	}

	//helper functions
}
