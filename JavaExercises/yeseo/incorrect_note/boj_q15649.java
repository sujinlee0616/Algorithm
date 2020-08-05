package incorrect_note;
import java.util.*;
/*
  1. 최초 실행 시 dfs에 0이 전달되면서 1부터 n까지 탐색을 한다.

  2. 초기 상태이므로 1은 방문하지 않은 상태이기 때문에 check [1]을 방문처리

  3. 현재 반복 횟수가 0번째이므로 list [0] = 1이 된다.

  4. 반복 횟수를 +1 후 다시 전달한다. (즉 list에 [0] 번째 자리가 찼으므로 다음 자리를 찾는 과정)

  5. 2번째 자리부터는 다시 1부터 탐색한다. (1번 과정) 그러나 list [0]에는 1이 존재하고, 그에 따라 check [1] 역시 방문 처리되어있다. 그렇기 때문에 다음 탐색 대상인 2를 고려해 본다.

  6. 2는 한 번도 방문하지 않았기 때문에 check [2] = 1(2번 과정), list [1] = 2가 된다. (3번 과정)

  7. 이후 다시 반복 횟수를 증가시킨다. 그러나 m이 2이기 때문에 DFS메서드 종료부에 걸려 현재 list의 원소들을 모두 출력한다 

  8. 즉 1은 고정된 상태로 n까지 반복하면서 2번째 자리를 변경시켜주는 과정을 진행 후 다 찾으면 cnt가 0인 상태로  돌아가 2번을 탐색하기 때문에 list [0]은 2로 고정되고 위 과정을 반복한다
 */
public class boj_q15649 {
	static int m,n; 
	static int list[];	
	static boolean check[];
	
	static void dfs(int cnt) { //cnt=방문횟수 
			
		if(cnt == m) { 
			for(int i=0;i<m;i++) { 
				System.out.print(list[i]+" ");
			}
			System.out.println("");
			return;
		}
		
		for(int i =1;i<=n;i++) { 
			
			if(check[i]==true) continue; 
			check[i]=true; 
			list[cnt]=i; 
			dfs(cnt+1); // 반복횟수를 증가시킨다. (n까지) 
			check[i]=false; 
			
			
		}
		
		
	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		n = sc.nextInt(); 
		m = sc.nextInt(); 
		
		check = new boolean[n+1]; // n과 m의 최대범위
		list = new int [n+1];
		dfs(0);
	}
	
}