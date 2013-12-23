
public class TheAirTripDivTwo{

	public int find(int[] arr, int n){
		int i;
		for(i=0;i<arr.length; i++){
			if(n-arr[i]<0){
				break;
			}
			n-=arr[i];
		}
		return i;
	}
	public static void main(String[] args){
		TheAirTripDivTwo test = new TheAirTripDivTwo();
		int[] arr = {7, 10, 3, 4, 5, 6, 7};
		int n = 10;
		System.out.println(test.find(arr, n));
	}
}
