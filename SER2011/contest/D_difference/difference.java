import java.io.*;
import java.util.*;
import java.awt.geom.*;

/**
 * Solution to Vive la Difference!
 * 
 * @author vanb
 */
public class difference
{
    public Scanner sc;
    public PrintStream ps;
        
    /**
     * Driver.
     * @throws Exception
     */
    public void doit() throws Exception
    {
        sc = new Scanner( new File( "difference.judge" ) );
        ps = new PrintStream( new FileOutputStream( "difference.out" ) ); 
                
        for(;;)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            if( d==0 ) break;
            
            // Keep a count
            int count = 0;
            
            // Stop when a=b=c=d
            while( a!=b || b!=c || c!=d )
            {
                // One more
                ++count;
                
                // Need a temporary variable
                int t = a;
                
                a = Math.abs( b-a );
                b = Math.abs( c-b );
                c = Math.abs( d-c );
                d = Math.abs( t-d );
            }
            
            // That's it!
            ps.println( count );
        }
    }
    
    /**
     * @param args
     */
    public static void main( String[] args ) throws Exception
    {
        new difference().doit();
    }

}
