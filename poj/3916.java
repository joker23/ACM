import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n,pre,curr;
		HashSet<Integer> set;
		for(;;){
			st = new StringTokenizer(in.readLine());
			set = new HashSet<Integer>();
			n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			pre = Integer.parseInt(st.nextToken());
			System.out.print(pre+ " ");
			for(int i=1;i<n;i++){
				curr = Integer.parseInt(st.nextToken());
				if(curr!=pre) System.out.print(curr+" ");
				pre = curr;
			}System.out.println("$");
		}
	}
}
