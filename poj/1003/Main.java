import java.util.*;
public class Main {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in); 
		double curr;
		while(true){
			curr = in.nextDouble();
			if(curr == 0.00) break;
			double text = 0;
			for(int i=1;;i++){
				text+=1.0/(i+1);
				if(text>curr){
					System.out.println(i+" card(s)");
					break;
				}
			}
		}
	}
}
