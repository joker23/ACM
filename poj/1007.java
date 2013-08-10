import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = in.nextInt(), test = in.nextInt();
		String[] list = new String[test];
		for(int i=0;i<test;i++){
			list[i] = in.next();
		}
		Arrays.sort(list,new Comp());
		for(int i=0;i<list.length;i++){
			System.out.println(list[i]);
		}
	}

	private static class Comp implements Comparator<String> {

		public int compare(String o1, String o2) {
			Integer count1 = 0, count2 = 0;
			for (int i = 1; i < o1.length(); i++) {
				for(int j = i; j>0;j--){
					if(o1.charAt(j)<o1.charAt(j-1)){
						char temp = o1.charAt(j);
						o1 = o1.substring(0,j-1)+o1.charAt(j)+o1.charAt(j-1)+o1.substring(j+1,o1.length());
						count1++;
					}
					if(o2.charAt(j)<o2.charAt(j-1)){
						char temp = o2.charAt(j);
						o2 = o2.substring(0,j-1)+o2.charAt(j)+o2.charAt(j-1)+o2.substring(j+1,o2.length());
						count2++;
					}
				}
			}
			return count1.compareTo(count2);
		}

	}
}
