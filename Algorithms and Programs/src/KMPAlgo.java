/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
 import java.util.Arrays;
import java.util.Scanner;
public class KMPAlgo {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        System.out.println("Enter Text: ");
        String text = S.next();
        text = "K" + text;
        System.out.println("Enter Pattern: ");
        String pattern = S.next();
        pattern = "K" + pattern;
        int pi[] = new int[pattern.length()];
        int m = pattern.length();
        pi[1] = 0;
        int k = 0;
        for(int q = 2; q<m; q++){
            while(k>0 && pattern.charAt(k+1) != pattern.charAt(q)){
                k = pi[k];
            }
            if(pattern.charAt(k+1) == pattern.charAt(q)){
                k++;
                pi[q] = k;
            }
        }
        System.out.println("The Prefix Function is:\n");
        System.out.println(Arrays.toString(pi));
        
        int n = text.length();
        int q = 0;
        for(int i = 1; i<n; i++){
            while(q>0 && pattern.charAt(q+1) != text.charAt(i)){
                q = pi[q];
            }
            if(pattern.charAt(q+1) == text.charAt(i))
                q++;
            if(q == m-1){
                System.out.println("Pattern found with " + (i-m+1) + " shifts");
                q = pi[q];
            }
        }
    }
}


