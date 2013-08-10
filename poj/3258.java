import java.util.*;
public class Main {
	private static final int INF = Integer.MAX_VALUE;
	private static int n,m,L,arr[];
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int i,l,r,mi;
		L = in.nextInt();
		n = in.nextInt();
		m = in.nextInt();
		l = 0;
		r = L;
		arr = new int[100010];
		for(i=1;i<=n;i++){
			arr[i] = in.nextInt();
			r+=arr[i];
		}Arrays.sort(arr,1,n+1);
		while(l<r){
			mi = ((l+r)>>1);
			if(bi(mi)) l=mi+1;
			else r=mi;
		}System.out.println(r);
	}
	
	private static boolean bi(long x){
		int i,count = 0, curr = 0;
		for(i = 1; i <=n; i++){
			if(arr[i] - arr[curr] <= x) count++;
			else curr = i;
		}if(L-arr[curr]<x) return false;
		return count<=m;
	}
}
