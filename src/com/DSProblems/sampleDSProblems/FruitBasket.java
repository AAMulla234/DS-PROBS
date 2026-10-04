package com.DSProblems.sampleDSProblems;

/**
 * https://anj910.medium.com/leetcode-904-fruit-into-baskets-79780c110c5
 */
public class FruitBasket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//{1,2,2,3,2,2};
		int fruits[] = {1,2,2,1};
		System.out.println("Maximum Fruits can be picked:::" + totalFruit(fruits));
	}

	public static int totalFruit(int[] tree) {
        int n = tree.length;
        int type1 = tree[0], type2 = -1;
        int combos = 1;//assume type1 is prev type
        int curLen = 1, max = 1;
        for(int i=1;i<n;i++)
        {
            if(tree[i] != type1 && tree[i] != type2 && type2!=-1)
            { // In case of 3rd type, swap  type2 is type 1 and type 1 is new type
                max = Math.max(curLen, max);
                curLen = combos + 1;
                type2 = type1; 
                type1 = tree[i];
                combos = 1;
                continue;
            }
            if(tree[i] == type1) // If current type is same as previous one
                combos++;
            else //swap type1 and type2  
            {
                type2 = type1;
                type1 = tree[i];
                combos = 1;
            }
            curLen++;
        }
        return Math.max(max,curLen);
    }
}
