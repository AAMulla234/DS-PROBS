package com.DSProblems.sampleArrays;

public class MaxProfitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices =  {2,5,8,6,4,9,2};
		System.out.println(maxProfitLevel2(prices));
	}
	
	 public static int maxProfit(int[] prices) {
	        int minPrice = Integer.MAX_VALUE;
	        int maxProfit = 0;
	 
	        for (int price : prices) {
	            if (price < minPrice) {
	                minPrice = price;
	            } else if (price - minPrice > maxProfit) {
	                maxProfit = Math.max(maxProfit, price - minPrice);
	            }
	        }
	 
	        return maxProfit;
	    }
	 
	 public static int maxProfitLevel2(int[] prices) {
		 int minPrice = prices[0];
		 int diff = 0, result = 0;
		 
		 for(int i =1; i < prices.length; i++) {
			 if (prices[i-1] < prices[i]) {
				 diff = Math.max(diff, prices[i] - minPrice);
			 } else {
				 minPrice = prices[i];
				 result += diff;
				 diff = 0;
			 }
		 }
		 return result+diff;
	 }
	
	
	/*public static int maxProfit(int[] prices) {
	      if (prices.length <= 1) {
	          return 0;
	      }
	      int buyAtPrice = prices[0];
	      int sellAtPrice = 0;
	      for (int i =1; i < prices.length; i++) {
	          sellAtPrice = Math.max(sellAtPrice, prices[i]);
	      }
	    	        
	     int maxProfit = sellAtPrice - buyAtPrice;
	     int i = 1;
	     
	     while (prices[i] != sellAtPrice) {
	        buyAtPrice = Math.min(buyAtPrice, prices[i]);
	        i++;
	     }
	     return Math.max(maxProfit, (sellAtPrice-buyAtPrice));
	    } */
	
	/* public int maxProfit(int[] prices) {
	       int maxProfit = 0;
	       if (prices.length <= 0)
	        return maxProfit;
	        
	       for (int i =0; i < prices.length; i++) {
	           int max = 0;
	           for(int j = i+1; j < prices.length; j++) {
	               max = Math.max(max, prices[j]);
	           }
	           if (prices[i] < max) {
	               int profit = max - prices[i];
	               maxProfit = Math.max(maxProfit, profit);
	           }
	           
	       }
	       return maxProfit;
	    } */

}
