import java.io.*;
import java.util.*;

public class Solution {
    
    public static boolean check(int[] boys, int[] girls, boolean start){
        int n = boys.length;
        int[] combined = new int[n*2];
        
        int b = 0;
        int g = 0;
        
        for(int i=0;i<2*n;i++){
            if((i%2==0 && start) || (i%2==1 && !start))
                combined[i]=boys[b++];
            else
                combined[i]=girls[g++];
        }
        for(int i=1;i<combined.length;i++){
            if(combined[i]<combined[i-1])
                return false;
        }return true;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
        
            int[] b = new int[n];
            int[] g = new int[n];
        
            for(int i=0;i<n;i++)
                b[i]=sc.nextInt();
            for(int i=0;i<n;i++)
                g[i]=sc.nextInt();
        
            Arrays.sort(b);
            Arrays.sort(g);
        
            if(check(b,g,true) || check(b,g,false))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
