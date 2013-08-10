import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true){
			String str = in.next();
			if(str.equals("#")) break;
			double[] cache = new double[str.length()];
			for(int i=0;i<str.length();i++){
				switch (str.charAt(i)){
				case '.':
					cache[i] = 100;
					break;
				case '_':
					cache[i] = 0;
					break;
				}
			}
			double tot = 0;
			for(int i=0;i<str.length();i++){
				switch (str.charAt(i)){
				case '|':
					//left
					double temp  = 0;
					if(i==0) temp+=100;
					else{
						for(int j = i-1;j>=0;j--){
							if(j==0||str.charAt(j) == '.'){
								temp+=100; 
								break;
							} if(str.charAt(j) == '/' || str.charAt(j) == '|'){
								break;
							}
						}
					}
					//right
					if(i==cache.length-1) temp+=100;
					else{
						for(int j=i+1;j<cache.length;j++){
							if(j==cache.length-1||str.charAt(j)=='.'){
								temp+=100;
								break;
							}if(str.charAt(j) =='/'||str.charAt(j)=='|'){
								break;
							}
						}
					}
					cache[i] = temp/2;
					break;
				case '/':
					if(i==0) cache[i] = 100;
					else{
						for(int j = i-1;j>=0;j--){
							if(j==0 || str.charAt(j) == '.'){
								cache[i] = 100;
								break;
							}
							if(str.charAt(j) == '|'||str.charAt(j) == '/'){
								cache[i] = 0;
								break;
							}
						}
					}
					if(i+1==cache.length-1) cache[i+1] = 100;
					else {
						for(int j=i+2;j<cache.length;j++){
							if(j==cache.length-1||str.charAt(j) == '.'){
								cache[i+1] = 100;
								break;
							}
							if(str.charAt(j) == '/' || str.charAt(j) == '|'){
								cache[i+1] = 0;
								break;
							}
						}
					}
					break;
				}
				tot+=cache[i];
			}
			System.out.println((int)(tot/cache.length));
		}
	}
}
