package com.DSProblems.sampleDSProblems;
/**
 * 
 * https://codeforces.com/contest/371/problem/C
 */
public class Hamburgers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] availBSC = {3, 5, 6};
		long[] priceBSC = {7, 3, 9};
		long money = 100;
		System.out.println("Max Humburgers made:" + maxHamBurgers("BSC", availBSC, priceBSC, money));
		System.out.println("Max Humburgers made:" + maxHamBurgers2("BSC", availBSC, priceBSC, money));
	}
	
	
	public static long maxHamBurgers(String recipe, int[] availBSC, long[] priceBSC, long money) {
		char[] recipeArr = recipe.toCharArray();
		int b = availBSC[0];
		int s = availBSC[1];
		int c = availBSC[2];
		
		long bp = priceBSC[0];
		long sp = priceBSC[1];
		long cp = priceBSC[2];
		
		int B=0, S=0, C=0;
		for (char r: recipeArr) {
			switch(r) {
			case 'B': B++;
			break;
			case 'S': S++;
			break;
			case 'C': C++;
			break;
			default:
				System.out.println("Invalid Recipe");
				return -1;
			}
		}
		
		long ans =0;
		long low =0, high = money;
		
		while(low <= high) {
			long mid = low + (high-low)/2;
			
			if((Math.max(mid*B-b, 0)*bp + Math.max(mid*S-s, 0)*sp + Math.max(mid*C-c, 0)*cp <= money)) {
				low = mid+1;
				ans = Math.max(mid, ans);
			}else
				high = mid -1;
		}
		return ans;
	}
	
	public static int maxHamBurgers2(String recipe, int[] availBSC, long[] priceBSC, long money) {
		char[] recipeArr = recipe.toCharArray();
		int b = availBSC[0];
		int s = availBSC[1];
		int c = availBSC[2];
		
		long bp = priceBSC[0];
		long sp = priceBSC[1];
		long cp = priceBSC[2];
		
		int B=0, S=0, C=0;
		for (char r: recipeArr) {
			switch(r) {
			case 'B': B++;
			break;
			case 'S': S++;
			break;
			case 'C': C++;
			break;
			default:
				System.out.println("Invalid Recipe");
				return -1;
			}
		}
		
		boolean repeat = false;
		int humburgers = 0;
		
		while(money >= 0 && !repeat) {
			if(b>=0) {
				if(B == 0) b =0;
				int tmp = b - B;
				if(tmp >=0) b -= B;
				else {
					money -= Math.abs(tmp) * bp;
					b = 0;
				}
			}
			
			if(s>=0) {
				if(S == 0) s =0;
				int tmp = s - S;
				if(tmp >=0) s -= S;
				else {
					money -= Math.abs(tmp) * sp;
					s = 0;
				}
			}
			
			if(c>=0) {
				if(C == 0) c =0;
				int tmp = c - C;
				if(tmp >=0) c -= C;
				else {
					money -= Math.abs(tmp) * cp;
					c = 0;
				}
			}
			
			 if(money >= 0)
				 humburgers++;
			 if(b + s + c == 0) repeat = true;  
		}
		return humburgers;
	}

}
