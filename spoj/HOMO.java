import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	//static Scanner in;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	public static void main(String[] args) throws IOException{
		//in = new Scanner(System.in);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		//code starts here
		int test = Integer.parseInt(in.readLine().trim());
		
		HashSet<Integer> repeated = new HashSet<Integer>();

		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		int size = 0;

		while(test-->0){
			st = new StringTokenizer(in.readLine());
			String command = st.nextToken();
			int num = Integer.parseInt(st.nextToken());

			if(command.equals("insert")){
				size++;
				if(map.containsKey(num)){
					int count = map.remove(num);
					map.put(num, ++count);
					if(!repeated.contains(num)){
						repeated.add(num);
					}
				} else{
					map.put(num, 1);
				}
			}else{
				if(map.containsKey(num)){
					
					size--;

					int count = map.remove(num);
					if(--count>0){
						map.put(num, count);
				
						if(count == 1){
							repeated.remove(num);
						}
					}
				}
			}

			//System.out.println(map);
			
			if(size<2){
				out.println("neither");
			}
			else if(!repeated.isEmpty() && map.size()>1){
				out.println("both");
			} else if(!repeated.isEmpty()){
				out.println("homo");
			} else if(map.size()>1){
				out.println("hetero");
			} else{
				out.println("Master! something went wrong...");
			}
			
		}

		//code ends here
		out.flush();
	}
}
