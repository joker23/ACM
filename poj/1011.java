import java.util.*;
import java.math.*;
import java.io.*;

public class Main{

	static Scanner in;
	static  int n,
				sticks[],
				len,
				num,
				sumLen;
	static boolean used[];
	//partition problem...np
	public static void main(String[] args) throws IOException{
		in = new Scanner(System.in);

		while((n = in.nextInt()) != 0){
			//fill in the array
			int[] tmp = new int[n];
			sticks = new int[n];
			sumLen = 0;
			for(int i=0;i<n; i++){
				tmp[i] = in.nextInt();
				sumLen += tmp[i];
			}

			Arrays.sort(tmp);

			for(int i=0;i<n;i++){
				sticks[n-i-1] = tmp[i];
			}

			//sorting reverse...I don't know why I must do this...

			boolean done = false;
			used = new boolean[n];
			for(len = sticks[0]; len<=sumLen/2; len++){
				if(sumLen%len != 0){ //if you cant partition it this way
					continue;
				}

				num  = sumLen/len; //length of each partition
				used[0] = true;

				if(dfs(0, len-sticks[0], 0)) {
					done = true;
					System.out.println(len);
					break;
				}
				used[0] = false;
			}

			if(!done){
				System.out.println(sumLen);
			}
		}
	}

	public static boolean dfs(int cur, int left, int level){
		if(left == 0) {
			if(level == num-2)
				return true;
			for(cur = 0; used[cur]; cur++); //find the first one that has not been used
			used[cur] = true; //use that one
			if(dfs(cur+1, len-sticks[cur], level+1)){
				return true;
			}
			used[cur] = false;
			return false;
		} else {
			if(cur >= n-1){
				return false;
			}
			for(int i = cur; i < n; i++) {
				if(used[i]){
					continue;
				}
				if((sticks[i] == sticks[i-1]) && !used[i-1]){
					continue;
				}
				if(sticks[i] > left){
					continue;
				}
				used[i] = true;
				if(dfs(i, left-sticks[i], level)){
					return true;
				}
				used[i] = false;
			}
			return false;
		}
	}
}

