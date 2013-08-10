import java.util.*;
public class Main {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] arr;
		int test = in.nextInt();
		while(test-->0){
			System.out.print(in.nextInt()+" ");
			arr = new int[10];
			for(int i=0;i<arr.length;i++){
				arr[i] = in.nextInt();
			} Arrays.sort(arr);
			System.out.println(arr[7]);
		}
	}
}
