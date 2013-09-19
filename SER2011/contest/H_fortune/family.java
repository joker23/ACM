import java.io.*;
import java.util.*;
import java.awt.geom.*;

/**
 * Solution to Family Fortune.
 * 
 * @author vanb
 */
public class family
{
    public Scanner sc;
    public PrintStream ps;
    
    // Input parameters
    public int n, k;
    
    // Weights of the nodes
    public int weights[] = new int[100001];
    
    // Children of the nodes
    public LinkedList<Integer> children[] = new LinkedList[100001];
    
    /**
     * Given a node, and the best sums for 0..k that we've got so far,
     * figure out what the best is that we can do with this node.
     * 
     * We'll pass around some arrays. These arrays represent intermediate sums.
     * So, sums[i] represents the best sum we've found so far, using a
     * total of i nodes.
     * 
     * @param node Node index
     * @param sums Array of intermediate sums.
     */
    public void solve( int node, int sums[] )
    {
        int i;
        
        // Start by seeing what all of the children can do.        
        int newsums[] = Arrays.copyOf( sums, sums.length );
        
        // Visit the children
        for( int child : children[node] )
        {
            solve( child, newsums );
        }
                
        // Now, for each i, figure out whether we can do better by using this
        // node and shunting off all of its children, or by passing this node
        // and using its children.
        for( i=k; i>=2; i-- )
        {
            // sums[x] is 0 if we don't have enough nodes yet to have a sum of x nodes.
            // If we don't then we don't want to go on from there. That's what the sums[parent][i-1]>0 is for.
            //
            // Other than that, sums[i-1]+weights[node] is what we get if we ignore the children and simply
            // add this node's weight to what we had before, and newsums[i] is what we get if we bypass
            // this node and use whatever its children can generate.
            sums[i] = ( sums[i-1]>0 && sums[i-1]+weights[node]>newsums[i] ) 
                            ? (sums[i-1]+weights[node]) : newsums[i];
        }
        
        // If this can be the best first node, then we don't care about the previous nodes.
        sums[1] = Math.max( weights[node], newsums[1] );
    }
    /**
     * Driver.
     * @throws Exception
     */
    public void doit() throws Exception
    {
        sc = new Scanner( System.in ); //new File( "family.judge" ) );
        ps = System.out; //new PrintStream( new FileOutputStream( "family.out" ) ); 
        
        // Allocate these once, and then just clear the ones we need on each case.
        for( int i=0; i<100000; i++ )
        {
            children[i] = new LinkedList<Integer>();
        }
        
        for(;;)
        {
            n = sc.nextInt();
            k = sc.nextInt();
            if( n==0 ) break;
            
            // Clear out the children to start afresh
            for( int i=0; i<=n; i++ )
            {
                children[i].clear();
            }            
            int root = 0;
            
            // Read the tree
            // The nodes are numbers 1..n, not the usual 0..n-1
            for( int i=1; i<=n; i++ )
            {
                int p = sc.nextInt();
                int w = sc.nextInt();
                
                if( p==0 )
                {
                    root = i;
                }
                else
                {
                    children[p].add( i );
                }
                
                weights[i] = w;
            }
            
            // Initialize sums
            int sums[] = new int[k+1];
            Arrays.fill( sums, 0 );
            
            // Let the recursion do the work
            solve( root, sums );
            
            // Print out the best we can do with k nodes
            ps.println( sums[k] );
        }
    }

    /**
     * @param args
     */
    public static void main( String[] args ) throws Exception
    {
        new family().doit();
    }

}
