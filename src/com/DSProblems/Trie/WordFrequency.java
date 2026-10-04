package com.DSProblems.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class WordFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] s = {"i", "love", "code", "idsd", "lovesss", "java"};
		List<String> ansList = topKFrequent(s, 2);
		for(String ans: ansList) {
			System.out.println(ans);
		}
	}

	
	public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map=new HashMap<>();
        for(int i=0; i<words.length; i++){
            if(map.containsKey(words[i])){
               map.put(words[i],map.get(words[i])+1);
            }else{
               map.put(words[i],1);
            }
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)-> map.get(b) != map.get(a)? map.get(b) - map.get(a) : a.compareTo(b));
        pq.addAll(map.keySet());
        List<String> ans=new ArrayList<>();
        for(int i=0; i<k; i++){
            ans.add(pq.poll());
        }
        return ans;
	}
	
}
