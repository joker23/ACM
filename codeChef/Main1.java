
import java.util.*;

public class Main{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		int test = in.nextInt();
		int minI = 0;
		int maxI = 0;
		HashSet<Double> set = new HashSet<Double>();
		double min = Double.MAX_VALUE;
		double max = -1;
		boolean rep = false;
		for(int i = 0; i<test; i++){
			double curr = area(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
			if(!set.contains(curr))
				set.add(curr);
			else{
				rep = true;
				break;
			}
			if(curr<min){
				minI = i+1;
				min = curr;
			}
			if(curr>max){
				maxI = i+1;
				max = curr;
			}
		}
		if(!rep)
			System.out.println(minI + " " + maxI);
		else
			System.out.println(test);
	}

	private static double area(int a1,int a2, int b1, int b2, int c1, int c2){
		double sum = a1*(b2-c2) + b1*(c2-a2) + c1*(a2 - b2);
		double ans = Math.abs(sum/2);
		return ans;
	}
}
