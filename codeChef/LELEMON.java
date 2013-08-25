import java.util.*;

public class Main{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		//number of test cases
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt(); //rooms
			int m = in.nextInt(); 
			int visitOrder[] = new int[m];
			for(int i = 0; i<m; i++){
				visitOrder[i] = in.nextInt();
			} LinkedList<int[]> rooms = new LinkedList<int[]>();
			int c; //size of room
			int ptr[] = new int[n];
			for(int i = 0; i<n; i++){
				c = in.nextInt();
				int temp[] = new int[c];
				for(int j = 0; j<c; j++){
					temp[j] = in.nextInt();
				} Arrays.sort(temp);
				ptr[i] = c-1;
				rooms.add(temp);
			}int ans = 0;
			for(int i : visitOrder){
				if(ptr[i] >= 0){
					ans += rooms.get(i)[ptr[i]--];
				}
			}System.out.println(ans);
		}
	}
}
