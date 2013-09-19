import java.util.*;
import java.io.*;

public class Main {
	static Scanner in;
	public static void main(String[] args){
		int ans = 0;
		for(int i = 100 ; i<1000; i++){
			for(int j = 100; j<1000; j++){
				if(isPalin(i*j)){
					ans = Math.max(ans,i*j);
				}
			}
		}System.out.println(ans);
	}

	static boolean isPalin(int n){
		String str = n + "";
		for(int i = 0 ; i<=str.length()/2; i++){
			int j = str.length() -i -1;
			if(str.charAt(i)!= str.charAt(j)) return false;
		}return true;
	}
}
