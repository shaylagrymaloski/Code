/* PrimVsKruskal.java
   CSC 226 - Summer 2020
   Assignment 2 - Prim MST versus Kruskal MST Template
   
   The file includes the "import edu.princeton.cs.algs4.*;" so that yo can use
   any of the code in the algs4.jar file. You should be able to compile your program
   with the command
   
	javac -cp .;algs4.jar PrimVsKruskal.java
	
   To conveniently test the algorithm with a large input, create a text file
   containing a test graphs (in the format described below) and run
   the program with
   
	java -cp .;algs4.jar PrimVsKruskal file.txt
	
   where file.txt is replaced by the name of the text file.
   
   The input consists of a graph (as an adjacency matrix) in the following format:
   
    <number of vertices>
	<adjacency matrix row 1>
	...
	<adjacency matrix row n>
	
   Entry G[i][j] >= 0.0 of the adjacency matrix gives the weight (as type double) of the edge from 
   vertex i to vertex j (if G[i][j] is 0.0, then the edge does not exist).
   Note that since the graph is undirected, it is assumed that G[i][j]
   is always equal to G[j][i].
*/

 import edu.princeton.cs.algs4.*;

import java.util.Iterator;
import java.util.Scanner;
 import java.io.File;

//Do not change the name of the PrimVsKruskal class
public class PrimVsKruskal{
	/* PrimVsKruskal(G)
		Given an adjacency matrix for connected graph G, with no self-loops or parallel edges,
		determine if the minimum spanning tree of G found by Prim's algorithm is equal to 
		the minimum spanning tree of G found by Kruskal's algorithm.
		
		If G[i][j] == 0.0, there is no edge between vertex i and vertex j
		If G[i][j] > 0.0, there is an edge between vertices i and j, and the
		value of G[i][j] gives the weight of the edge.
		No entries of G will be negative.
	*/
	static boolean PrimVsKruskal(double[][] G){
		int vertices = G.length;

//Prims: 		
		/* Build the MST by Prim's and the MST by Kruskal's */
		/* (You may add extra methods if necessary) */
		boolean pvisited[] = new boolean[vertices];
        MinPQ<Edge> pmst = new MinPQ<Edge>();
        IndexMinPQ<Edge> ppq = new IndexMinPQ<Edge>(vertices);
        double pweight = 0.0;

      //  add 0 row to the priority queue
		//pvisited[0] = true;
		int count = 0;
		Edge min = new Edge(0,0,1);
        for(int i = 0; i< vertices; i++){
            if(G[0][i] > 0 ){
                Edge e = new Edge(0, i, G[0][i]);
				ppq.insert(i,e);
            }
		}
        while(!ppq.isEmpty()){
			Edge se1 = ppq.minKey();
			int deleted = ppq.delMin();
            int u = se1.either();
			int v = se1.other(u);
			int value = u;

            if(!pvisited[u] || !pvisited[v]){
				if(!pvisited[v]){
					value = v;
				}
				pvisited[v] = true;
				pvisited[u] = true;
				pmst.insert(se1);
				//System.out.println(se1);
				pweight += se1.weight();
				
                for(int i = vertices - 1; i > 0; i--){
                    if(G[value][i] > 0){
						Edge e = new Edge(value, i, G[value][i]);
						if(ppq.contains(i)){
							if( G[value][i] < ppq.keyOf(i).weight()){
								ppq.changeKey(i, e);
							}
						}else{
							ppq.insert(i,e);
						}
                    }
				}
				
              
			}
		}
	
		//System.out.println("weight = "+ pweight);

// Kruskals:
 		boolean kvisited[] = new boolean[vertices];
        MinPQ<Edge> kmst = new MinPQ<Edge>();
        MinPQ<Edge> kpq = new MinPQ<Edge>();

        double kweight = 0.0;

        //put edges in priority queue
        for(int j = 0; j< vertices; j++){
            for(int i = vertices - 1; i > j; i--){
                if(G[j][i] > 0){
                  
                    Edge e = new Edge(j, i, G[j][i]);
					kpq.insert(e);
					
				}
				
            }
        }

        UF uf = new UF(vertices);
        while(!kpq.isEmpty() && kmst.size() < vertices-1){
            Edge e = kpq.delMin();
            int v = e.either();
            int u = e.other(v);
            if(uf.find(v) != uf.find(u)){
                uf.union(v,u);
				kweight += e.weight();
			//	System.out.println(e);
                kmst.insert(e);
            }
		}
	
       // System.out.println("weight = "+ kweight);

		/* Determine if the MST by Prim equals the MST by Kruskal */
		boolean pvk = true;
		/* ... Your code here ... */
		int found = 0;
		while(!pmst.isEmpty()){
			// take an element of prim mst and see if it is in kruskals mst
			Edge e = pmst.delMin();
		
			// interate through kmst to find e
			Iterator<Edge> i = kmst.iterator();
			
			while(i.hasNext()){
				Edge temp = i.next();
				if(e.weight() == temp.weight()){
					int tempE = e.either();
					int tempI = temp.either();
					if(tempE == tempI && e.other(tempE) == temp.other(tempI)){
						found = 1;
						break;
					} 
					if(tempE == temp.other(tempI) && e.other(tempE) == tempI){
						found = 1;
						break;
					}
				}
			}
			if (found == 0){
				pvk = false;
				break;
			}
			found = 0;
		}
		return pvk;	
	}
		
	/* main()
	   Contains code to test the PrimVsKruskal function. You may modify the
	   testing code if needed, but nothing in this function will be considered
	   during marking, and the testing process used for marking will not
	   execute any of the code below. 
	*/
   public static void main(String[] args) {
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Reading input values from stdin.\n");
		}
		
		int n = s.nextInt();
		double[][] G = new double[n][n];
		int valuesRead = 0;
		for (int i = 0; i < n && s.hasNextDouble(); i++){
			for (int j = 0; j < n && s.hasNextDouble(); j++){
				G[i][j] = s.nextDouble();
				if (i == j && G[i][j] != 0.0) {
					System.out.printf("Adjacency matrix contains self-loops.\n");
					return;
				}
				if (G[i][j] < 0.0) {
					System.out.printf("Adjacency matrix contains negative values.\n");
					return;
				}
				if (j < i && G[i][j] != G[j][i]) {
					System.out.printf("Adjacency matrix is not symmetric.\n");
					return;
				}
				valuesRead++;
			}
		}
		
		if (valuesRead < n*n){
			System.out.printf("Adjacency matrix for the graph contains too few values.\n");
			return;
		}	
		
        boolean pvk = PrimVsKruskal(G);
        System.out.printf("Does Prim MST = Kruskal MST? %b\n", pvk);
    }
}