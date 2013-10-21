
import java.util.*;

public class D{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		int a,b;
		LinkedList<Integer> list = new LinkedList<Integer>();
		int curr = 1;
		int num = 1;
		for(int i = 1; i*i<1000000001; i++){
			int temp = i*i;
			while(curr<temp-1){
				num ++;
				curr += num;
			}
			if(curr == temp-1){
				list.add(temp);
			}
		}
		int counter = 1;
		while((a = in.nextInt())+ (b=in.nextInt()) > 0){
			int ans = 0;
			for(int i: list){
				if(i>a && i<b){
					ans++;
				}
			}
			System.out.println("Case " + (counter++)+ ": " + ans);
		}
	}
}
