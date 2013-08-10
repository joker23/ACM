import java.util.Scanner;
import java.text.DecimalFormat; 

public class Main{
	static int total;
	static Node root;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		for(;in.hasNextLine();){
			insert(in.nextLine());
		} inOrder(root);
	}
	public static class Node implements Comparable<Node>{
		Node left,right;
		String val;
		int count;
		public Node(String s,int num){
			this.val = s;
			this.count = num;
		}
		public int compareTo(Node n){
			return this.val.compareTo(n.val);
		}
	}
	public static void insert(String s){
		Node temp = new Node(s,1);
		if(root == null){
			root = temp;
		} else{
			insert(root,temp);
		}total++;
	} private static void insert(Node curr, Node insert){
		int comp = curr.compareTo(insert);
		if(comp==0){
			curr.count++;
		}else if(comp>0){
			if(curr.left==null) curr.left = insert;
			else insert(curr.left,insert);
		}else if(comp<0){
			if(curr.right==null) curr.right = insert;
			else insert(curr.right,insert);
		}
	} 
	public static void inOrder(Node curr){
		if(curr!=null){
			inOrder(curr.left);
			System.out.println(curr.val+" "+format((double)curr.count/total));
			inOrder(curr.right);
		}
	} private static double format(double num){
		num*=100;
		num*=10000;
		num = Math.round(num);
		num = (double) num/10000;
		return num;
		
	}
	
	
}
