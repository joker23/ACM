import java.io.*;
import java.util.*;
public class Main {
	static int[] mask = {9,3,7};
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(),test,ans,index;
		String curr;
		for(int num=1;num<=t;num++){
			System.out.println("Scenario #"+num+":");
			test =0;
			index = 0;
			curr = in.next();
			for(int i=0,p = curr.length()-1;p>=0;i++,p--){
				if(curr.charAt(p)!='?'){
					test += mask[i%3]*((int)curr.charAt(p)-'0');
				}else{
					index = i;
				}
			}ans = 0;
			while(test%10!=0){
				ans++;
				test+=mask[index%3];
			}for(int i=0;i<curr.length();i++){
				if(curr.charAt(i)=='?'){System.out.print(ans);continue;}
				System.out.print(curr.charAt(i));
			}System.out.println("\n");
		}
	}
}
