package programmers;

import java.util.LinkedList;
import java.util.Queue;

// 카카오 기출 - 2020 - 미완성 
public class q60059_Key {
	
	// key의 1이 lock의 0을 채우면 됨
	// key는 회전 가능, lock의 모든 0이 다 채워져야함. key는 lock 영역을 삐져나와도 됨. 
	// key : M X M,  lock : N X N,  M<=N
	
	static int N,M;
	
	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		N = key.length;
		int[][] lock = 	{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		M = key.length;
		System.out.println(solution(key, lock));
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
        boolean ans = false;
        
        // 1. key 시계방향으로 0도 회전한 배열과 lock을 비교 
        int[][] key1 = key;
        boolean case1 = compare(lock, key1);
        
        // 2. key 시계방향으로 90도 회전한 배열과 lock을 비교 
        int[][] key2 = rotate(key, 90);
        boolean case2 = compare(lock, key2);
        
        // 3. key 시계방향으로 180도 회전한 배열과 lock을 비교 
        int[][] key3 = rotate(key, 180);
        boolean case3 = compare(lock, key3);
        
        // 4. key 시계방향으로 270도 회전한 배열과 lock을 비교 
        int[][] key4 = rotate(key, 270);
        boolean case4 =compare(lock, key4);
        
        if(case1 || case2 || case3 || case4)
        	ans = true;
        
        return ans;
    }
	
	static int[][] rotate(int[][] arr, int degree) {
	    int[][] rotate;
	    int n = arr.length;
	    int m = arr[0].length;

	    switch (degree) {
	        case 90:
	        case 270:
	            rotate = new int[m][n];
	            break;
	        case 180:
	            rotate = new int[n][m];
	            break;
	        default:
	            throw new IllegalArgumentException();
	    }

	    for (int i = 0; i < rotate.length; i++) {
	        for (int j = 0; j < rotate[i].length; j++) {
	            switch (degree) {
	                case 90:
	                    rotate[i][j] = arr[n-1-j][i];
	                    break;
	                case 180:
	                    rotate[i][j] = arr[n-1-i][m-1-j];
	                    break;
	                case 270:
	                    rotate[i][j] = arr[j][m-1-i];
	                    break;
	            }
	        }
	    }

	    return rotate;
	}
	
	static boolean compare (int[][] lock, int[][] key) {
		boolean res = false; 
		
		// key배열의 부분집합이 lock의 0인 점들을 다 채우면 true임 
		// 그림 그려보면... 크기가 N+2M인 배열을 배열을 그려보면... 비교하기 쉽겠네... 
		int[][] lock2 = new int[(N + 2 * M)][(N + 2 * M)];
		for(int i = M; i < (N + M); i++) {
			for(int j = M; j < (N + M); j++) {
				lock2[i][j] = lock[i-M][j-M]; 
			}
		}
		// key와 lock을 비교하는 로직을 구현하는걸 못하겠음... 
		// 저 범위 안에 key가 포함되면 되는데... 
		// key를 저 범위 안에 뒀을 때, 저 범위의 모든 값이 1이면 제대로 한건데...
		// 이걸.. 어떻게... 구현을 해야할지 모르겠네. 

		
		return res;
	}
	
	static class Coordinate {
		int x;
		int y;
		Coordinate(int a, int b){
			x = a;
			y = b;
		}
	}

}
