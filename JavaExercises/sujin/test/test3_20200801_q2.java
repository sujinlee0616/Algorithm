package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result2 {

    public static int countDuplicate(List<Integer> numbers) {
    // Write your code here
        int res=0;
        int[] count=new int[1001];
        
        for(int i=0;i<numbers.size();i++) {
        	for(int j=0;j<1001;j++) {
        		if(numbers.get(i)==count[j])
            		count[j]++;
        	}
        	
        }
        for(int i=0;i<1001;i++) {
        	if(count[i]>=2)
        		res++;
        }

        return res;
    }

}

public class test3_20200801_q2 {
	 public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<Integer> numbers = IntStream.range(0, numbersCount).mapToObj(i -> {
	            try {
	                return bufferedReader.readLine().replaceAll("\\s+$", "");
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        })
	            .map(String::trim)
	            .map(Integer::parseInt)
	            .collect(toList());

	        int result = Result2.countDuplicate(numbers);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
}
