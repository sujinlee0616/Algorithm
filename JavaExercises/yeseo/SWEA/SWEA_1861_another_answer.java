package SWEA;
import java.util.Scanner;
 
public class SWEA_1861_another_answer {
 
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int N,ans,cnt,MAX;
    static int arr[][];
    static boolean check[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
         
 
         
        for (int t = 0; t < tc; t++) {
            N = sc.nextInt();
            arr= new int[N][N];
             
            ans = N*N;
            MAX = 1;
            cnt = 1;
            int startr = 0;
            int startc = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    check = new boolean[N][N];
                    int start = arr[i][j];
                    findRoom(i,j,1,start);
                }
            }
         
            System.out.println("#"+(t+1)+" "+ans+" "+MAX);
        }
    }
    private static void findRoom(int r, int c,int cnt, int start) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            check[r][c] = true;
            if(nr>=0&&nr<N&&nc>=0&&nc<N) {
                if(Math.abs(arr[r][c] - arr[nr][nc])==1) {
                    if(check[nr][nc]==false) {
                        cnt++;
 
                        if(MAX<cnt) {
                            MAX = cnt;
                            ans = start;
                        }else if(MAX == cnt) {
                            if(ans>start) {
                                ans = start;
                            }
                        }
                        findRoom(nr,nc,cnt,start);
                    }
                }
            }
        }
         
    }
}