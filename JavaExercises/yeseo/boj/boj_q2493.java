package boj;
import java.io.*;
import java.util.*;

 /*
 탑
1)idx랑 top의 높이를 따로 받아야 해
a) Map에<K,V>를 담는다
b) 애초에 Stack을 두번 담는다

해결법)
기존에 생각한 내 방식
curr < arr[i] -push
curr == arr[i] -continue (0)
curr > arr[i] -pop 
은 맞는데,

몇개?를 출력하는게 핵심
Top의 높이를 출력하는게 아님 .

  */

public class boj_q2493 {

    public static void main(String [] args){


        int N, idx, top;

   

        Stack<Integer> stack= new Stack<Integer>();
        Stack<Integer> index= new Stack<Integer>();

        
        scan.init(); //이 메소드 재사용하기 
        N= scan.nextInt();

        idx= scan.nextInt();
        stack.push(N);
        index.push(1);

        System.out.print("0");

        

        for(int i=2; i<=N; i++) {
            idx= scan.nextInt();
            while(true) {
                if(!stack.empty()) {
                    top= stack.peek();
                    if(top > N) {
                        System.out.print(" "+index.peek());
                        stack.push(idx);
                        index.push(i);
                        break;

                    }else {
                        stack.pop();
                        index.pop();

                    }

                }else {   
                    System.out.print(" 0");
                    stack.push(idx);              
                    index.push(i);

                    break;
               }
           }

        }

    }

////////////////////BufferedReader써야될때 사용!!!!     

    static class scan {

        private static BufferedReader br;

        private static StringTokenizer st;

        

        static void init() {

            br = new BufferedReader(new InputStreamReader(System.in));

            st = new StringTokenizer("");

        }

 

        static String next() {

            while (!st.hasMoreTokens()) {

                try {

                    st = new StringTokenizer(br.readLine());

                } catch (IOException e) {

                }

            }

            return st.nextToken();

        }

 

        static int nextInt() {

            return Integer.parseInt(next());

        }

    }

}
	

