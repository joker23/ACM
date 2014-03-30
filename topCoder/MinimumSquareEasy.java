import java.util.*;
import java.math.*;
import java.text.*;
import java.awt.Point;

import static java.lang.Math.*;
import static java.lang.Integer.*;

public class MinimumSquareEasy {
	private long res = Long.MAX_VALUE;
	public long minArea(int[] x, int[] y) {
		int n = x.length;

		//choose 2 points
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(j != i){
					int minx = Integer.MAX_VALUE;
					int miny = Integer.MAX_VALUE;

					int maxx = Integer.MIN_VALUE;
					int maxy = Integer.MIN_VALUE;

					for(int k=0; k<n; k++){
						if(k != i && k != j){
							minx = min(minx, x[k]);
							miny = min(miny, y[k]);

							maxx = max(maxx, x[k]);
							maxy = max(maxy, y[k]);
						}
					}
					Point p1 = new Point(minx , miny);
					Point p2 = new Point(maxx, maxy);
					//System.out.println(p1 + "  " + p2);

					res = min (res, calcSquar(p1, p2));
				}
			}
		}
		return res;
	}

	public long calcSquar(Point p1, Point p2) {

		//two outlying points
		long side = max(abs(p2.x - p1.x), abs(p2.y - p1.y)) + 2;

		return side * side;
	}

}


// Powered by FileEdit
// Powered by CodeProcessor
