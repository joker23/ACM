import java.util.*;

/**
 * Debug class 
 *	This class is used as a base class for acm problems
 *	it will provide some methods that will help out with
 *	the debugging process.
 *
 * @author: Joker23
 */

public class Debug {

	//prints out the reprentations of the state
	public static void print(Object[] arr){
		for(Object o: arr){
			System.out.print("["+o+"]");
		} System.out.println();
	}

	public static void print(int[] arr){
		for(int o: arr){
			System.out.print("["+o+"]");
		} System.out.println();
	}

	public static void print(long[] arr){
		for(long o: arr){
			System.out.print("["+o+"]");
		} System.out.println();
	}
	
	public static void print(double[] arr){
		for(double o: arr){
			System.out.print("["+o+"]");
		} System.out.println();
	}

	public static void print(short[] arr){
		for(short o: arr){
			System.out.print("["+o+"]");
		} System.out.println();
	}

	public static void print(boolean[] arr){
		for(boolean o: arr){
			System.out.print("["+(o ? 1 : 0)+"]");
		} System.out.println();
	}

	public static void print(int arr[][]){
		for(int i=0; i<arr.length; i++){
			for(int j =0; j<arr[i].length; j++){
				System.out.print("["+arr[i][j]+"]");
			} System.out.println();
		} System.out.println();
	}
	
	public static void print(long arr[][]){
		for(int i=0; i<arr.length; i++){
			for(int j =0; j<arr[i].length; j++){
				System.out.print("["+arr[i][j]+"]");
			} System.out.println();
		} System.out.println();
	}
	
	public static void print( Object arr[][]){
		for(int i=0; i<arr.length; i++){
			for(int j =0; j<arr[i].length; j++){
				System.out.print("["+arr[i][j]+"]");
			} System.out.println();
		} System.out.println();
	}
	
	public static void print(boolean arr[][]){
		for(int i=0; i<arr.length; i++){
			for(int j =0; j<arr[i].length; j++){
				System.out.print("["+(arr[i][j] ? 1:0)+"]");
			} System.out.println();
		} System.out.println();
	}

}
