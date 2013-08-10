import java.util.*;
public class Main {
	static char[] arr = {'i','x','c','m'};
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
		HashMap<Character, Integer> numerals = new HashMap<Character,Integer>();
		int put = 1;
		for(int i=0;i<arr.length;i++){
			dict.put(arr[i], put);
			put*=10;
		}
		char put1 = '2';
		for(int i=2;i<10;i++){
			numerals.put(put1,i);
			put1++;
		}
		int num = in.nextInt();
		while(num-->0){
			int number = 0;
			String num1 = in.next();
			String num2 = in.next();
			for(int i=0;i<num1.length();i++){
				if(i!=0&&dict.containsKey(num1.charAt(i))&&numerals.containsKey(num1.charAt(i-1))){
					number+=numerals.get(num1.charAt(i-1))*dict.get(num1.charAt(i));
				}else if(dict.containsKey(num1.charAt(i))){
					number+=dict.get(num1.charAt(i));
				}
			}
			for(int i=0;i<num2.length();i++){
				if(i!=0&&dict.containsKey(num2.charAt(i))&&numerals.containsKey(num2.charAt(i-1))){
					number+=numerals.get(num2.charAt(i-1))*dict.get(num2.charAt(i));
				}else if(dict.containsKey(num2.charAt(i))){
					number+=dict.get(num2.charAt(i));
				}
			}
			int divide = 1000;
			String ret = "";
			for(int i=arr.length-1;i>=0;i--){
				if (number/divide == 1) ret+= arr[i];
				else if(number/divide!=0) ret+= Integer.toString(number/divide) + arr[i];
				number=number%divide;
				divide/=10;
			}
			System.out.println(ret);
		}
	}
}
