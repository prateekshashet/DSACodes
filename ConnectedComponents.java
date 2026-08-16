import java.util.ArrayList;

class ConnectedComponents{
    /*
    Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], 
    where each entry edges[i] = [u, v] denotes an edge between vertices u and v. Count the number of connected components in the graph. 
    Two vertices belong to the same connected component if there is a path between them. */
    public static void dfs(ArrayList<ArrayList<Integer>> adj,int i,int[] vis){
        vis[i]=1;
        for(int neighbors: adj.get(i)){
            if(vis[neighbors]!=1){
                dfs(adj,neighbors,vis);
            }
        }
    }

    public static void main(String[] args){
        int[][] edges={{0, 1}, {2, 1}, {3, 4}};
        int V=5;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int c=0;
        int[] vis=new int[V];

        for(int i=0;i<V;i++){
            if(vis[i]==0){
                c++;
                dfs(adj,i,vis);
                
            }
        }
        System.out.print(c);

    }
}