import java.util.*;
public class Main {
	final static int maxLen = 1299709 + 1;
	public static void main(String[] args){
		Scanner in =  new Scanner(System.in);
		for(int num = in.nextInt();num!=0;num = in.nextInt()){
			boolean[] dp =  new boolean[maxLen];
			Arrays.fill(dp,true);
			for(int i = 2; i<Math.sqrt(dp.length);i++){
				if(dp[i])
					for(int j=i*2;j<maxLen;j+=i)
						dp[j] = false;
			} int left = num, right = num;
			while(!dp[left]) left--;
			while(!dp[right]) right++;
			System.out.println(right-left);
		}
	}
}
