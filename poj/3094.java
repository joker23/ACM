import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String curr;
		for(;;){
			curr =  in.readLine();
			if(curr.equals("#")){
				break;
			}
			int val;
			int ret = 0;
			for(int i=0;i<curr.length();i++){
				val = (curr.charAt(i)<='Z' && curr.charAt(i)>='A')? curr.charAt(i)-'A'+1: 0;
				ret+= (i+1)*val;
			}
			System.out.println(ret);
		}
	}

}
