import java.io.*;
import java.util.*;
import java.awt.geom.*;

/**
 * Solution to Moving Points.
 * 
 * @author vanb
 */
public class movingpoints
{
    public Scanner sc;
    public PrintStream ps;
    
    // A useful constant...
    public static final double TWOPI = Math.PI + Math.PI;
    
    /**
     * A Target Point.
     * 
     * @author vanb
     */
    public class Target
    {
        // Starting (x,y), angle, speed.
        public double x, y, theta, speed;
        
        /**
         * Create a Target Point.
         * 
         * @param xx Starting x
         * @param yy Starting y
         * @param t Angle
         * @param s Speed
         */
        public Target( double xx, double yy, double t, double s )
        {
            x = xx; 
            y = yy;
            // Input is in degrees. Convert to Radians.
            theta = Math.toRadians( t );
            speed = s;
        }
        
        /**
         * Where is this Target's x coord at a certain time?
         * It's assumed that the Target Point starts out
         * at its original (x,y) at time 0.
         * 
         * @param time Time of interest (>=0)
         * @return X coord at that time
         */
        public double projectx( double time )
        {
            return x + speed * time * Math.cos( theta );
        }
        
        /**
         * Where is this Target's y coord at a certain time?
         * It's assumed that the Target Point starts out
         * at its original (x,y) at time 0.
         * 
         * @param time Time of interest (>=0)
         * @return Y coord at that time
         */
        public double projecty( double time )
        {
            return y + speed * time * Math.sin( theta );
        }
    }
    
    // Arrays of Targets
    public Target targets[] = new Target[12];
    
    // Have we visited target i yet?
    public boolean visited[] = new boolean[12];
    
    // Memoization array.
    // The first index is a state, which is binary representation
    // of which points have and haven't been visited,
    // The second index is a point.
    public double memo[][] = new double[33000][15];
    
    // Number of Target Points
    public int n;
    
    // Speed of the "Chaser" point
    public double chaserspeed;
    
    // The best time we've found so far
    public double besttime;
    
    /**
     * Determine the time of intersection of the chaser point and the target point.
     * 
     * @param x X coord of chaser point right now
     * @param y Y coord of chaser point right now
     * @param time Time right now
     * @param tgt Which point we're trying to catch
     * @return The earliest time at which the chaser point can catch the target point.
     */
    public double intersecttime( double x, double y, double time, int tgt )
    {
        double newtime = 0.0;
        
        // We need to figure out delta t, the smallest
        // amount of time it would take for the Chaser Point
        // to catch this Target Point. We'll use... the Law of Cosines!
        //
        // The Law of Cosines says that, in any triangle, if you know
        // the lengths of all three sides (call them a, b and c), and if you
        // know the angle (call it theta) between a and b (opposite c), then:
        //
        //    c^2 = a^2 + b^2 - 2*a*b*cos(theta)
        //
        // So, check out this triangle:
        //
        //                R
        //               / \
        //              /   \
        //        dt*v0/     \dt*vi
        //            /       \
        //           /    d    \
        //          P-----------Q
        //
        // Let P be the current position of the Chaser Point,
        // let Q be the current position of Target Point i,
        // and let R be the earliest point where the Special Point
        // could catch the Target Point. We don't know R, but we do
        // know a lot about this triangle. We know both points P and Q.
        // We also know the angle from Q to R - that's just the direction
        // the Target Point is moving, and that's an input. We can
        // get the angle from Q to P using atan2(), so we can figure
        // out the angle at Q. We can use the distance formula to get the
        // length of P-Q (call it d). We don't know the lengths of P-R and Q-R 
        // explicitly, but we do know them in terms of delta t (dt)
        // Let v0 be the speed of the Special Point, and vi be the speed
        // of Target Point i. Then the length of P-R is dt*v0, and
        // the length of Q-R is dt*vi.
        //
        // So, plugging all of that into the Law of Cosines, we 
        // get a quadratic equation in dt, which can be solved with the
        // Quadratic Formula.
        //
        // Specifically, it's:
        //  (v0^2-vi^2)*dt^2 + 2*d*vi*cos(angle)*dt - d^2 = 0
        // Let a=v0^2-vi^2, b=2*d*vi*cos(angle), and c=-d^2,
        // and then:
        //
        // solution = (-b +/- sqrt(b^2 - 4ac) ) / 2a
        
        // Here's where the Target Point is now
        double tx = targets[tgt].projectx( time );
        double ty = targets[tgt].projecty( time );
        
        // OK, first, find the angle at Q
        double angle = Math.atan2( y-ty, x-tx );
        angle -= targets[tgt].theta;
        
        // Normalize
        while( angle>TWOPI ) angle -= TWOPI;
        while( angle<0.0 ) angle += TWOPI;
        
        // It has to be less than PI.
        // If it's greater than PI, then just
        // take the other side.
        if( angle>Math.PI ) angle = TWOPI - angle;
        
        // Here's the distance d
        double d = Math.hypot( tx-x, ty-y );
        
        // The a, b, and c of the Quadratic Formula
        double a = chaserspeed*chaserspeed - targets[tgt].speed*targets[tgt].speed;
        double b = 2.0 * d * targets[tgt].speed * Math.cos( angle );
        double c = -d*d;
        
        double discriminator = b*b-4.0*a*c;
        if( discriminator < 0.0 )
        {
            // This should never happen. 
            // Since the Chaser Point is the fastest,
            // then a is always positive. Since c is
            // a negative square, it's always negative. So,
            // -4ac is always positive, as is b^2.
            //
            // Still, we'll check for it in case something
            // is wrong with the code.
            System.err.println( "a=" + a + ", b=" + b + ", c=" + c );
            System.err.println( "specialspeed=" + chaserspeed + ", tgt speeed is " + targets[tgt].speed + ", tgt is " + tgt );
            System.err.println( "Panic!! discriminator<0" );   
        }
        else
        {
            // Get the smaller delta time
            double dt = (-b - Math.sqrt( discriminator ) ) / (2.0 * a);
            
            // If that's negative, try this one
            if( dt<0.0 ) dt = (-b + Math.sqrt( discriminator ) ) / (2.0 * a);
            
            // If THAT'S negative, we've got a problem.
            if( dt<0.0 )
            {
                System.err.println( "Panic!! Negative time!");
            }
            else
            {
                // OK, here's our new time
                newtime = time+dt;  
            }
        }
        
        return newtime;        
    }
    
