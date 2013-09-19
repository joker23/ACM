
import java.util.*;

public class E{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		int tt = in.nextInt();
		while(tt-->0){
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] boo = new int[m][n];
			int err = 0;
			for(int i = 0 ;i<boo.length ;i++){
				for(int j=0 ;j<boo[i].length;j++){
					int tmp = in.nextInt();
					if(tmp == 0){
						err = 3;
					}
					else if(tmp>boo.length){
						err = Math.max(2,err);
					}
					else if(boo[i][Math.abs(tmp)-1]!=0){
						err = Math.max(1,err);
					} else{
						boo[i][Math.abs(tmp)-1] = (tmp/Math.abs(tmp));
					}
				}in.nextInt();	
			}
			if(err==1){
				System.out.println("INVALID: RUNE CONTAINS A REPEATED RING");
			}
			else if(err == 2){
				System.out.println("INVALID: RING MISSING");
			}
			else if(err == 3){
				System.out.println("INVALID: NULL RING");
			}
		}
	}
}
