import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num =  in.nextInt();
		int[] lookup =  new int[num];
		int[] cache = new int[num];
		for(int i=0;i<num;i++){
			lookup[i] = in.nextInt();
		}
		
		Arrays.fill(cache,1);
		int ret = 0;
		for(int i =0; i<cache.length;i++){
			for(int j = i+1;j<cache.length;j++){
				if(lookup[j] > lookup[i]){
					cache[j] = Math.max(cache[j],cache[i]+1);
				}
			}
			ret = Math.max(ret,cache[i]);
		}
		System.out.println(ret);
	}
}
