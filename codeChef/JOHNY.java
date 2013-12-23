
import java.util.*;

public class Main{
	static Scanner in;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = in.nextInt();
			}
			int index = in.nextInt()-1;
			int res = arr[index];
			Arrays.sort(arr);
			for(int i=0;i<arr.length;i++){
				if(arr[i] == res){
					System.out.println(i+1);
					break;
				}
			}
		}
	}
}

