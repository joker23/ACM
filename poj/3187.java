import java.util.*;
public class Main {
	static String str = "1234567890",ans;
	static boolean flag;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[][] pascal = new int[10][10];
		for(int i=0;i<pascal.length;i++) pascal[i][i] = pascal[i][0] = 1;
		for(int i=2;i<10;i++)
			for(int j=1;j<i;j++)
				pascal[i][j] = pascal[i-1][j-1]+pascal[i-1][j];
		int n = in.nextInt(), sum = in.nextInt();
		int[] arr = pascal[n-1];
		flag = false;
		permutation("",str.substring(0,n),arr,sum);
		String ret ="";
		for(int i=0;i<ans.length();i++){
			if(ans.charAt(i)=='0') ret+=10;
			else ret+=ans.charAt(i);
			ret+=" ";
		}
		System.out.println(ret);
		
	}
	private static void permutation(String prefix, String str, int[] arr,int sum) {
	    if (str.length() == 0){
	    	//System.out.println(prefix);
	    	int test = 0;
	    	for(int i=0;i<prefix.length();i++){
	    		if(prefix.charAt(i)!='0')
	    			test+= ((int)prefix.charAt(i)- (int)'0') * arr[i];
	    		else test+= 10*arr[i];
	    	} if(test==sum){
	    		ans = prefix;
	    		flag = true;
	    		return;
	    	}
	    }else {
	    	if(flag) return;
	        for (int i = 0; i < str.length(); i++)
	   			permutation(prefix+str.charAt(i),str.substring(0,i) +str.substring(i+1,str.length()),arr,sum);
	    }
	}
}
