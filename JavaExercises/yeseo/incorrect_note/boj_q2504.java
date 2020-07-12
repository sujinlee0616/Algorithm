package incorrect_note;

import java.util.Scanner;
import java.util.Stack;

public class boj_q2504 {
//괄호의 값 
	public static void main(String[] args) {
		//[()] =6 () :2 [] :3  [2] 여는괄호 : 스택에 저장  2*3 = 6
		//여는 괄호 , 닫는괄호 PUSH
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Stack<String> st=new Stack<String>();
		
		boolean bCheck=true;
		for(int i=0;i<s.length();i++) {
			String c=s.substring(i,i+1);
			//바로 그 다음
			if("(".equals(c)) {
				st.push(")");
				continue;
			}
			if("[".equals(c)) {
				st.push("]");
				continue; 
			}
			//짝이 안됐는데 스택이 비어있음 bCheck=false
			int num=0;
			while(true) {
				if(st.isEmpty()) {
					bCheck=false;
					break;
				}
				if(isNumber(st.peek())) {
					num+=Integer.parseInt(st.pop());
				}else {
					if(isVPS(c,st.peek())) {
						st.pop();
						int t=(")".equals(c))? 2:3;
						if(num==0) {
							st.push(String.valueOf(t));
						}else {
							st.push(String.valueOf(t*num));
						} break;
	
					}else {
						bCheck=false;
						break;
					}
				}
			}
			if(!bCheck)break;
		}
		
		int result=0;
		while(!st.isEmpty()) {
            if(isNumber(st.peek())) {
                result += Integer.parseInt(st.pop());
            }else {
                bCheck = false;
                break;
            }
        }
        
        if(bCheck) System.out.println(result);
        else System.out.println(0);
    }
    
    public static boolean isVPS(String c, String target) {
        if(c.equals(target)) return true;
        return false;
    }
    
    // 두 괄호가 아니면 무조건 숫자이다.
    public static boolean isNumber(String str) {
        if(str.equals(")") || str.equals("]")) return false;
        return true;
    }

}
