import java.util.*;
public class Main {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n,wire[],x,y,tmp;
		while(in.hasNext()){
			n = in.nextInt();
			wire = new int[n+2];
			for(int i=1;i<wire.length-1;i++){
				wire[i] = in.nextInt();
			} n = in.nextInt();
			while(n-->0){
				x = in.nextInt();
				y = in.nextInt();
				tmp = wire[x];
				wire[x] = 0;
				wire[x-1] += y-1;
				wire[x+1] += tmp-y;
			}for(int i=1;i<wire.length-1;i++){
				System.out.println(wire[i]);
			}
		}
	}
}
