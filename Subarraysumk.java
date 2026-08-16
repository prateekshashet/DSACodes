import java.util.HashMap;

public class Subarraysumk {
    public static int sum(int[] a, int n, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        
        m.put(0, 1); // <--- ADD THIS LINE HERE
        
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            res += (m.getOrDefault(sum - k, 0));

            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, -1, 2};
        int n = a.length;
        int k = 3;
        int count = sum(a, n, k);
        System.out.println(count); // Will now print 3
    }
}