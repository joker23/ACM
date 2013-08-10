import java.util.*;
public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		for(;;){
			int n = in.nextInt(),m =in.nextInt(),p=in.nextInt(),c = in.nextInt(),ans = 0;
			if(n+m+p+c == 0) break;
			System.out.println(n+p-m);
		}
	}
}
