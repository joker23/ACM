import java.io.File;
import java.util.Scanner;


public class MovingPointsMemo
{

	private static class Point {
		
		double xStart, yStart, xSpeed, ySpeed;
		
	}
	
	private Point[] points;
	private double mySpeed;	
           
	// 1st dimension: Bitset of points we still need to visit
	// 2nd dimension: Next point to visit
	private double[][] memo;
	
	/**
	 * Solve a quadratic equation to determine when the 2 moving points will intersect.
	 * v = velocity of special point
	 * x0, y0 = starting coordinates of regular point, with respect to special point
	 * xs, ys = speed of regular point in x and y direction
	 * theta = angle of special point velocity, with respect to x-axis
	 * 
	 * v*t*cos(theta) = xs*t + x0
	 * v*t*sin(theta) = ys*t + y0
	 * 
	 * Square both sides and add them together...
	 * 
	 * v^2*t^2*(cos^2(theta) + sin^2(theta)) = (xs*t + x0)^2 + (ys*t+y0)^2
	 * v^2*t^2 = (xs*t + x0)^2 + (ys*t+y0)^2
	 * v^2*t^2 = xs^2*t^2 + 2*xs*x0*t + x0^2 + ys^2*t^2 + 2*ys*y0*t + y0^2
	 * 
	 * Now combine like terms to get the equation.
	 * 
	 */
	private double getCollisionTime(double v, double x0, double y0, double xs, double ys) {
		
		// Solve quadratic equation
		double a = xs * xs + ys * ys - v * v;
		double b = 2 * xs * x0 + 2 * ys * y0;
		double c = x0 * x0 + y0 * y0;
		
		double ans = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
		return ans;		
	}
	
	/**
	 * Solves a subset of the problem, working backwards.
	 * 
	 * needToVisit: The indexes i where needToVisit[i] = true represent the set of
	 * points that still need to be visited.
	 * numRemaining: The number of points we haven't accounted for yet.
	 * next: The next point we need to visit, *after* all the points where needToVisit = true.
	 * 
	 */
	private double getBestTime(boolean[] needToVisit, int numRemaining, int next) {
		
		int index = getIndex(needToVisit);
		if (memo[index][next] != 0)
			return memo[index][next];
		
		Point nextPoint = points[next];
		
		if (numRemaining == 0) {
			
			// If we've gotten to our first point, just calculate the time it takes to
			// reach the nextPoint (the first point) from the origin.
			return getCollisionTime(mySpeed, nextPoint.xStart, nextPoint.yStart, nextPoint.xSpeed, nextPoint.ySpeed);
		}
		
		double bestTime = 100000000;
		for (int i = 0; i < needToVisit.length; i++) {
			
			if (needToVisit[i]) {
				
				// Calculate the minimum time required to visit all the points
				// in the needToVisit set, with point i as the last one.
				needToVisit[i] = false;
				double prevTime = getBestTime(needToVisit, numRemaining-1, i);
				needToVisit[i] = true;
				
				// Then add in the time it takes to go from point i to nextPoint.
				
				// The special point is currently at the same location as point i
				double myX = points[i].xStart + points[i].xSpeed * prevTime;
				double myY = points[i].yStart + points[i].ySpeed * prevTime;
				
				double nextX = nextPoint.xStart + nextPoint.xSpeed * prevTime;
				double nextY = nextPoint.yStart + nextPoint.ySpeed * prevTime;
				
				double newTime = getCollisionTime(mySpeed, nextX - myX, nextY - myY,
						nextPoint.xSpeed, nextPoint.ySpeed);
				
				bestTime = Math.min(bestTime, prevTime + newTime);
			}
			
		}
		
		memo[index][next] = bestTime;
		return bestTime;
	}
	
	private int getIndex(boolean[] needToVisit) {
		
		int index = 0;
		for (int i = 0; i < needToVisit.length; i++) {
			
			if (needToVisit[i])
				index += (1 << i);
			
		}
		return index;	
	}
	
	private MovingPointsMemo(double mySpeed, Point[] points) {
		this.mySpeed = mySpeed;
		this.points = points;
		
		memo = new double[1000000][20];
	}
	
	private static Point createPoint(double x, double y, double speed, double angle) {
		Point point = new Point();
		point.xStart = x;
		point.yStart = y;
		point.xSpeed = speed * Math.cos(angle);
		point.ySpeed = speed * Math.sin(angle);
		return point;
	}
	
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner( new File( "movingpoints.judge" ) );

        for(;;)
        {
    		int POINTS = sc.nextInt();
    		if( POINTS==0 ) break;
    		
    		double speed = sc.nextInt();
    		Point[] points = new Point[POINTS];
    		for( int i=0; i<POINTS; i++ )
    		{
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                double theta = sc.nextDouble();
                double sp = sc.nextDouble();
                points[i] = createPoint( x, y, sp, Math.toRadians( theta ) );
    		}
    		
    		double bestTime = 100000000;		
    		MovingPointsMemo mp = new MovingPointsMemo(speed,points);
    		
    		// Try each possible last point.
    		for (int lastPoint = 0; lastPoint < POINTS; lastPoint++) {
    			
    			boolean[] toVisit = new boolean[POINTS];
    			for (int j = 0; j < POINTS; j++)
    				toVisit[j] = true;
    			
    			// We don't need to visit point lastPoint because we already know it's last.
    			toVisit[lastPoint] = false;
    			bestTime = Math.min(bestTime, mp.getBestTime(toVisit, POINTS-1, lastPoint)); 
    			
    			
    		}		
    		
    		System.out.printf( "%.2f\n", bestTime);
        }
	}
}
