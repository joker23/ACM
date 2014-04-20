import java.util.*;
import java.math.*;
import java.text.*;

import static java.lang.Math.*;
import static java.lang.Integer.*;

public class SpamChecker {
    private String res;
    public String spamCheck(String judgeLog, int good, int bad) {

		int score = 0;
		for(int i=0; i<judgeLog.length(); i++){
			if(judgeLog.charAt(i) == 'x') {
				score -= bad;
			} else {
				score += good;
			}

			if(score < 0) {
				return "SPAM";
			}
		}
		if(score < 0) {
			return "SPAM";
		}
        return "NOT SPAM";
    }

}
