import java.util.*;
public class Main2{
	static Scanner in;
	static int maxi;
	static int mini;
	static LinkedList<String> state;
	public static void main(String[] args){
		in = new Scanner(System.in);
		int test = in.nextInt();
		for(int t = 1; t<= test ;t++) {
			state = new LinkedList<String>();
			int n = in.nextInt();
			for(int i = 0 ; i< n*2+1; i++){
				state.add(in.next());
			}mini = maxi = 1;
			int p1 = dfs(state, true);
			int p1i = maxi;
			int p2 = dfs(state, false);
			int p2i = mini;
			System.out.println("Case "+ t+":");
			System.out.println("Player 1 ("+state.get(p1i-1)+state.get(p1i)+state.get(p1i+1)+") leads to " + p1);
			System.out.println("Player 2 ("+state.get(p2i-1)+state.get(p2i)+state.get(p2i+1)+") leads to " + p2);
			if(p1>p2*-1){
				System.out.println("Player 1 wins");
			} else if(p1<p2*-1){
				System.out.println("Player 2 wins");
			} else {
				System.out.println( "Tie");
			}
		}
	}
	private static int dfs(LinkedList<String> state, boolean turn){
		if(state.size() == 1){
			return Integer.parseInt(state.get(0));
		}
		if(turn){
			int max = Integer.MIN_VALUE;
			maxi=1;
			for(int i = 1; i<state.size(); i+=2){
				int tmp = dfs(genState(state, i) ,!turn);
				if(max < tmp){
					max = tmp;
					maxi = i;
				}
			}
			return max;
		} else {
			mini = 1;
			int min = Integer.MAX_VALUE;
			for(int i = 1; i<state.size(); i+=2){
				int tmp = dfs(genState(state,i), !turn);
				if(min > tmp){
					min = tmp;
					mini = i;
				}
			}
			return min;
		}
	}
	private static LinkedList<String> genState(LinkedList<String> state, int i){
		LinkedList<String> ret = new LinkedList<String>(state);
		char op = state.get(i).charAt(0);
		int n;
		if(op == '-'){
			n = Integer.parseInt(state.get(i-1)) - Integer.parseInt(state.get(i+1));
		} else if(op == '+'){
			n = Integer.parseInt(state.get(i-1)) + Integer.parseInt(state.get(i+1));
		} else if(op == '*'){
			n = Integer.parseInt(state.get(i-1)) * Integer.parseInt(state.get(i+1));
		} else {
			n = Integer.parseInt(state.get(i-1)) / Integer.parseInt(state.get(i+1));
		}
		ret.set(i,n+"");
		ret.remove(i+1);
		ret.remove(i-1);
		return ret;
	}
}

