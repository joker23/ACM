import java.io.*;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long n;
		for(int test=1;;test++){
			n =	Long.parseLong(in.readLine().trim());
			if(n==0) break;
			n*=3;
			System.out.print(test+". ");
			if(n%2==1){
				System.out.print("odd ");
				n/=2;
			} else{
				System.out.print("even ");
				n = (n+1)/2;
			} n*=3;
			System.out.println(n/9);
			
		}
	}
}
