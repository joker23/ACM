import java.util.*;
public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		boolean i,d;
		int pre,curr;
		System.out.println("Gnomes:");
		while(test-->0){
			i=true;
			d=true;
			pre = in.nextInt();
			for(int j=1;j<3;j++){
				curr = in.nextInt();
				if(pre>curr) i =false;
				if(pre<curr) d =false;
				pre = curr;
			}if(i||d) System.out.println("Ordered");
			else System.out.println("Unordered");
		}
	}
}
