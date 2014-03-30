import java.util.*;
import java.math.*;
import java.text.*;

import static java.lang.Math.*;
import static java.lang.Integer.*;

public class MicroStrings {
    private String res;
    public String makeMicroString(int a, int d) {

		res = "" + a;
		while(a - d >= 0) {
			a -= d;
			res += a;
		}

        return res;
    }

}
