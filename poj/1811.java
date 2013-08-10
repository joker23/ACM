import java.util.*;
public class Main {
	static final String Y = "Prime";
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			long n = in.nextLong();
			if(n==2||n==3){
				System.out.println(Y);
				continue;
			}if(n%2==0){
				System.out.println(2);
				continue;
			} else if(n%3==0){
				System.out.println(3);
				continue;
			}
			int stop = (int) Math.sqrt(n)+2;
			boolean found = false;
			for(int i=6;i<=stop;i+=6){
				if(n%(i-1)==0){
					System.out.println(i-1);
					found = true;
					break;
				} if (n%(i+1)==0){
					System.out.println(i+1);
					found = true;
					break;
				}
			}if(!found) System.out.println(Y);
		}
	}
}
