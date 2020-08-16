package swea;
import java.util.*;
 
public class SWEA_1244maximumPrize {
	
	//최대상금 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();
         
        for(int t = 1; t <= tc; t++) {
            String s = scan.next();
            int n = scan.nextInt();
            int[] a = new int[s.length()];
             
            for(int i = 0; i < s.length(); i++) {
                a[i] = s.charAt(i) - '0';
            }
             
            for(int i = 0; i < a.length; i++) {
                ArrayList <Integer> l = new ArrayList();
                int cnt = 0;
                int max = a[i];
                
                
                for(int j = i + 1; j < a.length; j++) {
                    if(a[i] < a[j])  max = Math.max(max, a[j]);     
                }
                for(int j = i + 1; j < a.length; j++) {
                    if(a[j] == max)    l.add(j); 
                }
                for(int j = i + 1; j < n; j++) {
                    if(j >= a.length)break;
                    if(a[j] < a[i]) cnt++;
                }
                
                if(l.size() == 1) {
                    int tmp = a[i];
                    a[i] = a[l.get(0)];
                    a[l.get(0)] = tmp;
                    n--;
                }
                
                if(l.size() > 1) {
                    int tmp = a[i];
                    a[i] = a[l.get(l.size() - 1 - cnt)];
                    a[l.get(l.size() - 1 - cnt)] = tmp;
                    n--;
                }
                
                if(n < 1) break;
            }//홀수 조건 
            if(n % 2 == 1) {
                int flag = 0;
                for(int i = 0; i < a.length; i++) {
                    for(int j = i + 1; j < a.length; j++) {
                        if(a[i] == a[j])
                            flag = 1;
                    }
                }
                if(flag == 0) {
                    int tmp = a[a.length - 1];
                    a[a.length -1] = a[a.length - 2];
                    a[a.length -2] = tmp;
                }
            }
             
            
            System.out.print("#" + t + " ");
            for(int i = 0; i < a.length; i++) 
                System.out.print(a[i]);

            System.out.println();
        }
    }
}