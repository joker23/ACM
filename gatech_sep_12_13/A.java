
import java.util.*;

public class A{
	static Scanner in;
	static int[] good = {1,2,3,3,4,10};
	static int[] evil={1,2,2,2,3,5,10};
	public static void main(String[] args){
		in = new Scanner(System.in);
		int test = in.nextInt();
		for(int i = 0; i<test; i++){
			int g = 0;
			int e = 0;
			for(int j=0; j<good.length; j++){
				g+= in.nextInt()*good[j];
			}
			for(int j=0; j<evil.length; j++){
				e+= in.nextInt()*evil[j];
			}
			if(e>g){
				System.out.println("Battle "+(i+1)+": Evil eradicates all trace of Good");
			}
			else if(e<g){
				System.out.println("Battle "+(i+1)+": Good triumphs over Evil");
			}
			else{
				System.out.println("Battle "+(i+1)+": No victor on this battle field");
			}
		}
	}
}
