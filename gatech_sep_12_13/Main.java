
import java.util.*;

public class Main{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		int n,a,b;
		while((n = in.nextInt()) +
				(a = in.nextInt()) +
				(b = in.nextInt()) > 0){
			Node[] arr = new Node[n];
			for(int i = 0; i<n; i++){
				arr[i] = new Node(in.nextInt(),in.nextInt(),in.nextInt());
			}
			Arrays.sort(arr);
			int i = 0, ans = 0;
			while(a>0 && b>0 && i<n){
				if(arr[i].a < arr[i].b){
					int tmp= Math.min(arr[i].a, a);
					arr[i].n -= tmp;
					ans += tmp*arr[i].a;
					if(arr[i].n == 0){
						i ++;
					}
				} else {
					int tmp = Math.min(arr[i].b,b);
					arr[i].n -= tmp;	
					ans += tmp*arr[i].b;
					if(arr[i].n == 0){
						i ++;
					}
				}
			}
			while(a>0 && i<arr.length){
				int tmp= Math.min(arr[i].a, a);
				arr[i].n -= tmp;
				ans += arr[i].n * tmp;
				i++;
			}
			while(b>0 && i<arr.length){
				int tmp= Math.min(arr[i].b, b);
				arr[i].n -= tmp;
				ans += arr[i].b * tmp;
				i++;
			}System.out.println(ans);
		}
	}



	/**
	 * information holder
	 */
	private static class Node implements Comparable<Node>{
		Integer n,a,b,comp;

		public Node(int n, int a,int b){
			this.n = n;
			this.a = a;
			this.b = b;
			this.comp = Math.abs(a-b);
		}

		public int compareTo(Node node){
			return comp.compareTo(node.comp);
		}
	}
}
