import java.io.*;
import java.util.*;
import java.awt.geom.*;

/**
 * Solution to Folding Game.
 * 
 * @author vanb
 */
public class folding
{
    public Scanner sc;
    public PrintStream ps;
    
    /**
     * Class to hold the info about a fold.
     * 
     * @author vanb
     */
    public class Fold
    {
        // w & h are height and width AFTER the fold.
        // overlap is the amount of overlap caused by the fold.
        public int w, h, overlap;
        
        // Which edge folds? T, B, L or R
        public char edge;
        
        // Consider a single fold. After the fold, there's a part with
        // a thickness of 2 and a part with a thickness of 1. If k is small,
        // then the single-thickness part doesn't move.
        // However, If k>w/2 for R,L or k>h/2 for T,B, then
        // that single thickness part "flips" over the other part.
        // This variable captures whether that happens or not.
        public boolean flip;
        
        /**
         * Create a fold.
         * 
         * @param ww Width after folding
         * @param hh Height after folding
         * @param o Amount of overlap
         * @param e Relative edge
         * @param f Flip?
         */
        public Fold( int ww, int hh, int o, char e, boolean f )
        {
            w = ww;
            h = hh;
            overlap = o;
            edge = e;
            flip = f;
        }
        
        /**
         * Produce a pretty String for debugging.
         * 
         * @return Pretty String
         */
        public String toString()
        {
            return "[w=" + w + ",h=" + h + ",overlap=" + overlap + ",edge=" + edge + ",flip=" + flip + "]";
        }
        
        /**
         * X will be in a different place if the fold "flips".
         * 
         * @param x X location
         * @return Modified X location
         */
        public int getx( int x )
        {
            return flip ? w+overlap-x : x;
        }
        
        /**
         * Y will be in a different place if the fold "flips".
         * 
         * @param y Y location
         * @return Modified Y location
         */
        public int gety( int y )
        {
            return flip ? h+overlap-y : y;
        }
    }
    
    /** Array of folds */
    Fold folds[];
    
    /**
     * Count the number of layers at this point, for the given folds. 
     * This recursive routine will essentially "unfold" the paper,
     * one fold at a time.
     * 
     * @param n Starting fold
     * @param x x of (x,y) point
     * @param y y of (x,y) point
     * @return Number of layers at the given point.
     */
    int countlayers( int n, int x, int y )
    {
        int result=1;
        
        // No more folds?
        if( n==0 )
        {
            // Then there's one layer.
            result = 1;
        }
        else
        {
            // This is where we are in the folds[] array
            --n;
            
            // Capture w, h, overlap
            int w = folds[n].w;
            int h = folds[n].h;
            int overlap = folds[n].overlap;
            
            // Do different things based on the edge folded
            switch( folds[n].edge )
            {
                case 'T':
                {
                    // Here's where the point is on the unfolded paper
                    result = countlayers( n, x, folds[n].gety(y) );
                    if( y>h-overlap)
                    {
                        // If it's in the double-folded section, 
                        // then the point is also here.
                        result += countlayers( n, x, folds[n].gety(h+h-y) );   
                    }
                    break;
                }
                
                case 'B':
                {
                    // Here's where the point is on the unfolded paper
                    result = countlayers( n, x, folds[n].gety(y+overlap) );
                    if( y<overlap )
                    {
                        // If it's in the double-folded section, 
                        // then the point is also here.
                        result += countlayers( n, x, folds[n].gety(overlap-y) );   
                    }
                    break;
                }
                
                case 'R':
                {
                    // Here's where the point is on the unfolded paper
                    result = countlayers( n, folds[n].getx(x), y );
                    if( x>w-overlap )
                    {
                        // If it's in the double-folded section, 
                        // then the point is also here.
                        result += countlayers( n, folds[n].getx(w+w-x), y );   
                    }
                    break;
                }
                
                case 'L':
                {
                    // Here's where the point is on the unfolded paper
                    result = countlayers( n, folds[n].getx(x+overlap), y );
                    if( x<overlap )
                    {
                        // If it's in the double-folded section, 
                        // then the point is also here.
                        result += countlayers( n, folds[n].getx(overlap-x), y );   
                    }
                    break;
                }
            }
        }
        return result;
    }
    
    /**
     * Driver.
     * @throws Exception
     */
    public void doit() throws Exception
    {
        sc = new Scanner( new File( "folding.judge" ) );
        ps = System.out; //new PrintStream( new FileOutputStream( "folding.out" ) ); 
        
        for(;;)
        {
            int oldw = sc.nextInt();
            int oldh = sc.nextInt();
            int n = sc.nextInt();
            if( n==0 && oldw==0 && oldh==0 ) break;
            
            // Create the folds
            folds = new Fold[n];
            
            // For each fold...
            for( int i=0; i<n; i++ )
            {
                // Read in the fold
                char edge = sc.next().charAt( 0 );
                int k = sc.nextInt();
                
                // Now, fold the paper
                switch( edge )
                {
                    case 'T':
                    case 'B':
                    {
                        // Something for the judges to check the validity of the input
                        if( k>=oldh ) System.err.println( "PANIC!! k is " + k + " but height is " + oldh );
                        
                        // Create a new fold, modify the height
                        int overlap = Math.min( k, oldh-k );
                        int newh = oldh-overlap;
                        folds[i] = new Fold( oldw, newh, overlap, edge, overlap!=k );
                        oldh = newh;
                        break;
                    }
                    
                    case 'R':
                    case 'L':
                    {
                        // Something for the judges to check the validity of the input
                        if( k>=oldw ) System.err.println( "PANIC!! k is " + k + " but width is " + oldw );
                        
                        // Create a new fold, modify the width
                        int overlap = Math.min( k, oldw-k );
                        int neww = oldw-overlap;
                        folds[i] = new Fold( neww, oldh, overlap, edge, overlap!=k );
                        oldw = neww;
                        break;
                    }
                    
                    default: 
                    {
                        // Something for the judges to check the validity of the input
                        System.err.println( "PANIC! Unknown char! " + edge );
                    }
                }
                
            }
            
            // Read in the point
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            // Count the layers!
            ps.println( countlayers( n, x, y ) );
        }
    }

    /**
     * @param args
     */
    public static void main( String[] args ) throws Exception
    {
        new folding().doit();
    }
}
