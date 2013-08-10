import java.util.*;
public class Main {
	final static int maxLen = 10;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		while(num-->0){
			int n = in.nextInt();
			String[] lookup = new String[n]; 
			for(int i=0;i<lookup.length;i++)lookup[i] = in.next();
			Arrays.sort(lookup);
			boolean flag = true;
			for(int i=1;i<lookup.length&&flag;i++){
				try{
					if(lookup[i-1].equals(lookup[i].substring(0,lookup[i-1].length()))) flag=false;
				}catch(Exception e){}
			}
			if(flag) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
