import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader in;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
       	in = new BufferedReader(new InputStreamReader(System.in));
		int a,b,c,d,ans;
		for(;;){
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			ans = 0;
			if(a+b+c+d == 0){
				break;
			}
			while((a&b&c&d)!=(a|b|c|d)){
				ans++;
				int temp = a;
				a = Math.abs(a-b);
				b = Math.abs(b-c);
				c = Math.abs(c-d);
				d = Math.abs(d-temp);
			}
			System.out.println(ans);
		}
    }
}
