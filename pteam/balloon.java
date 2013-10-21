
import java.util.*;

public class Main{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		int n, a, b;
		room[] arr;
		while((n =in.nextInt()) + (a = in.nextInt()) + (b = in.nextInt()) > 0 ){
			arr = new room[n];
			for(int i=0; i<n; i++){
				arr[i] = new room(in.nextInt(), in.nextInt(), in.nextInt());
			}
			Arrays.sort(arr);
			int ans = 0;
			for(int i=0; i<n; i++){
				room tmp = arr[i];
				if(tmp.a<tmp.b){
					int t = Math.min(tmp.need, a);
					ans += tmp.a * t;
					tmp.need -= t;
					a -= t;
					if(tmp.need>0){
						ans += tmp.need*tmp.b;
						b -= tmp.need;
					}
				} else {
					int t = Math.min(tmp.need, b);
					ans += tmp.b * t;
					tmp.need -= t;
					b -= t;
					if(tmp.need> 0){
						ans+= tmp.a * tmp.need;
						a -= tmp.need;
					}
				}
			}
			System.out.println( ans);
		}
	}

	public static class room implements Comparable<room>{
		Integer a, b, need;
		public room(int need, int a, int b){
			this.a = a;
			this.b = b;
			this.need = need;
		}

		public int compareTo(room r){
			return ((Integer)Math.abs(r.a - r.b)).compareTo(((Integer)Math.abs(a - b)));
		}
	}
}
