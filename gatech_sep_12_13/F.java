import java.util.*;
import java.io.*;

public class F {
	static BufferedReader in;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line = in.readLine()).length()>0){
			st = new StringTokenizer(line);
			st.nextToken();
			LinkedList<Node> ally = new LinkedList<Node>();
			LinkedList<Node> enemy = new LinkedList<Node>();
			while(st.hasMoreTokens()){
				String str = st.nextToken();
				str = str.substring(1,str.length()-1);
				String[] split = str.split(",");
				ally.add(new Node(Integer.parseInt(split[0]),Integer.parseInt(split[1])));
			}
			double medx = 0;
			double medy = 0;
			for(Node n: ally){
				medx+=n.x;
				medy+=n.y;
			}
			medx /= ally.size();
			medy /= ally.size();
			double mandist=0;
			for(Node n: ally){
				mandist = Math.max(mandist,Math.sqrt(Math.pow(medx-n.x,2)+Math.pow(medy-n.y,2)));
			}

			line = in.readLine();
			st = new StringTokenizer(line);
			st.nextToken();
			while(st.hasMoreTokens()){
				String str = st.nextToken();
				if(str.equals("none")) break;
				str = str.substring(1,str.length()-1);
				String[] split = str.split(",");
				enemy.add(new Node(Integer.parseInt(split[0]),Integer.parseInt(split[1])));
			}
			boolean flag = false;
			for(Node n: enemy){
				if(Math.sqrt(Math.pow(medx-n.x,2)+Math.pow(medy-n.y,2))<= mandist){
					flag = true;
					break;
				}
			}
			if(flag){
				System.out.println("The Orcs are close");
			}else{
				System.out.println(mandist);
			}
		}
    }

	/**
	 * information holder
	 */
	private static class Node{
		Integer x,y;

		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
