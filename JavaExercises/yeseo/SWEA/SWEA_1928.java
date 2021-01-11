package swea;

import java.util.Base64;
import java.util.Scanner;

public class SWEA_1928 {
// 디코더 
	//base 64 
	// encoding   8bit *3글자 => 6bit*4
	// decoding 		     <=
// 바이너리로는 읽을 수 없는 ASCII를 변환하는 효과가 있다
// 효율성이 높아짐
	public static char[] table;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		for(int tc=1; tc<=T; ++tc) {
			String st=scan.next();
			//디코딩하는 메소드가 존재
			String res=new String(Base64.getDecoder().decode(st));

		System.out.println("#"+tc+" "+res);
		}
		scan.close();
		
		
		// 참고 *
        table = new char[64];
        for(int i=0;i<26;i++) {
            table[i] = (char)('A'+i);
        }
        for(int i=26;i<52;i++) {
            table[i] = (char)('a'+(i-26));
        }
        for(int i=52;i<62;i++) {
            table[i] = (char)('0'+(i-52));
        }
        table[62]='+';
        table[63]='/';
       
        String str;
        String temp;
        int[] shift = new int[6];
        int[] mask = new int[4];
        int[] bit = new int[6];
        int[] c = new int[4];
        shift[0] = 1;
        for (int i = 1; i < shift.length; i++) {
            shift[i] = shift[i-1] << 1;
        }

        for (int i = 0; i < shift.length; i++) {
            if(i>=4 && i<=5)mask[0] += shift[i];
            if(i>=0 && i<=3)mask[1] += shift[i];
            if(i>=2 && i<=5)mask[2] += shift[i];
            if(i>=0 && i<=1)mask[3] += shift[i];
        }
        T=scan.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            //24비트씩 주고 6비트씩 한문자
            System.out.print("#"+test_case+" ");
            str=scan.next();
            int length = str.length();
            for (int i = 0; i < length/4; i++) {
                temp = str.substring(0,4);
                str = str.substring(4);
                //1~6 7~8&1~4 5~8&1~2 3~8
                for (int j = 0; j < c.length; j++) c[j] = getByte(temp.charAt(j));
                bit[0] = (c[0]<<2)+((c[1]&mask[0])>>4);
                bit[1] = ((c[1]&mask[1])<<4) + ((c[2]&mask[2])>>2);
                bit[2] = ((c[2]&mask[3])<<6) + (c[3]);
                System.out.print(""+(char)bit[0]+(char)bit[1]+(char)bit[2]);
                 
            }
            System.out.println();
        }
    }
    public static int getByte(char c) {
        for (int i = 0; i < table.length; i++) {
            if(table[i]==c)return i;
        }
        return -1;
    }
}
