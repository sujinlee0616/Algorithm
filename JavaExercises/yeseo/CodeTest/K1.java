package CodeTest;


	import java.io.*;
	import java.util.*;



	public class K1 {

	    /*
	     * 테스트케이스 몇개 받을지
	     product를 배열로 받고
	     그 예상 금액 
	     실제 금액
	     비교해서 맞으면 0
	     틀리면 1
	     1의 개수를 리턴 
	     */

	    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
	    // Write your code here
	    int result=0;
	    for(int i=0;i<productSold.size();i++){
	        String now=productSold.get(i);
	        int index=0;
	        for(int j=0;j<products.size();j++){
	              if(products.get(i).contains(now))
	              index= j;
	        }
	        if(productPrices.get(index)==soldPrice.get(i))
	        return 0;
	        else 
	        result+=1; 
	        System.out.println(result);
	    }

	    return result;

	    }

	}
	class Solution {
		public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int productsCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<String> products = new ArrayList<>();

	        for (int i = 0; i < productsCount; i++) {
	            String productsItem = bufferedReader.readLine();
	            products.add(productsItem);
	        }

	        int productPricesCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<Float> productPrices = new ArrayList<>();

	        for (int i = 0; i < productPricesCount; i++) {
	            float productPricesItem = Float.parseFloat(bufferedReader.readLine().trim());
	            productPrices.add(productPricesItem);
	        }

	        int productSoldCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<String> productSold = new ArrayList<>();

	        for (int i = 0; i < productSoldCount; i++) {
	            String productSoldItem = bufferedReader.readLine();
	            productSold.add(productSoldItem);
	        }

	        int soldPriceCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<Float> soldPrice = new ArrayList<>();

	        for (int i = 0; i < soldPriceCount; i++) {
	            float soldPriceItem = Float.parseFloat(bufferedReader.readLine().trim());
	            soldPrice.add(soldPriceItem);
	        }

	        int result = K1.priceCheck(products, productPrices, productSold, soldPrice);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
}
