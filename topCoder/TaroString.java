import java.util.*;
import java.math.*;

public class TaroString {
    public String getAnswer(String S) {
        boolean cando = true;

		int[] letter = new int[Character.MAX_VALUE];

		for(int i=0; i<S.length(); i++){
			letter[S.charAt(i)] ++;
		}

		cando = letter['C'] == 1 && letter['A'] == 1 && letter['T'] == 1;
		cando &= S.indexOf("C") < S.indexOf("A") && S.indexOf("A") < S.indexOf("T");

        return cando ? "Possible" : "Impossible";
    }

}
