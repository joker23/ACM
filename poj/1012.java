import java.util.*;
public class Main {
	public static void main(String[] args){
		int x[] = { 2, 7, 5, 30, 169, 441, 1872, 7632, 1740, 93313, 459901, 1358657, 
			    2504881 };
		
		Scanner in = new Scanner(System.in);
		for(int i = in.nextInt();i!=0;i = in.nextInt()){
			System.out.println(x[i-1]);
		}
	}
}
