
import java.util.*;

public class Main{
	static Scanner in;
	static String[] arr;
	public static void main(String[] args){
		in = new Scanner(System.in);
		int test = in.nextInt();
		arr = new String[1000];
		arr[0] = "1,";
		arr[1] = "1,2,1";
		for(int i = 2; i<arr.length; i++){
			String[] tmp =  arr[i-1].split(",");
			String tmp = "1,"
			for(int j = 1; j<arr.length; j++){
				int add = Integer.parseInt(arr[j]) - Integer.parseInt(arr[j-1]);
				temp+=add+",";
			}
			arr[i]= temp+"1,";
		}
		while(test-->0){
			
		}
	}
}
