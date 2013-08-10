import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num =  in.nextInt();
		while(num-->0){
			String str = in.next();
			String strrev = "";
			for(int i=str.length()-1;i>=0;i--){
				strrev+= str.charAt(i);
			}
			String g = in.next();
			int ret1 = 0, ret2 = 0;
			boolean found = false;
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)==g.charAt(ret1)) ret1++;
				if(strrev.charAt(i)==g.charAt(ret2)) ret2++;
				if(ret1==g.length() || ret2 == g.length()){
					found = true;
					break;
				}
			}
			if(found){
				System.out.println("YES");
			} else{
				System.out.println("NO");
			}
		}
	}

}
