import java.util.*;
public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		for(;;){
			int L = in.nextInt(),M = in.nextInt(),start,end,ret = L+1;
			if(L==0&&M==0)break;
			while(M-->0){
				start = in.nextInt();
				end = in.nextInt();
				ret -= end-start+1;
			}System.out.println(ret);
		}
	}
}
