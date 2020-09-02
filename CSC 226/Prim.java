import edu.princeton.cs.algs4.*;


public class Prim{
    public static void main(String[] args){

        EdgeWeightedGraph G = new EdgeWeightedGraph(5);
        Edge e1= new Edge(2,4,.9);
        Edge e2= new Edge(2,4,.0);
        Edge e3= new Edge(4,3,.7);
        Edge e4= new Edge(1,3,.6);
        Edge e5= new Edge(2,1,.3);
        Edge e6= new Edge(0,1,.5);
        Edge e7= new Edge(0,2,.4);
        Edge e8= new Edge(1,4,.8);
        G.addEdge(e1);
        G.addEdge(e2);
        G.addEdge(e3);
        G.addEdge(e4);
        G.addEdge(e5);
        G.addEdge(e6);
        G.addEdge(e7);
        G.addEdge(e8);

        boolean marked;
        double weight = 0;
        Queue<Edge> mst = new Queue<Edge>();
        MinPQ<Edge> pq = new MinPQ<Edge>();
        LazyPrimMST primst = new LazyPrimMST(G);
        boolean array[] = new boolean[7];
        array[0] = true;

        for (Edge e : G.adj(0)){
            pq.insert(e);
           // System.out.println("inserted: "+ e.weight());
        }

        while(!pq.isEmpty()){
            Edge se1 = pq.delMin();
            int u = se1.either();
            int v = se1.other(u);

            if(!array[u] || !array[v]){
                array[u] = true;
                array[v] = true;
                mst.enqueue(se1);
               // System.out.println( u + ", " + v);
                weight += se1.weight();
                for (Edge e : G.adj(v)){
                    pq.insert(e);
                   // System.out.println("inserted: "+ e.weight());
                }
            }

        }


        System.out.println("Weight calculated: " + weight);
        System.out.println("Weight from lazy prim class: " +primst.weight() );
            

    }
}