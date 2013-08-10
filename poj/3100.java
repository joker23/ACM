import java.util.*;
public class Main {
	public static void main(String[] ponies){
		Scanner in = new Scanner(System.in);
		for(int b = in.nextInt(),n = in.nextInt();b>0&&n>0;b=in.nextInt(),n=in.nextInt()){
			int a = 0,d = b, t = (int) Math.abs(Math.pow(a+1, n)-b);
			while(t<d){
				a++;
				d=t;
				t = (int) Math.abs(Math.pow(a+1,n) - b);
			}System.out.println(a);
		}
	}
}
