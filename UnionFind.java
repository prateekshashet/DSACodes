
public class UnionFind {
    private int[] parent;

    public UnionFind(int size) {
      
        // Initialize the parent array with each 
        // element as its own representative
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    // Find the representative (root) of the 
    // set that includes element i
    public int find(int i) {
      
        // if i itself is root or representative
        if (parent[i] == i) {
            return i;
        }
      
        // Else recursively find the representative
        // of the parent 
        return find(parent[i]);
    }

    // Unite (merge) the set that includes element 
    // i and the set that includes element j
    public void union(int i, int j) {
      
        // Representative of set containing i
        int irep = find(i);

        // Representative of set containing j
        int jrep = find(j);

        // Make the representative of i's set be 
        // the representative of j's set
        parent[irep] = jrep;
    }

    public static void main(String[] args) {
        int size = 5;
        UnionFind uf = new UnionFind(size);
        uf.union(1, 2);
        uf.union(3, 4);
        boolean inSameSet = uf.find(1) == uf.find(3);
        System.out.println("Are 1 and 2 in the same set? " + inSameSet);
    }
}



/*VARIENT OF THE QUESTION
We are given 10 individuals say, a, b, c, d, e, f, g, h, i, j

Following are relationships to be added:
a <-> b  
b <-> d
c <-> f
c <-> i
j <-> e
g <-> j


import java.util.*;

public class UnionFind {

    private int[] parent;

    public UnionFind(int size) {
        parent = new int[size];

        for (int i = 0; i < size; i++)
            parent[i] = i;
    }

    public int find(int i) {
        if (parent[i] == i)
            return i;

        return find(parent[i]);
    }

    public void union(int i, int j) {

        int root1 = find(i);
        int root2 = find(j);

        parent[root1] = root2;
    }

    public static void main(String[] args) {

        String[] names = {
                "a","b","c","d","e",
                "f","g","h","i","j"
        };

        UnionFind uf = new UnionFind(names.length);

        uf.union(0,1); // a-b
        uf.union(1,3); // b-d

        uf.union(2,5); // c-f
        uf.union(2,8); // c-i

        uf.union(9,4); // j-e
        uf.union(6,9); // g-j

        HashMap<Integer, ArrayList<String>> groups = new HashMap<>();

        for(int i=0;i<names.length;i++){

            int root = uf.find(i);

            groups.putIfAbsent(root,new ArrayList<>());
            groups.get(root).add(names[i]);
        }

        System.out.println("Disjoint Sets:");

        for(ArrayList<String> group : groups.values()){
            System.out.println(group);
        }
    }
}



output
[a,b,d]
[c,f,i]
[e g j]
[h]

*/