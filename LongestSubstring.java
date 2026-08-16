import java.util.HashMap;

public class LongestSubstring {
    //return the longest substring without repeating characters
    /*
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers. */


    public static int calculate(String str, int n) {
        if (str == null || n == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0; // Left pointer
        int max = 0;

        // 'i' acts as our right pointer
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            // If character was seen inside the current window, move 'l' right after its previous occurrence
            if (map.containsKey(ch)) {
                l = Math.max(l, map.get(ch) + 1);
            }

            // Update/insert the character's latest index
            map.put(ch, i);

            // Update max length for EVERY valid window
            max = Math.max(max, i - l + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcbbd";
        int n = str.length();
        int longest = calculate(str, n);
        System.out.print(longest); // Outputs: 3 ("abc", "bca", "cab", or "bd")
    }
}
       
