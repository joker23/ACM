import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] arr = new int[num];
		for(int i=0;i<num;i++){
			arr[i] = in.nextInt();
		}
		if(num==1){
			System.out.println(arr[0]);
			return;
		}
		Arrays.sort(arr);
		int ptr2 = 0, ptr1 = 0;
		while(ptr2<num){
			ptr1++; ptr2+=2;
		}
		System.out.println(arr[ptr1-1]);
	}
}
