import java.util.*;
import java.io.*;
public class Main {
//	s(i) = a(2*i-1) + a(2*i)
//	d(i) = a(2*i-1) - a(2*i)
	static int[] input;
	static Stack<int[]> stack;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String line;
		while(true){
			st = new StringTokenizer(in.readLine());
			int l = Integer.parseInt(st.nextToken());
			if(l==0) break;
			input = new int[l];
			int counter = 0;
			while(st.hasMoreTokens()){
				input[counter++] = Integer.parseInt(st.nextToken());
			} int[] ans = new int[input.length];
//			print(s(input));
//			print(d(input));
			stack = new Stack<int[]>();
			solve(input);
			while(!stack.isEmpty()){
				print(stack.pop());
			}System.out.println();
		}
	}
	
	public static void solve(int[] arg){
		int[] curr = arg;
		while(curr.length>1){
			stack.add(s(curr));
			curr = d(curr);	
		}stack.add(curr);
	}
	
	public static int[] s(int[] arr){
		int[] ret = new int[arr.length/2];
		for(int i=0;i<arr.length-1;i+=2){
			ret[i/2] = arr[i] + arr[i+1]; 
		}return ret;
	}
	public static int[] d(int[] arr){
		int[] ret = new int[arr.length/2];
		for(int i=0;i<arr.length-1;i+=2){
			ret[i/2] = arr[i] - arr[i+1]; 
		}return ret;
	}
	
	public static void print(int[] arr){
		for(int i: arr){
			System.out.print("[" + i + "]");
		}//System.out.println();
	}
}
