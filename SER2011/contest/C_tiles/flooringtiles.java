import java.io.*;
import java.util.*;

/**
 * Solution to Flooring Tiles
 * 
 * @author vanb
 */
public class flooringtiles
{
    public Scanner sc;
    public PrintStream ps;
    
    // The largest possible value,
    // as stated in the problem
    public static final long biggest = 1000000000000000L;
    
    // We'll precompute prime powers to speed things up.
    // primepowers[i][j] will be i^j, if i is prime and i^j<biggest.
    // Otherwise, primepowers[i][j] will be 0.
    public long primepowers[][] = new long[100][1000];
    
    // Obviously, isprime[i] is true iff i is prime.
    public boolean isprime[] = new boolean[100];
            
    /**
     * Find the smallest number that has exactly n factors, with p as its smallest prime factor.
     * 
     * How do we find a number that has exactly n factors? Let's look at primes.
     * Assume p, q and r are all primes. 
     * How many factors does p have? The answer is 2: 1 and p.
     * How about p*p? Thats 3: 1, p, and p*p.
     * How about p*p*p? That's 4: 1, p, p*p and p*p*p.
     * So, p^i has i+1 factors.
     * 
     * Now, what about p*q? That has 4: 1, p, q, and p*q.
     * How about p*p*q? That's 6: 1, p, q, p*p, p*q, and p*p*q.
     * How about p*p*p*q? That's 8 (left as an exercise for the reader!)
     * What about p*p*q*q? That's 9.
     * What of p*p*q*q*r*r? 27.
     * 
     * In fact, it shouldn't be hard to convince yourself that
     * if a has exactly x factors, and b has exactly y factors, then a*b has exactly x*y factors.
     * 
     * Armed with that knowledge, then to construct a number with exactly n factors, 
     * we just need to put together primes like this:
     * 
     * p^i * q^j * r^k * ...
     * where n=(i+1)*(j+1)*(k+1)*...
     * 
     * Or, stated another way,
     * p^(i-1) * q^(j-1) * r^(k-1) * ...
     * where n=i*j*k*...
     *
     * There are lots of such numbers for any n - to get the smallest one,
     * we'll use the smallest primes. We'll start with 2, then 3, then 5, and so on. 
     * We'll also make sure that 2 has the highest exponent, then 3, then 3, etc.
     * We'll break n up into factors, and use those (minus one) as exponents.
     *
     * @param n Number of desired factors
     * @param p Smallest prime
     * @param square Are we looking for a perfect square?
     * @param most The greatest number of a prime we can use.
     * @return The minimum, as stated.
     */
    public long minimum( int n, int p, boolean square, int most )
    {
        long result = biggest;
        
        if( n==1 )
        {
            result = 1L;
        }
        else
        {
            // Find the next highest prime
            int nextp = p;
            for( ++nextp; !isprime[nextp]; ++nextp );
            
            // Find factors of n
            for( int i=1; i<n; i++ ) if( n%i==0 )
            {
                // n = i*f
                int f = n/i;
                
                // If the exponent is smaller than or equal to an exponent we've already used,
                // then go ahead, otherwise no go. We're looking at the primes
                // in ascending order, so we want the biggest exponents to come first.
                //
                // Also, if we're looking for a perfect square, then 
                // the exponent has to be even. Since f-1 is the exponent,
                // f must be odd.
                if( f-1<=most && (!square || f%2==1) )
                {
                    long possibility = primepowers[p][f-1];
                    
                    // Check and make sure the prime power isn't too big
                    if( possibility!=0 )
                    {
                        long min = minimum( i, nextp, square, f-1 );
                        
                        // Only multiply if it won't overflow.
                        if( min < biggest/possibility )
                        {
                            possibility *= min ;
                            if( possibility<result ) result = possibility;
                        }
                    }
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
        sc = new Scanner( new File( "flooringtiles.judge" ) );
        ps = System.out; //new PrintStream( new FileOutputStream( "flooringtiles.solution" ) ); 
            
        // Use the Sieve of Eratosthanes to discover primes
        Arrays.fill( isprime, true );
        isprime[0] = isprime[1] = false;
        
        for( int i=2; i<isprime.length; i++ ) if( isprime[i] )
        {
            // This is the sieve of Eratosthanes. If i is prime,
            // then mark 2*i, 3*i, 4*i, etc. as not prime.            
            for( int j=i+i; j<isprime.length; j+=i ) isprime[j] = false;
            
            // We'll also compute prime powers here, to save time later.
            // primepowers[i][x] will be i^x if i is prime, 0 otherwise.
            Arrays.fill( primepowers[i], 0L );
            primepowers[i][0] = 1L;
            for( int j=1; j<primepowers[i].length; j++ )
            {
                primepowers[i][j] = primepowers[i][j-1] * i;
                
                // Use 0 as an indication of overflow
                if( primepowers[i][j] > biggest )
                {
                    primepowers[i][j] = 0L;
                    break;
                }
            }
        }
        
        for(;;)
        {
            int n = sc.nextInt();
            if( n==0 ) break;
            
            // If you can form n unique rectangles with x little boxes, then there
            // must be n factors of x less than or equal to its square root. So, there are
            // two cases - either it has 2n total factors, or it's a perfect square 
            // and it has 2n-1 factors. We'll compute both, and take the smaller of the two.
            long answer = Math.min( minimum( n+n, 2, false, n+n ), minimum( n+n-1, 2, true, n+n ) );
            ps.println( answer );
        }
    }
    
    public static void main( String[] args ) throws Exception
    {
        new flooringtiles().doit(); 
    }
}
