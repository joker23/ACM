public class Main {

	public static void main(String[] args){
		long a = 0;
		for(int i=1;i<101; i++){
			a += i*i;
		}
		long b = 0;
		for(int i=1; i<101; i++){
			b+= i;
		}
		b*=b;
		System.out.println(b-a);
	}
}
