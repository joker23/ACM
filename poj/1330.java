import java.util.*;
public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] map;
		boolean[] visited;
		int test = in.nextInt(),num,a,b,ret;
		while(test-->0){
			num = in.nextInt();
			map = new int[num+1];
			for(int i=0;i<map.length;i++)
				map[i]=i;
			for(int i=1;i<num;i++){
				a = in.nextInt();
				b = in.nextInt();
				map[b] = a;
			}visited = new boolean[num+1];
			a = in.nextInt();
			b = in.nextInt();
			while(a!=map[a]){
				visited[a] = true;
				a = map[a];
			} visited[a] = true;
			while(true){
				if(visited[b]){
					ret = b;
					break;
				} b = map[b];
			}System.out.println(ret);
		}
	}
		
}
