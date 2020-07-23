package boj;
import java.util.*;
public class boj_q15649 {

	    static int N;
	    static int M;
	    static boolean[] visited;
	    static int[] arr;
	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        N = sc.nextInt();
	        M = sc.nextInt();
	        visited = new boolean[N+1];
	        arr = new int[N+1];

	        dfs(0);
	    }

	    static void dfs(int current) {
	        if (current == M) { 
	            for (int i = 0; i < M; i++) {
	                System.out.print(arr[i] + " ");
	            }
	            System.out.println();
	        } else {
	            for (int i = 1; i <= N; i++) {
	                if (visited[i] == true) {
	                    continue;
	                }
	                visited[i] = true;
	                arr[current] = i; 
	                dfs(current + 1);
	                visited[i] = false;
	            }
	        }
	    }
	}

