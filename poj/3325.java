import java.util.*;
public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int curr,tot,num,max,min;
		for(max = -INF,min=INF,tot=0;;max = -INF,min=INF,tot=0){
			if((num = in.nextInt())==0) break;
			for(int i=0;i<num;i++){
				curr = in.nextInt();
				max = Math.max(curr,max);
				min = Math.min(curr, min);
				tot += curr;
			}System.out.println((tot-max-min)/(num-2));
		}
	}
}
