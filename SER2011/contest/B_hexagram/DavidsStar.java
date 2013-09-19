import java.util.*;
import java.io.*;

public class DavidsStar
{
	
	private static int checkStar(List<Integer> outerList, Set<Integer> innerSet, int sum) {
		
		int stars = 0;
		Set<Integer> newSet = new HashSet<Integer>();
		for (int inner0 : innerSet) {			
			
			newSet.addAll(innerSet);
			newSet.remove(inner0);
			
			int inner1 = sum - outerList.get(1) - outerList.get(2) - inner0;
			if (newSet.contains(inner1))
				newSet.remove(inner1);
			else
				continue;
			
			int inner2 = sum - outerList.get(0) - outerList.get(3) - inner0;
			if (newSet.contains(inner2))
				newSet.remove(inner2);
			else
				continue;
			
			int inner4 = sum - outerList.get(1) - outerList.get(5) - inner2;
			if (newSet.contains(inner4))
				newSet.remove(inner4);
			else
				continue;
			
			int inner5 = sum - outerList.get(3) - outerList.get(4) - inner4;
			if (newSet.contains(inner5))
				newSet.remove(inner5);
			else
				continue;
			
			int inner3 = sum - outerList.get(2) - outerList.get(5) - inner5;
			if (newSet.contains(inner3))
				newSet.remove(inner3);
			else
				continue;
			
			if (outerList.get(0) + outerList.get(4) + inner1 + inner3 == sum) {
				stars++;
			}						
			
		}
		
		return stars;
		
	}
	
	private static int formOuter(Set<Integer> outerSet, Set<Integer> innerSet, int reqSum) {
		
		int stars = 0;
		
	/*
	 * Rules for eliminating rotations and reflections:
	 * 1) Minimum element goes in position 5
	 * 2) Position 3 < position 4
	 */
		int minItem = Collections.min(outerSet);
		outerSet.remove(minItem);
		
		for (List<Integer> outerList : getPermutations(outerSet)) {
			
			if (outerList.get(3) > outerList.get(4))
				continue;
			
			outerList.add(minItem);
			stars += checkStar(outerList, innerSet, reqSum);
		}		
		
		return stars;
	}
	
	/**
	 * Create a list of all permutations from a given set.
	 */
	private static<T> List<List<T>> getPermutations(Set<T> set) {
		
		List<List<T>> perms = new ArrayList<List<T>>();
		
		if (set.size() == 1) {
			List<T> list = new ArrayList<T>();
			list.add(set.iterator().next());
			perms.add(list);
			return perms;
		}
		
		Set<T> copy = new HashSet<T>(set);
		for (T item : copy) {			
			set.remove(item);
			for (List<T> oldPerm : getPermutations(set)) {
				
				oldPerm.add(item);
				perms.add(oldPerm);				
			}			
			set.add(item);			
		}
		
		return perms;
	}
	
	/**
	 * Create a list of all combinations of a given size from a given set.
	 * @param set
	 * @param size
	 * @return
	 */
	private static<T> List<Set<T>> getCombinations(Set<T> set, int size) {
		
		List<Set<T>> combos = new ArrayList<Set<T>>();		
		
		if (size == 0) {
			Set<T> newSet = new HashSet<T>();
			combos.add(newSet);
			return combos;
		}
		
		if (size == set.size()) {
			Set<T> newSet = new HashSet<T>(set);
			combos.add(newSet);
			return combos;
		}				
		
		
		T item = set.iterator().next();
		set.remove(item);
		
		for (Set<T> withItem : getCombinations(set, size-1)) {
			withItem.add(item);
			combos.add(withItem);
		}
		
		for (Set<T> withoutItem : getCombinations(set, size)) {
			combos.add(withoutItem);
		}
		
		set.add(item);
		return combos;
	}
	
	public static void main(String[] args) throws Exception {
		
	    long start = System.currentTimeMillis();
		//Integer[] stuff = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,15};
		//Integer[] stuff = new Integer[]{3,17,15,18,11 ,22 ,12, 23, 21,7,9,13};
		//Integer[] stuff = new Integer[]{11, 3, 13, 14, 6, 1, 9, 7, 20, 12, 8, 19};
		//Integer[] stuff = new Integer[]{4, 5, 8, 12, 11, 6, 2, 9, 7, 3, 13, 1};
		//Integer[] stuff = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,13};
		
		//Integer[] stuff = new Integer[]{5, 18, 8, 20, 7, 10, 16, 17, 2, 12, 4, 13};
		//Integer[] stuff = new Integer[]{37, 33, 42, 8, 45, 43, 18, 30, 40, 29, 2, 24};
		//Integer[] stuff = new Integer[]{26, 20, 12, 19, 14, 3, 13, 25, 11, 16, 6, 18};
		//Integer[] stuff = new Integer[]{7, 17, 8, 1, 2, 16, 20, 13, 4, 5, 3, 9};
		//Integer[] stuff = new Integer[]{14, 3, 4, 12, 7, 6, 16, 8, 2, 10, 15, 17};
		//Integer[] stuff = new Integer[]{6, 12, 2, 10, 18, 21, 5, 22, 14, 25, 20, 7};
		//Integer[] stuff = new Integer[]{8, 9, 18, 5, 4, 11, 12, 1, 7, 2, 3, 16};
		//Integer[] stuff = new Integer[]{13, 14, 18, 2, 10, 12, 11, 1, 3, 5, 6, 16};
		//Integer[] stuff = new Integer[]{5, 6, 16, 17, 15, 18, 8, 1, 14, 10, 3, 13};
		//Integer[] stuff = new Integer[]{37, 24, 12, 11, 19, 40, 20, 8, 33, 17, 15, 16};
	    
	    Scanner sc = new Scanner( new File( "hexagram.judge" ) );
	    PrintStream ps = new PrintStream( new FileOutputStream( "hexagram.out" ) );
	    
		Integer[] stuff = new Integer[12];
		
		for(;;)
		{
		    boolean done = false;
    		for( int i=0; i<12; i++ )
    		{
    		    int value = sc.nextInt();
    		    if( value==0 ) done = true;
    		    stuff[i] = value;
    		}
    		
    		if( done ) break;
    		
    		Set<Integer> stuffSet = new HashSet<Integer>(Arrays.asList(stuff));
    		
    		int reqSum = 0;
    		for (int num : stuff)
    			reqSum += num;
    		if (reqSum % 3 != 0)
    			ps.println(0);
    		else {
    			reqSum /= 3;
    			
    			int stars = 0;
    			for (Set<Integer> outer : getCombinations(stuffSet, 6)) {
    				
    				Set<Integer> inner = new HashSet<Integer>(stuffSet);
    				inner.removeAll(outer);
    				stars += formOuter(outer,inner,reqSum);			
    			}
    			ps.println(stars);
    			
    		}
		}
		
		System.out.println( System.currentTimeMillis() - start );
		
	}
	
}
