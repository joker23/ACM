import java.io.*;
import java.util.*;
import java.awt.geom.*;

/**
 * Solution to Vampire Numbers.
 * 
 * @author vanb
 */
public class vampirenumbers
{
    public Scanner sc;
    public PrintStream ps;
 
    /**
     * Compute a "signature" for a string. 
     * That's just another string with the characters sorted.
     * If two strings are anagrams of each other, then they'll have the same signature.
     * 
     * @param s A String
     * @return The "Signature" of String s
     */
    public static String signature( String s )
    {
        char a[] = s.toCharArray();
        Arrays.sort( a );
        return new String( a );
    }
    
    /**
     * Determine if x is a Vampire Number
     * 
     * @param x An integer
     * @return true if x is a Vampire Number, false otherwise
     */
    public boolean isvampire( int x )
    {
        boolean result = false;
        
        // Get x's signature
        String vsig = signature( "" + x );
        
        // Find factors
        for( int i=2; i*i<=x; i++ ) if( x%i==0 )
        {
            // Get the signature of the two factors put together
            String isig = signature( "" + i + "" + (x/i));
            
            // If the signatures are equal, it's a Vampire Number!
            if( isig.equals( vsig ) )
            {
                result = true;
                break;
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
        sc = new Scanner( new File( "vampirenumbers.judge" ) );
        ps = System.out; //new PrintStream( new FileOutputStream( "vampirenumbers.solution" ) ); 
               
        for(;;)
        {
            int x = sc.nextInt();
            if( x==0 ) break;
            
            // Keep looking until we find a Vampire Number
            while( !isvampire( x ) ) ++x;
            
            ps.println( x );
        }
    }
    
    public static void main( String[] args ) throws Exception
    {
        new vampirenumbers().doit();
    }
}
