import java.util.*;
public class Main {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		DisjointSet set;
		for(int i=1;;i++){
			set = new DisjointSet();
			int a =in.nextInt(),b = in.nextInt();
			boolean flag = true;
			if(a<0&&b<1) break;
			while(true){
				if(a==0&& b==0){
					if(flag) flag = flag& set.check();
					if(!flag) System.out.println("Case "+i+" is not a tree.");
					else System.out.println("Case "+i+" is a tree.");
					break;
				} if(!set.merge(a,b)){
					flag = false;
				}
				a = in.nextInt(); b= in.nextInt();
			}
		}
	}
	
	private static class DisjointSet{
		HashMap<Integer,Integer> set;
		public DisjointSet(){
			set = new HashMap<Integer,Integer>();
		}
		public int find(int a){
			if(set.get(a)==a) return a;
			return find(set.get(a));
		}
		public boolean check(){
			int[] arr = new int[set.size()];
			int counter=0;
			for(int i:set.keySet()){
				arr[counter++] = i;
			}
			boolean ret = true;
			for(int i=1;i<arr.length;i++){
				if(find((int)arr[i])!=find((int)arr[i-1])){
					ret = false;
					break;
				}
			}return ret;
		}
		public boolean merge(int a, int b){
			boolean ret = true;
			if(!set.containsKey(a)) set.put(a,a);
			if(!set.containsKey(b)) set.put(b,b);
			if(set.get(a)==b) ret =false;
			int temp = set.remove(b);
			if(temp!=b)ret = false;
			if(b==a) ret = false;
			set.put(b,a);
			return ret;
		}
	}
}
