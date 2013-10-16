
public class Main{
	public static void main(String[] args){
		int a,b,c;
		for(a = 1; a<1001; a++){
			for (b = 0; a+b<1001; b++){
				c = 1000 - a - b;
				if(a*a + b*b == c*c){
					System.out.println(a*b*c);
					break;
				}
			}
		}
	}
}
