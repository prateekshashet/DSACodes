/*Given a string s, return true if the string is a palindrome. Otherwise, return false. 
A string is considered a palindrome if it reads the same forwards and backwards. */

import java.util.Scanner;

class Palindrome{
    public static boolean solve(String s, int left,int right){
        if(left>=right) return true;
        if(s.charAt(left)!=s.charAt(right)) return false;
        return solve(s,left+1,right-1);
    }
    public static void main(String[] args) {
        // code here
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        System.out.print(solve(s,0,n-1));
        sc.close();
    }

}
