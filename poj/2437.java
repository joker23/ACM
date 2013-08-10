import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken()),s[],e[],ans=0,curr=-1,tmp;
		s = new int[n];
		e = new int[n];
		for(int i=0;i<n;i++){
			st = new StringTokenizer(in.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			e[i] = Integer.parseInt(st.nextToken());
		}Arrays.sort(s); Arrays.sort(e);
		for(int i=0;i<s.length;i++){
			//curr keeps track of where we are
			if(curr<s[i]){
				tmp = (e[i]-s[i]+l-1)/l; //ceil
				ans+=tmp;
				curr = s[i]+ tmp*l-1;
			}else if(curr<e[i]){
				tmp = (e[i]-curr-2+l)/l;
				ans+=tmp;
				curr+=tmp*l;
			} 
		}System.out.println(ans);
	}
}
