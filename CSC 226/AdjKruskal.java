import edu.princeton.cs.algs4.*;

public class AdjKruskal{
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

        //put edges in priority queue
        for(int j = 0; j< vertices; j++){
            for(int i = vertices - 1; i > j; i--){
                if(adjMatrix[j][i] > 0){
                    System.out.print(adjMatrix[j][i] +", " );
                    Edge e = new Edge(j, i, adjMatrix[j][i]);
                    pq.insert(e);
                }
            }
        }

        UF uf = new UF(vertices);
        while(!pq.isEmpty() && mst.size() < vertices-1){
            Edge e = pq.delMin();
            int v = e.either();
            int u = e.other(v);
            System.out.println(e + " "+uf.find(v));
            if(uf.find(v) != uf.find(u)){
                uf.union(v,u);
                weight += e.weight();
                mst.enqueue(e);
            }
        }
        System.out.println("weight = "+ weight);
       
    }
}