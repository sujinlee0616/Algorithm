package format;

import java.util.Arrays;
import java.util.Scanner;

// [N과 M 최적화 코드] - 순열, 조합, 중복순열, 중복조합 ★★★ 
public class NandM {
	
	private static int N, totalCnt;
	   private static int[] numbers;
	   private static boolean[] isSelected;
	   public static void main(String[] args) {
	      Scanner scn = new Scanner(System.in);
	      N = scn.nextInt();
	      
	      numbers = new int[N];
	      isSelected = new boolean[7];
	      int mode = scn.nextInt();
	      totalCnt = 0;
	      
	      switch(mode) {
	      case 1: //중복순열
	         dice1(0);
	         break;
	      case 2: //순열
	         dice2(0);
	         break;
	      case 3: //중복조합
	         dice3(0,1);
	         break;
	      case 4: //조합
	         dice4(0,1);
	         break;
	      }
	      System.out.println("총 경우의 수 : " + totalCnt);
	      scn.close();
	   }
	   //중복순열
	   private static void dice1(int cnt) { 
	      if(cnt >= N) {
	         System.out.println(Arrays.toString(numbers));
	         totalCnt++;
	         return;
	      }
	      for(int i = 1; i <= 6; i++) {
	         numbers[cnt] = i;
	         dice1(cnt+1);
	      }
	   }
	   // 순열
	   private static void dice2(int cnt) {
	      if(cnt >= N ) {
	         System.out.println(Arrays.toString(numbers));
	         totalCnt++;
	         return;
	      }
	      for(int i = 1; i <= 6; i++) {
	         if(isSelected[i] == true) continue;
	         isSelected[i] = true;
	         numbers[cnt] = i;
	         dice2(cnt+1);
	         isSelected[i] = false;
	      }
	   }
	   //중복 조합
	   private static void dice3(int cnt, int start) {
	      if(cnt >= N) {
	         System.out.println(Arrays.toString(numbers));
	         totalCnt++;
	         return;
	      }
	      for(int i = start; i <= 6; i++) {
	         numbers[cnt] = i;
	         dice3(cnt+1, i);
	      }
	   }
	   //조합
	   private static void dice4(int cnt, int start) {
	      if(cnt >= N) {
	         System.out.println(Arrays.toString(numbers));
	         totalCnt++;
	         return;
	      }
	      for(int i = start; i <= 6; i++) {
	         numbers[cnt] = i;
	         dice4(cnt+1, i+1);
	      }
	   }

}
