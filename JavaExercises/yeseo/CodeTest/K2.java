package CodeTest;
import java.util.*;
import java.io.*;
public class K2 {


	    public static int countDuplicate(List<Integer> numbers) {
	    // Write your code here

            int total=0;
            boolean[] set=new boolean[1000000];
            for(int i=0;i<numbers.size();i++) {
                    if(!set[numbers.get(i)]) {
                            set[numbers.get(i)]=true;
                            total++;
                    }
            }
            int result[]=new int[total];
            int c=0;
            for(int i=0;i<set.length;i++) {
                    if(set[i]) result[c++]=i; 
            }
            int count=numbers.size()-result.length;
            return count;
	    }

	
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<Integer> numbers = new ArrayList<>();

	        for (int i = 0; i < numbersCount; i++) {
	            int numbersItem = Integer.parseInt(bufferedReader.readLine().trim());
	            numbers.add(numbersItem);
	        }

	        int result =countDuplicate(numbers);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
	


}


