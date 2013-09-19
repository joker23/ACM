import java.io.*;
import java.util.*;

/**
 * Solution to Robot Navigation.
 * 
 * We'll solve this with a slightly modified Breadth-First Search.
 * 
 * @author vanb
 */
public class robotnavigation
{
    public Scanner sc;
    public PrintStream ps;
    
    // Modulo stated in the problem
    public static final int mod = 1000000;
    
    /**
     * A State on the queue for our BFS
     */
    public class State
    {
        // A State will consist of an [i,j] position, 
        // a direction d (d=0, 1, 2 or 3),
        // and the length of the path to get here.
        public int i, j, d, len;
        
        /**
         * Create a state.
         * 
         * @param ii i
         * @param jj j
         * @param dd d
         * @param ll length
         */
        public State( int ii, int jj, int dd, int ll )
        {
            i=ii; j=jj; d=dd; len=ll;
        }
        
        /**
         * Debugging helper.
         * 
         * @return Pretty string version of this State
         */
        public String toString()
        {
            return "[i=" + i + ",j=" + j + ",d=" + d + ",len=" + len + "]";
        }
    }
    
    // paths[i][j][d] is the number of paths that take you from the starting
    // position to [i,j] facing direction d, in the minimum number of steps
    public int paths[][][] = new int[100][100][4];
    
    // len[i][j][d] is the length of the shortest path (i.e. program) that
    // gets you to position [i,j] facing direction d 
    public int len[][][] = new int[100][100][4];
    
    // Size of the grid
    public int n, m;
    
    // The grid itself
    public char grid[][];
    
    // Delta-i for the four directions 0=N, 1=E, 2=S, 3=W
    public static final int di[] = { -1, 0, 1, 0 };
    
    // Delta-j for the four directions 0=N, 1=E, 2=S, 3=W
    public static final int dj[] = { 0, 1, 0, -1 };
    
    // Queue for the BFS
    public LinkedList<State> queue = new LinkedList<State>();
    
    /**
     * Make a move.
     * 
     * @param i Target i
     * @param j Target j
     * @param d Target direction
     * @param s Previous state
     */
    public void makemove( int i, int j, int d, State s )
    {
        // If we haven't been here before
        if( len[i][j][d]==0 ) 
        {
            // It took us one more step from the
            // previous state to get here
            len[i][j][d] = s.len+1; 
            
            // Put this new state on the queue!
            queue.add( new State( i, j, d, s.len+1 ) );
        }
        
        // If we got here with a path equal in length to the shortest path,
        if( len[i][j][d]==s.len+1 )
        {
            // All the paths that got you to that previous state get you here, in one more step
            // So, count them!
            paths[i][j][d] += paths[s.i][s.j][s.d];
            
            // Mod for large numbers
            paths[i][j][d] %= mod;
        }        
    }
    
    /**
     * Driver.
     * @throws Exception
     */
    public void doit() throws Exception
    {
        sc = new Scanner( new File( "robotnavigation.judge" ) );
        ps = System.out; //new PrintStream( new FileOutputStream( "robotnavigation.solution" ) ); 
               
        int caseno = 0;
        for(;;)
        {
            ++caseno;
            n = sc.nextInt();
            m = sc.nextInt();
            if( n==0 ) break;
            
            // Create the grid
            grid = new char[n][];
            
            // (si,sj) will be the starting position
            // (ti,tj) will be the target position
            // d will be the direction
            int si=0, sj=0, ti=0, tj=0, d=0;
            
            // Count the number of targets and the number of starts.
            // At the end, both should be 1.
            int nt=0, ns=0;
            
            // Go line by line
            for( int i=0; i<n; i++ )
            {
                sc.nextLine();
                grid[i] = sc.next().toCharArray();
                
                // Go through each line, looking for our special points
                for( int j=0; j<m; j++ )
                {
                    switch( grid[i][j] )
                    {
                        case 'X' : ti=i; tj=j; ++nt; break;      // Record the target position
                        case 'N' : si=i; sj=j; d=0; ++ns; break; // Record the start position, 0=North
                        case 'E' : si=i; sj=j; d=1; ++ns; break; // Record the start position, 1=East
                        case 'S' : si=i; sj=j; d=2; ++ns; break; // Record the start position, 2=South
                        case 'W' : si=i; sj=j; d=3; ++ns; break; // Record the start position, 3=West
                    }
                }
            }
            
            // Some stuff for the judges to make sure that the data is clean
            if( nt!=1 ) System.err.println( "PANIC! case " + caseno + " has " + nt + " targets!" );
            if( ns!=1 ) System.err.println( "PANIC! case " + caseno + " has " + ns + " starts!" );
            
            // Initialize the two arrays that remember important stuff
            for( int i=0; i<n; i++ )for( int j=0; j<m; j++ )
            {
                Arrays.fill( paths[i][j], 0 );
                Arrays.fill( len[i][j], 0 );
            }
            
            // There's one way to get to the start
            paths[si][sj][d] = 1;
            
            // Clear the queue, put the starting condition on it
            queue.clear();
            queue.add( new State( si, sj, d, 0 ) );  
            
            // Have we found a path to the target?
            // When we do, remember its length
            int foundpath = Integer.MAX_VALUE;
            
            // BFS!!
            while( !queue.isEmpty() )
            {
                State s = queue.removeFirst();
                                
                // If the length of this path is longer than the path we found 
                // to the target, then there's no reason to go on.
                if( s.len > foundpath ) break;
                
                // If we've reached the target, remember the length.. but don't stop!
                // There may be other equivalent ways to get here!
                if( s.i==ti && s.j==tj ) foundpath = s.len;
                
                // Turn right
                int newd = (s.d+1)%4;
                makemove( s.i, s.j, newd, s );

                // Turn left
                newd = (s.d+3)%4;
                makemove( s.i, s.j, newd, s );
                
                // Move forward
                int newi = s.i + di[s.d];
                int newj = s.j + dj[s.d];
                
                // Make sure the new position is on the grid and not blocked.
                while( 0<=newi && newi<n && 0<=newj && newj<m && grid[newi][newj]!='*' )
                {
                    makemove( newi, newj, s.d, s );
                    newi += di[s.d];
                    newj += dj[s.d];
                }   
            }
            
            // Find the minimum path length to get to (ti,tj) regardless of direction facing
            int minlen = Integer.MAX_VALUE;
            for( int i=0; i<4; i++ )
            {
                if( len[ti][tj][i]<minlen && len[ti][tj][i]>0 ) minlen = len[ti][tj][i];
            }
            
            // Count the number of paths with the minimum length
            int totalpaths = 0;
            for( int i=0; i<4; i++ )
            {
                if( len[ti][tj][i]==minlen ) 
                {
                    totalpaths += paths[ti][tj][i];
                    totalpaths %= mod;
                }
            }
            
            // If we found no paths, then output 0
            ps.println( (totalpaths==0?0:minlen) + " " + totalpaths );
        }
    }

    /**
     * @param args
     */
    public static void main( String[] args ) throws Exception
    {
        new robotnavigation().doit();
    }

}
