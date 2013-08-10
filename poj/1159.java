import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String a = in.next(),b = "";
		for(int i=0;i<a.length();i++){
			b+=a.charAt(n-1-i);
		} int[] curr = new int[n],tmp= new int[n],look = new int[n];
		curr[0] = tmp[0] = look[0] = a.charAt(0)==b.charAt(0)? 1:0;
		for (int i=1; i<a.length(); i++)
				look[i] = Math.max(look[i-1], (a.charAt(i)==b.charAt(0)? 1:0));
		for (int j=1; j<b.length(); j++)
				tmp[j] = tmp[j] = Math.max(tmp[j-1], (a.charAt(0)==b.charAt(j)? 1:0));
		for (int i=1; i<a.length(); i++){
				curr[0] = look[i];
				for (int j=1;j<b.length(); j++){
					if (a.charAt(i) == b.charAt(j)) curr[j] = tmp[j-1]+1;
					else curr[j] = Math.max(tmp[j], curr[j-1]);
				} for(int k=0;k<n;k++) tmp[k] = curr[k];
		}
		System.out.println(n-curr[n-1]);
	
	}
}
