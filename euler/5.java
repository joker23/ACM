public class Main{

	public static void main(String[] args){
		long a = 2520;
		long ans = 2520;
		for(;;ans += a){
			if(check(ans)){
				System.out.println(ans);
				break;
			}
		}
	}

	public static boolean check(long ans){
		for(int i = 11; i<=20; i++ ){
			if(ans%i != 0){
				return false;
			}
		}return true;
	}
}
