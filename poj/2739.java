import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true){
			int num = in.nextInt(),ret = 0;
			if(num==0) break;
			if(num<2){
				System.out.println(0);
				continue;
			}
			else if(num==2){
				System.out.println(1);
				continue;
			}
			boolean[] lookup = new boolean[num+1];
			for(int i = 2;i<lookup.length;i++) lookup[i] = true;
			for(int i = 2;i<Math.ceil(Math.sqrt(lookup.length));i++)
				for(int j=i*2;j<lookup.length;j+=i)lookup[j] = false;
			LinkedList<Integer> list = new LinkedList<Integer>();
			for(int i=2;i<lookup.length;i++){
				if(lookup[i]) list.add(i);
			}
			if(list.contains(num)) ret++;
			int start = 0, end = 1, val = list.get(start)+list.get(end);
			while(end<list.size()-1){
				if(val == num){ 
					ret++;
					val-=list.get(start++);
				}
				else if(val<num) val+=list.get(++end);
				else val-=list.get(start++);
			}
			System.out.println(ret);
		}
	}

}
