import java.io.*;
import java.util.*;

/**
 * Solution to Hexagram.
 * 
 * @author vanb
 */
public class hexagram
{
    public Scanner sc;
    public PrintStream ps;
    
    // The input values
    public int values[] = new int[12];
    
    // have we used value i yet?
    public boolean used[] = new boolean[12];
    
    // The permutation we're building
    public int perm[] = new int[12];
    
    // A count of the number of successes so far
    public int count;
    
    // The target sum
    public int target;
    
    /**
     * Fill in one spot on the Hexagram.
     * 
     * Essentially this is just building a permutation p[], with some creative pruning.
     * 
     * Here's the trick: I'm using an unusual indexing scheme to try to eliminate
     * candidates as soon as possible. Here are my indices:
     * 
     *                    0
     *                   / \ 
     *              9---4---1---10 
     *               \ /     \ / 
     *                5       2
     *               / \     / \ 
     *              6---7---8---3 
     *                   \ / 
     *                    11
     * 
     * 
     * That way, as soon as I hit 4, I've filled in 0, 1, 2 and 3.
     * So, I know what the target sum needs to be: p[0]+p[1]+p[2]+p[3]
     *
     * As soon as I hit 6, I can eliminate any cases where p[0]+p[4]+p[5]+p[6] is not the target
     * As soon as I hit 8, I can eliminate any cases where p[6]+p[7]+p[8]+p[3] is not the target
     * When I hit 10, I can eliminate any cases where p[9]+p[4]+p[1]+p[10] is not the target
     * And, when I hit 11, I can check the remaining two.
     * 
     * @param level Which spot in the permutation to fill
     */
    public void fill( int level )
    {
        // This will get a number if the value for this spot has to 
        // exactly match something. If exact=-1, that's a flag that
        // we don't have to be so picky. If exact=0, since all input values
        // are positive, that's a flag that there's no solution possible down
        // this path.
        int exact = -1;
        switch( level )
        {
            case 4:
            {
                // Capture the target sum
                target = perm[0] + perm[1] + perm[2] + perm[3];
                break;
            }
            
            case 6:
            {
                // Spot 6 has to be exactly this
                exact = target - perm[0] - perm[4] - perm[5];
                // Less than zero? Then we're at a dead end.
                if( exact<0 ) exact=0;
                break;
            }
            
            case 8:
            {
                // Spot 8 has to be exactly this
                exact = target - perm[3] - perm[6] - perm[7];
                // Less than zero? Then we're at a dead end.
                if( exact<0 ) exact=0;
                break;
            }
            
            case 10:
            {
                // Spot 10 has to be exactly this
                exact = target - perm[9] - perm[4] - perm[1];   
                // Less than zero? Then we're at a dead end.
                if( exact<0 ) exact=0;
                break;
            }
            
            case 11:
            {
                // Spot 11 has two constraints.
                // If the two are inconsistent or negative,
                // then we'll say it's not possible 
                exact = target - perm[9] - perm[5] - perm[7];
                if( exact<0 || exact!=target-perm[10]-perm[2]-perm[8] ) exact=0;
                break;
            }
            
            case 12:
            {
                // We made it to level 12? Then we've got a solution!
                // Count it.
                ++count;
                break;
            }
        }
        
        if( level<12 )
        {
            // We can further quicken things by fixing some values beforehand.
            // We'll use perms[x]==0 to signal that this value has NOT been set yet, and we need
            // to set it.
            if( perm[level]==0 )
            {
                // Go through all of the values which haven't been used yet
                for( int i=0; i<12; i++ ) if( !used[i] )
                {
                    // If the value matches exactly, or if we don't care (exact=-1)
                    // then go for it
                    if( exact<0 || values[i]==exact )
                    {
                        // use this value
                        used[i] = true;
                        perm[level] = values[i];
                        
                        // Go to the next level
                        fill( level+1 );
                        
                        // Unuse this value
                        used[i] = false;
                    }
                }
                // Free up perm[level]
                perm[level]=0;
            }
            else
            {
                // If we've already determined this spot, 
                // then just move on to the next level.
                fill( level+1 );
            }
        }
    }
    
    /**
     * Driver.
     * @throws Exception
     */
    public void doit() throws Exception
    {
        sc = new Scanner( new File( "hexagram.judge" ) );
        ps = System.out; 
        
        for(;;)
        {
            // Read in the 12 values
           for( int i=0; i<12; i++ )
           {
               values[i] = sc.nextInt();
           }
           if( values[0]==0 ) break;
           
           // Because of rotational symmetry, we can further prune by fixing
           // the first value in one of two spots - the first (a point) 
           // and the second (an inner node). Those are really the only two kinds of positions.
           
           // Start by initializing the used[] array
           Arrays.fill( used, false );
           // We'll fix the position of the first one, so it'll be used right off the bat
           used[0] = true;

           //Initialize the counter
           count = 0;

           // Zero out the perm arrays
           Arrays.fill( perm, 0 );
           // Fix the first value in the first position
           perm[0] = values[0];
           // count
           fill( 0 );
           
           // Start again
           Arrays.fill( perm, 0 );
           // Fix the first value in the second position
           perm[1] = values[0];
           // count
           fill( 0 );
           
           // Because of reflection, we'll still count twice as
           // many, so we must divide by 2.
           ps.println( count / 2 );
        }
    }

    /**
     * @param args
     */
    public static void main( String[] args ) throws Exception
    {
        new hexagram().doit();
    }
}
