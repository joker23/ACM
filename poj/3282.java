import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num = in.nextInt(),l,m;
		LinkedList<Integer> left = new LinkedList<Integer>();
		LinkedList<Integer> right = new LinkedList<Integer>();
		while(num-->0){
			l = in.nextInt()*100;m=in.nextInt();
			int car; String dir;
			for(int i=0;i<m;i++){
				car = in.nextInt(); dir = in.next();
				if(dir.equals("left"))left.add(car);
				else right.add(car);
			}
			int ret = 0;
			boolean isLeft = true;
			while(!left.isEmpty()||!right.isEmpty()){
				int temp = 0;
				if(isLeft){
					while(!left.isEmpty()&&temp+left.peek()<=l){
						temp+=left.poll();
					} ret++;
					isLeft =  !isLeft;
				}else{
					while (!right.isEmpty()&&temp+right.peek()<=l){
						temp+=right.poll();
					} ret++;
					isLeft = !isLeft;
				}
			}System.out.println(ret);
		}
	}
}
