import java.util.*;

public class Time {

	public String whatTime(int seconds) {
		int hourDiv = 60*60;
		int minuteDiv = 60;
		
		String ans = "";
		ans += seconds/hourDiv;
		seconds = seconds % hourDiv;
		ans += ":" + seconds / minuteDiv;
		seconds = seconds % minuteDiv;
		ans += ":" + seconds;
		
		return ans;
	}

}
