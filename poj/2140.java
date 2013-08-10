import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int ret=0, num = in.nextInt();
		for(int i=1;i*(i+1)/2<=num;i++)
			if((num-i*(i+1)/2)%i==0)
			    ret++;
		System.out.println(ret);
	}
}
