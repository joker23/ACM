import java.util.*;
import java.io.*;

public class Main {
	static Scanner in;
	public static void main(String[] args){
		int a = 0,b = 1,temp, ans = 0;
		
		while(b<4000000){
			temp = a + b;
			if((temp&1) == 0){
				ans += temp;
			}
			a = b;
			b = temp;
		} System.out.println(ans);
	}
}
