
import java.util.*;

public class H{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		int n =in.nextInt();
		Seg[] arr = new Seg[n];
		for(int i=0; i<n; i++){
			arr[i] = new Seg(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		}
		int ans = in.nextInt();
		int curry = 10000001;
		Arrays.sort(arr);
		for(int i=0; i<n; i++){
			Seg curr = arr[i];
			if(ans>=curr.minx && ans<=curr.maxx && curry>=curr.miny){
				if(curr.slope == 'l'){
					ans = curr.minx;
				}
				else {
					ans = curr.maxx;
				}
			}
			curry = curr.miny;
		}
		System.out.println(ans);
	}

	private static class Seg implements Comparable<Seg>{
		Integer maxx,minx,maxy,miny;
		char slope;
		
		public Seg(int x1,int y1, int x2, int y2){
			this.maxx = Math.max(x1,x2);
			this.minx = Math.min(x1,x2);
			this.maxy = Math.max(y1,y2);
			this.miny = Math.min(y1,y2);
			boolean a = x1 > x2;
			boolean b = y1 > y2;
			if(!(a^b)){
				slope = 'l';
			} else {
				slope = 'r';
			}
		}

		public int compareTo(Seg that){
			int ret = -  this.maxy.compareTo(that.maxy);
			//if(ret == 0){
				if(this.slope == that.slope){
					if(this.slope == 'r'){
						return -this.minx.compareTo(that.minx);
					}
					else{
						return this.maxx.compareTo(that.maxx);
					}
				}
			//}
			return ret;
		}
	}
}
