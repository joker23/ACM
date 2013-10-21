
import java.util.*;

public class G{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		boolean n = (in.nextInt()%2) == 0;
		String str1= in.next();
		String str2 = in.next();
		for(int i = 0; i<str1.length(); i++){
			if(n && str1.charAt(i) != str2.charAt(i)){
				System.out.println("Deletion failed");
				return;
			}
			if(!n && str1.charAt(i) == str2.charAt(i)){
				System.out.println("Deletion failed");
				return;
			}
		}
		System.out.println("Deletion succeeded");
	}
}
