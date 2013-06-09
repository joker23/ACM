import java.io.*;
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(in.readLine()),n,count;
		while(test-->0){
			n = Integer.parseInt(in.readLine());
			count = 0;
			while(n!=0){
				count+=n/5;
				n/=5;
			} System.out.println(count);
		}
	}
}
