import java.io.*;
import java.util.*;
import java.awt.geom.*;

/**
 * Solution to Sunday Drive.
 * 
 * @author vanb
 */
public class sundaydrive
{
    public Scanner sc;
    public PrintStream ps;
    
    public static final int MAX_SEGMENTS = 100000;
    public static final int MAX_LANES = 10;
    
    // Lengths (or Radii) of the segments
    public int lengths[] = new int[MAX_SEGMENTS+1];
    
    // 'S', 'L' or 'R', depending on the type of the segment.
    public char types[] = new char[MAX_SEGMENTS+1];
    
    // best[i][j] will be the least distance it takes to drive from the
    // beginning of the highway to the end of segment i, ending up in lane j.
    public double best[][] = new double[MAX_SEGMENTS+1][MAX_LANES];
        
    /**
     * Driver.
     * @throws Exception
     */
    public void doit() throws Exception
    {
        sc = new Scanner( new File( "sundaydrive.judge" ) );
        ps = System.out; // new PrintStream( new FileOutputStream( "sundaydrive.solution" ) ); 
                
        for(;;)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if( n==0 ) break;
            
            // Read in segment info, initialize best[][]
            // To save confusion, we'll index the segments from 1 instead of the
            // usual 0. So, lengths[1] corresponds to the first segment.
            // best[0][j] will correspond to starting in lane j.
            Arrays.fill( best[0], 0.0 );
            for( int i=0; i<n; i++ )
            {
                types[i+1] = sc.next().charAt( 0 );
                lengths[i+1] = sc.nextInt();
                Arrays.fill( best[i+1], Double.MAX_VALUE );
            }    
            
            // Go through each segment
            for( int i=1; i<=n; i++ )
            {
                switch( types[i] )
                {
                    case 'S':
                    { 
                        // It takes 100 feet to change lanes. 
                        // So, this is the number of lanes we can cross,
                        // given the length of the straight segment.
                        int crossable = lengths[i]/100;
                        
                        // For each lane..
                        for( int j=0; j<m; j++ )
                        {
                            double least = Double.MAX_VALUE;
                            
                            // Figure out the distance to get to this lane at the end of the segment, 
                            // starting from each of the lanes at the start of the segment.
                            for( int k=0; k<m; k++ )
                            {
                                // Number of lanes crossed
                                int changed = Math.abs( k-j );
                                
                                // Do we have enough length to cross that many lanes?
                                if( changed<=crossable )
                                {
                                    // The least distance to cross lanes is to take the whole segment to do it.
                                    // So, we'll use the Pythagorean theorem to get that distance.
                                    // The length of the segment is one leg of a right triangle,
                                    // the number of lanes changed x 10 feet per lane is the other.
                                    // The hypotenuse is the distance we want.
                                    double distance = best[i-1][k] + Math.hypot( lengths[i], 10.0*changed );
                                    if( distance<least ) least = distance;
                                }
                            }
                            best[i][j] = least;
                        }
                        break;
                    }
                    
                    case 'L':
                    {
                        // Have to stay in your lane turning left or right.
                        for( int j=0; j<m; j++ )
                        {
                            double radius = lengths[i]+5.0+10.0*j;
                            best[i][j] = best[i-1][j] + 0.5 * Math.PI * radius;
                        }
                        break;
                    }
                    
                    case 'R':
                    {
                        // Have to stay in your lane turning left or right.
                        for( int j=0; j<m; j++ )
                        {
                            double radius = lengths[i]+5.0+10.0*(m-1-j);
                            best[i][j] = best[i-1][j] + 0.5 * Math.PI * radius;
                        }
                        break;
                    }
                    
                    default:
                    {
                        System.err.println( "PANIC!! Unknown segment type: <" + types[i] + ">" );
                    }
                }
            }
            
            // Go through all of the lanes at the end of the highway,
            // see which has the least distance.
            double least = Double.MAX_VALUE;
            for( int j=0; j<m; j++ )
            {
                if( best[n][j]<least ) least = best[n][j];
            }
            
            ps.printf( "%.2f", least );
            ps.println();
            
        }
    }
    
    /**
     * @param args
     */
    public static void main( String[] args ) throws Exception
    {
        new sundaydrive().doit();  
    }

}
