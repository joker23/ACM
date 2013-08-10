import java.util.*;
public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String ret = "";
		for(int i=0;i<n;i++){
			int curr = Integer.parseInt(in.next());
			if(curr==0) ret = curr+" "+ret;
			else ret+=curr+" ";
		}System.out.println(ret.trim());
	}
}