    /**
     * Go to a point from a state.
     * 
     * A state represents which points have been visited, and which haven't.
     * This is represented as an integer, with bits representing the points.
     * A bit is 1 if the point has NOT been visited, 0 if it HAS been visited.
     * So, essentially, a state represents the points which need to be visited.
     * 
     * For example, if the state was 9 (1001 binary) and the tgt was 2,
     * then we'd be figuring out the least time to go from a state where 
     * points 1 and 2 have been visited, and point 0 and 3 haven't, to
     * visit point 2.
     * 
     * @param state The state of the system
     * @param tgt The target point to go to.
     * @return The least time to go from the state to the target point to the end
     */
    public double go( int state, int tgt )
    {
        // We're going to visit the tgt,
        // so take it out of the state.
        state ^= 1<<tgt;
        
        // Have we seen this before?
        if( memo[state][tgt]<0 )
        {
            double best = Double.MAX_VALUE;
            
            // Go through all of the Target Points
            // which haven't been visited yet.
            // We can tell that by looking at the bits of the state.
            for( int i=0; i<n; i++ ) if( (state&(1<<i)) != 0 )
            {
                // This is the time to get to i from the start
                double time = go( state, i );
                
                // Here's where the chaser point is now
                double x = targets[i].projectx( time );
                double y = targets[i].projecty( time );
                
                // OK, here's our new time
                double newtime = intersecttime( x, y, time, tgt );  
                if( newtime<best ) best = newtime;
            }
            
            // Remember it!
            memo[state][tgt] = best;
        }
        
        return memo[state][tgt];
    }
        
    /**
     * Driver.
     * @throws Exception
     */
    public void doit() throws Exception
    {
        sc = new Scanner( new File( "movingpoints.judge" ) );
        ps = System.out; //new PrintStream( new FileOutputStream( "movingpoints.solution" ) ); 
                
        for(;;)
        {
            n = sc.nextInt();
            chaserspeed = sc.nextDouble();
            if( n==0 ) break;
            
            // Read in the Target Points
            targets = new Target[n];
            for( int i=0; i<n; i++ )
            {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                double theta = sc.nextDouble();
                double speed = sc.nextDouble();
                targets[i] = new Target( x, y, theta, speed );
            }
                        
            // Initialize besttime 
            besttime = Double.MAX_VALUE;
            
            // Shortest time from the start to each of the Target Points
            for( int i=0; i<n; i++ )
            {
                memo[0][i] = intersecttime( 0.0, 0.0, 0.0, i );
            }
            
            // Fill in the rest of the memoization array
            for( int i=1; i<memo.length; i++ )
            {
                Arrays.fill( memo[i], -1.0 );
            }
            
            // Try each of the Target Points as the first point visited
            int state = (1<<n)-1;
            for( int i=0; i<n; i++ )
            {
                double time = go( state, i );
                if( time<besttime ) besttime = time;
            }
            
            // And, here's the result.
            ps.printf( "%.2f", besttime );
            ps.println();
        }
    }
    
    /**
     * @param args
     */
    public static void main( String[] args ) throws Exception
    {
        new movingpoints().doit();
    }
}
