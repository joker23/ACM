import java.util.*;
import java.text.*;
import java.io.*;
public class Main{
	public static final int ANNE=0;
	public static final int BOB=1;
	public static final int DAVE=2;
	public static final int KARIN=3;
	public static final int CHARLY=4;
	public static final int EDWARD=5;
	public static final int FRANK=6;

	public static final int CIN=1;
	public static final int DIS=2;
	public static final int BAR=3;
	public static HashSet there = new HashSet();

	public static final String[] names = {"Anne","Bob", "Dave", "Karin", "Charly", "Edward", "Frank" };
	public static int[] votes = new int[7];

	public static void main(String[] args) throws Exception {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));	
		int nr_scen = Integer.parseInt(r.readLine());
		for (int i_s=1; i_s<=nr_scen; i_s++) {
			StringTokenizer tok = new StringTokenizer(r.readLine());
			there = new HashSet();
			while(tok.hasMoreTokens()) {
				String name = tok.nextToken();
				there.add(name);
			} for(int i=0; i<7 ; i++) {
				votes[i]=0;
			}// Anne's vote
			vote(ANNE, CIN);
			
			// Bob's vote
			if (there("Karin")) vote(BOB, DIS);
			if (!there("Anne")) vote(BOB, BAR);
			if (there("Dave")) vote(BOB, BAR);
			if (there("Edward")) vote(BOB, BAR);
			
			// Dave's vote (nothing)
			// Karin
			if (there("Charly")) vote(KARIN, DIS);
			if (!there("Charly") && there("Anne")) vote(KARIN, CIN);
			if (!there("Charly") && !there("Anne")) vote(KARIN, BAR);
			
			// Charly
			if (there("Charly") && there("Anne")) vote(CHARLY, CIN);
	
			// Edward 
			if (there("Anne") && !there("Charly"))
				vote(EDWARD, BAR);
			else 
				vote(EDWARD, CIN);
		
			// Frank
			if (!there("Bob") && !there("Anne")) vote(FRANK, CIN);
			if (there("Anne")) vote(FRANK, DIS);
	
			// Count votes
			
			int[] vc = new int[4];
			for(int i=0; i<7; i++)
			//	System.out.println(names[i]+" "+i+":"+votes[i]+":"+there(names[i]));
				if (there(names[i]) && votes[i]>=0)
					vc[votes[i]]++;	
	
		
			System.out.println("Scenario #"+i_s+":");
			if (vc[CIN] > vc[BAR] && vc[CIN] > vc[DIS]) {
				System.out.println("cinema");
			} else if (vc[BAR] > vc[CIN] && vc[BAR] > vc[DIS]) {
				System.out.println("cocktail bar");
			} else if (vc[DIS] > vc[BAR] && vc[DIS] > vc[CIN]) {
				System.out.println("disco");
			} else {
				System.out.println("stay at the Hacienda");
			}
			System.out.println();
		
			
		}
	}

	public static boolean there(String name) {
		return there.contains(name);
	}

	public static void vote(int name, int where) {
		if (votes[name] == 0) {
			votes[name] = where;
		} else if (votes[name] != where) {
			votes[name] = -1;
		}
	}

}