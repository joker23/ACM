
import java.util.*;

public class D{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		int n = in.nextInt();
		int inf = Integer.MAX_VALUE;
		int[] lo = new int[2001];
		int[] hi = new int[2001];
		Arrays.fill(lo, inf);
		Arrays.fill(hi, inf);	
		double ans = Double.MIN_VALUE;
		while(n-->0){
			int ind = in.nextInt()+1000;
			int val = in.nextInt();
			if(hi[ind] == inf){
				hi[ind] = val;
			} else {
				int low = Math.min(hi[ind],Math.min(lo[ind],val));
				int high = Math.max(hi[ind], val);
				lo[ind] = low;
				hi[ind] = high;
				ans = Math.max(ans, dist(ind,ind,low,high));
			}
		}
		for(int i=0; i<2001; i++){
			if(hi[i]!=inf){
				for(int j=i; j>=0; j--){
					if(hi[j]!=inf){
						ans = Math.max(ans,dist(i,j,hi[i],hi[j]));
						if(lo[i]!=inf){
							ans = Math.max(ans,dist(i,j,lo[i],hi[j]));
							if(lo[j]!=inf){
								ans = Math.max(ans,dist(i,j,lo[i],lo[j]));
							}
						}
						if(lo[j]!=inf){
							ans = Math.max(ans,dist(i,j,hi[i],lo[j]));
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

	public static double dist(int x1,int x2,int y1,int y2){
		return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
	}
}
