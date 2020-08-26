package incorrect_note;

import java.util.*;

public class boj_2776 {
//암기왕
	//이분탐색 ) 수첩 1 ~2 비교해서 작으면 left, 크면 right에 넣으면 되는 문제 
	//Map/SET  가능 => containsKey
	//BufferedReader 사용 = 시간초과 막음 
	public static void main(String[] args) {
		int T,N,M;
		Scanner scan=new Scanner(System.in);
		T=scan.nextInt();
		for(int i=0;i<T;i++) {
		N=scan.nextInt();
		/*
		a)이분탐색 시도(X) 
		int A[]=new int[N];
		 
		for(int i=0;i<N;i++)
			A[i]=scan.nextInt();
		
		
		Arrays.sort(A);
		
		M=scan.nextInt();
		int B[]=new int[M];
		for(int i=0;i<M;i++) {
			B[i]=scan.nextInt();
	
			if(Arrays.binarySearch(A, B[i])==0)
				System.out.println("1");
			else
				System.out.println("0");
		}
		
		}
		*/
		
		//b)HashMap = shortest
		Map<Integer,Boolean> map=new HashMap<>();
		for(int j=0;j<N;j++)
			map.put(scan.nextInt(), true);
		M=scan.nextInt();
		for(int j=0;j<M;j++) {
			if(map.containsKey(scan.nextInt()))
				System.out.println("1");
			else
				System.out.println("0");
		}
		
		
		//c)HashSet **
/*
  	Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
        	HashSet<Integer> hash = new HashSet<Integer>();
        	int n = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	while(st.hasMoreTokens()){
        		hash.add(Integer.parseInt(st.nextToken()));
        	}
        	int m = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine(), " ");
        	while(st.hasMoreTokens()){
        		if(hash.contains(Integer.parseInt(st.nextToken()))) bw.write("1\n");
        		else bw.write("0\n");
        	}
        }
    	bw.close();
    	
    }
 */
		}
		
			
	}
}
