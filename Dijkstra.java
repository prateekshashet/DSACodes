import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

    // Helper class for a directed connection
    public static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static int dijkstra(int src,int dest, Map<Integer, List<Edge>> graph,int V){
        int[] vis=new int[V];
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        //priority queue stores the node and the current distance
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{src,0});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int u=curr[0];
            if(u==dest) return dist[u];
            if(vis[u]==1) continue;
            vis[u]=1;

            for(Edge e: graph.get(u)){
                int v=e.target;
                int w=e.weight;
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+w <dist[v]){
                    dist[v]=dist[u]+w;
                    pq.add(new int[]{v,dist[v]});
                }
            }
        }
        return dist[dest];
    }

    public static void main(String[] args) {
        // Map from Source Vertex -> List of Edges leading out
        Map<Integer, List<Edge>> graph = new HashMap<>();

        // 1. Initialize empty lists for your vertices (e.g., 0 to 5)
        int V = 6;
        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 2. Add edges: graph.get(source).add(new Edge(target, weight));
        graph.get(0).add(new Edge(1, 7));
        graph.get(1).add(new Edge(0, 7));
         // Edge from 0 <-> 1 with weight 7

        graph.get(0).add(new Edge(2, 9)); 
        graph.get(2).add(new Edge(0, 9));
        

         graph.get(0).add(new Edge(5, 14));
        graph.get(5).add(new Edge(0, 14 ));





        graph.get(1).add(new Edge(2, 10));
        graph.get(2).add(new Edge(1, 10));
        


        graph.get(1).add(new Edge(3, 15));
        graph.get(3).add(new Edge(1,15));

        graph.get(2).add(new Edge(5,2));
        graph.get(5).add(new Edge(2,2));

        graph.get(2).add(new Edge(3,11));
        graph.get(3).add(new Edge(2,11));
        
        graph.get(4).add(new Edge(3,6));
        graph.get(3).add(new Edge(4,6));


        graph.get(5).add(new Edge(4,9));
        graph.get(4).add(new Edge(5,9));


        int x=dijkstra(0,4,graph,V);
        System.out.print(x);
    }
}