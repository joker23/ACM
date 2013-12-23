import java.util.*;
public class Main{

	public static void main(String[] args) throws InterruptedException{
		int prev = 1;
		int curr = 2;
		int num = 1;
		while(num<500){
			curr++;
			prev++;
			int check = (curr*prev)/2;
			num = divisors(fact(check), false);
		}
		System.out.println((curr*prev)/2);
	}

	public static int divisors(int[] arr, boolean even){
		if(even){
			arr[0]--;
		} int ans = 1;
		for(int i: arr){
			ans*=(i+1);
		}
		return ans;
	}

	public static int[] fact(long num){
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		while(num%2==0){
			if(!map.containsKey((long)2)){
				map.put((long)2,1);
			} else{
				int tmp = map.remove((long)2);
				map.put((long)2, tmp+1);
			}
			num/=2;
		}
		while(num%3==0){
			if(!map.containsKey((long)3)){
				map.put((long)3,1);
			}else{
				int tmp = map.remove((long)3);
				map.put((long)3, tmp+1);
			}
			num/=3;
		}
		for(long i = 6; i<=num+6; i+=6){
			long lo = i-1;
			long hi = i+1;
			while(num%lo == 0){
				if(!map.containsKey(lo)){
					map.put(lo, 1);
				}else{
					int tmp = map.remove(lo);
					map.put(lo, tmp+1);
				}
				num/=lo;
			}

			while(num%hi == 0){
				if(!map.containsKey(hi)){
					map.put(hi, 1);
				} else{
					int tmp = map.remove(hi);
					map.put(hi, tmp+1);
				}
				num/=hi;
			}
		}
		int[] ret = new int[map.size()];
		Set<Long> set = (map.keySet());
		int counter = 0;
		for(long i: set){
			ret[counter++] = map.get(i);
		}
		return ret;
	}
}
