import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("electricity.in"));
		PrintWriter out = new PrintWriter("electricity.out");
		long a[],b[],asoc = 1, bsoc = 0;
		a = new long[in.nextInt()];
		b = new long[in.nextInt()];
		for(int i=0;i<a.length;i++){
			a[i] = in.nextLong();
		} for(int i=0;i<b.length;i++){
			b[i] = in.nextLong();
		} Arrays.sort(a); Arrays.sort(b);
		int aptr = a.length,bptr = b.length;
		for(;;){
			while(bsoc>0&&bptr>0){
				bsoc--;
				asoc+=b[--bptr];
			}
			if(aptr==0||bptr==0) break;
			asoc--;
			bsoc=a[--aptr];
		}out.println(asoc);
		out.close();
	}
}
