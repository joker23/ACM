import java.util.*;
import java.math.*;

public class TaroFriends {
    public int getNumber(int[] coordinates, int x) {
        int res = Integer.MAX_VALUE;

		int n = coordinates.length;
		if(n == 1){
			return 0;
		}

		int[] all = new int[n*2];

		for(int i=0; i<coordinates.length; i++){
			all[i*2] = coordinates[i] - x;
			all[i*2+1] = coordinates[i] +x;
		}

		Arrays.sort(all);

		//find minimum gap that still has all values
		for(int i=0; i<2*n; i++){
			for(int j=i+1; j<2*n; j++){
				boolean canMake = true;
				int left = all[i];
				int right = all[j];
				for(int k=0; k<n; k++){
					int question = coordinates[k];
					boolean lbound = question + x <= right && question + x >= left;
					boolean rbound = question - x <= right && question - x >= left;
					if(!(lbound || rbound)){
						canMake = false;
						break;
					}
				}
				if(canMake){
					res = Math.min(res, right - left);
				}
			}
		}

        return res;
    }

}
