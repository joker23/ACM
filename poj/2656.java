import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		for(int num = in.nextInt();num!=0;num=in.nextInt()){
			int maxUnhappy = 8;
			int pos = 0;
			for(int i = 1;num-->0;i++){
				int comp =in.nextInt()+in.nextInt();
				if(comp>maxUnhappy){
					maxUnhappy = comp;
					pos = i;
				}
			}
			System.out.println(pos);
		}
	}
}
