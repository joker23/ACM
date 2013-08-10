import java.util.*;
public class Main {
	static final int MAX = 100;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt(), r = in.nextInt();
			if(n==0&&r==0) break;
			long[][] tab =  new long[MAX+1][MAX+1];
			for (int i=0; i<tab.length; i++){
				tab[i][0] = 1;
				for (int j=1; j<=i; j++)
						tab[i][j] = tab[i-1][j-1] + tab[i-1][j];
			}System.out.println(n+" things taken "+r+" at a time is "+tab[n][r]+" exactly.");
		}
	}
}
