import java.util.*;
import java.math.*;

public class TeamBuilder {
	//SRM 184 div 2 1000

	public int[] specialLocations(String[] paths) {
		int[] res = new int[2];

		int n = paths.length;

		boolean[][] graph = new boolean[n][n];

		for(int i=0; i<n; i++){
			for(int j =0; j<n; j++){
				graph[i][j] = paths[i].charAt(j) == '1' || i == j ? true : false;
			}
		}

		for(int k=0; k<n; k++){
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++){
					graph[i][j] = graph[i][j] || (graph[i][k] && graph[k][j]);
				}
			}
		}

		for(int i=0; i<n; i++){
			boolean yes = true;
			for(int j=0; j<n; j++){
				if(!graph[i][j]){
					yes = false;
					break;
				}
			}
			if(yes){
				res[0] ++;
			}
		}

		for(int i=0; i<n; i++){
			boolean yes = true;
			for(int j=0; j<n; j++){
				if(!graph[j][i]){
					yes = false;
					break;
				}
			}
			if(yes){
				res[1] ++;
			}
		}

		return res;
	}

	private void print(boolean[][] graph) {
		for(int i=0; i<graph.length; i++){
			for(int j=0; j<graph[i].length; j++){
				System.out.print("[" + graph[i][j]+ "]");
			}System.out.println();
		}System.out.println();
	}


	//
}
