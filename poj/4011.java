import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num = in.nextInt(),ret=0;
		if((num&1)==0&&num/2<100){
			System.out.println(2*(100-num/2-1)+1);
		} else if (num/2<100){
			System.out.println(2*(100-num/2-1));
		} else{
			System.out.println(0);
		}
	}
}
