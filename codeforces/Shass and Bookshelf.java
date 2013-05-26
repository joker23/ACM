import java.util.*;
public class Main {

	public static void main(String[] args){
		Scanner in =  new Scanner(System.in);
		int n = in.nextInt(),t1[],t2[],th,w,tots = 0,ans;
		LinkedList<Integer> w1 = new LinkedList<Integer>() , w2 = new LinkedList<Integer>();
		for(int i=0;i<n;i++){
			th = in.nextInt(); w = in.nextInt();
			if(th==1) w1.add(w);
			else w2.add(w);
			tots+=w;
		}t1 = new int[w1.size()];
		t2 = new int[w2.size()];
//		System.out.println(tots);
		for(int i=0;i<t1.length;i++){
			t1[i] = w1.poll();
		}for(int i=0;i<t2.length;i++){
			t2[i] = w2.poll();
		}
		
		Arrays.sort(t1); Arrays.sort(t2);
		ans = Integer.MAX_VALUE;
		for(int i=t1.length-2;i>=0;i--){
			t1[i]+=t1[i+1];
		}for(int i=t2.length-2;i>=0;i--){
			t2[i]+=t2[i+1];
		} for(int i=0;i<t1.length;i++)
			for(int j=0;j<t2.length;j++)
				if(t1.length-i + 2*(t2.length-j)>=tots-t1[i]-t2[j])
					ans = Math.min(ans,t1.length-i + 2*(t2.length-j));
		for(int i=0;i<t1.length;i++)
			if(t1.length-i>=tots-t1[i])
				ans = Math.min(ans,t1.length);
		for(int j=0;j<t2.length;j++)
			if( 2*(t2.length-j)>=tots-t2[j])
				ans = Math.min(ans,2*(t2.length-j));
		System.out.println(ans);
//		print(t1);
//		print(t2);
	}
	private static void print(int[] arr){
		for(int i: arr)
				System.out.print("["+i+"]");
		System.out.println();
	}
}
