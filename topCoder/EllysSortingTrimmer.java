import java.util.*;
import java.math.*;
import java.text.*;

import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.util.Arrays.*;

public class EllysSortingTrimmer {
    private String res;
    public String getMin(String str, int l) {
		int n = str.length();
		int i = n - l;
		for(; i>=0; i--) {
			str = str.substring(0,i) + sorts(str.substring(i,i+l));
		}

		return str;
    }

	public String sorts(String str) {
		char[] arr = str.toCharArray();

		sort(arr);

		String ret = "";
		for(char c : arr) {
			ret+=c;
		}
		return ret;
	}

}
