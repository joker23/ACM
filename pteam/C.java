
import java.util.*;

public class C{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		double n = in.nextDouble();
		int counter = 1;
		boolean found = false;
		LinkedList<String> ans = new LinkedList<String>();
		for(int i = 1; i<100001; i++){
			int num = (int)(n*i);
			if((n*i)%1 == 0){
				if(check(i, num)){
					System.out.println(i);
					ans.add(i+"");
					found = true;
				}
			}
		}
		for(int i=0; i<ans.size(); i++){
			String curr = ans.get(i);
			if(curr.length()>2 && curr.length()<5){
				System.out.println(curr+curr);
			}
		}
		if(!found){
			System.out.println("No solution");
		}
	}

	public static boolean check(int a, int b){
		int add = b%10;
		b/=10;
		boolean ret = true;
		for(int i=0;b>0; i++){
			int tmp = a%10;
			int tmp2 = b%10;
			b/=10;
			a/=10;
			ret&= tmp == tmp2;
		}
		return ret&(a == add);
	}
}
