import edu.princeton.cs.algs4.*;

public class AdjPrim{
    
    public static void main(String[] args){

        int vertices = 7;
        double adjMatrix[][] = {{0,1,2,0,0,0,0},
                                {1,0,3,4,4,0,0},
                                {2,3,0,0,0,0,6},
                                {0,4,0,0,4,4,0},
                                {0,4,0,4,0,5,0},
                                {0,0,0,4,5,0,7},
                                {0,0,6,0,0,7,0}
        };

        boolean visited[] = new boolean[vertices];
        Queue<Edge> mst = new Queue<Edge>();
        MinPQ<Edge> pq = new MinPQ<Edge>();
        double weight = 0.0;

        
        // add 0 row to the priority queue
        visited[0] = true;
        System.out.println("adding to queue");
        for(int i = 0; i< vertices; i++){
            if(adjMatrix[0][i] > 0){
                System.out.print(adjMatrix[0][i] +", " );
                Edge e = new Edge(0, i, adjMatrix[0][i]);
                pq.insert(e);
            }
        }
        
        while(!pq.isEmpty()){
            System.out.println("adding to queue");
            Edge se1 = pq.delMin();
            int u = se1.either();
            int v = se1.other(u);

            if(!visited[u] || !visited[v]){
                visited[u] = true;
                visited[v] = true;
                mst.enqueue(se1);
               // System.out.println( u + ", " + v);
                weight += se1.weight();
                // find v
                System.out.println("v = "+v);
                for(int i = vertices - 1; i >  v; i--){
                    if(adjMatrix[v][i] > 0){
                        System.out.print(adjMatrix[v][i] +", " );
                        Edge e = new Edge(v, i, adjMatrix[v][i]);
                        pq.insert(e);
                    }
                }
            }

           

        }
        System.out.println("weight " + weight);
       


        

    }
}