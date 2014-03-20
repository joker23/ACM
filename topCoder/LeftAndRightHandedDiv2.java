import java.util.*;
import java.math.*;

public class LeftAndRightHandedDiv2 {
    public int count(String S) {
        int res = 0;
		for(int i=1; i<S.length(); i++){
			if(S.charAt(i) == 'L' && S.charAt(i-1) == 'R') {
				res ++;
			}
		}
        return res;
    }

}
