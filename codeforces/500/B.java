package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B500 {

	private static BufferedReader in;
	private static StringTokenizer st;
	private static boolean[][] graph;
	private static int[] arr;
	private static int n;
	
	static {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] args) throws IOException{
		scan();
		floyd();
		
		// print(graph);
		
		// Bubble sort
		for (int i=0; i<n; i++) {
			int tmp = arr[i];
			int index = i;
			
			for (int j=i + 1; j<n; j++) {
				if (graph[i][j] && arr[j] < tmp) {
					tmp = arr[j];
					index = j;
				}
			}
			
			arr[index] = arr[i];
			arr[i] = tmp;
		}
		
		print(arr);
	}
	
	private static void print(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(" ");
			} else {
				System.out.println();
			}
		}
	}
	
	private static void print(boolean[][] arr) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print("[" + (arr[i][j] ? "1" : "0") + "]");
			}
			System.out.println();
		}
	}
	
	private static void floyd() {
		for (int k=0; k<n; k++) {
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					graph[i][j] |= graph[i][k] && graph[k][j];
				}
			}
		}
	}
	
	private static void scan() throws IOException{
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(in.readLine());
		
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new boolean[n][n];
		
		for (int i=0; i<n; i++) {
			String tmp = in.readLine();
			
			for (int j=0; j<n; j++) {
				graph[i][j] = tmp.charAt(j) == '1';
			}
		}
	}
}
