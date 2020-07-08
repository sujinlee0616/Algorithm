package CodeTest;

import java.util.ArrayList;
/*
return true / contains same string 
 */
public class Q4 {

	public static boolean solution(String []name_list) {
		boolean answer=true;
		ArrayList result=new ArrayList();
		//i=0
		for(int i=0;i<name_list.length;i++)
		{
				for(int j=i;j<name_list.length;j++) {
					if(j!=name_list.length-1) {
					answer=(name_list[i].contains(name_list[j+1]) || name_list[j+1].contains(name_list[i])?true:false);
					result.add(answer);
					}
					else {
						continue;
					}
				}
		}
		
		for(int i=0;i<result.size();i++) {
			result.get(i);
		    //System.out.println(result.get(i));
		    if(result.get(i).equals(true))
		    	answer=true;
		}
			
		

		return answer;
	}
	
	
	
	public static void main(String[] args) {
		String []input1= {"lo","love","true"};	
		System.out.println(solution(input1));
		
	}
	
}
