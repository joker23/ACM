import java.util.*;
import java.math.*;

public class EmoticonsDiv2 {
    public int printSmiles(int smiles) {
		int[] dp = new int[smiles+1];
		for(int i=0; i<dp.length; i++) {
			dp[i] = i;
		}

		for(int i = 2; i<dp.length; i ++ ) {
			int num = dp[i] + 2;
			for(int j=i+i; j<dp.length; j+=i){
				dp[j] = num ++;
			}
		}

		return dp[smiles];
	}

}
