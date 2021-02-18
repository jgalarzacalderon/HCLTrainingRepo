package com.project;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingMain {

	public static void main(String[] args) {
		
		int n = 100;
		SequenceGenerator sg = new SequenceGenerator(n);
		ArrayList<Integer> sequence = sg.GenerateSequence();
		
		System.out.println(sequence);
		
		longestSubList(sequence);
				
	}

	private static void longestSubList(List<Integer> mainList) {
		ArrayList<Integer> maxSubList = new ArrayList<>();
		ArrayList<Integer> currentSubList = new ArrayList<>();
		int maxSubSize = 0;
		int maxValue = -1;
		int currentValue;
		
		/* Iterates through the ArrayList and compares the currentValue (i) with the maxValue found.
		 * If the currentValue is greater than the maxValue it adds it to the currentSubList. Once it
		 * encounters a number lower than maxValue it adds each element in currentSubList to maxSubList 
		 * to keep track of it and resets maxValue and clears currentSublist. It then begins to check 
		 * the original ArrayList values again from the position it ended at for another non-disjointed 
		 * increasing subsequence. If it encounters a new subsequence longer than the current longest
		 * subsequence (maxSubList) then it will clear the current maxSubList and write the new longer 
		 * sequence to maxSubList. It will not overwrite maxSubList if another increasing subsequence of the 
		 * same size is encountered and will only store the first instance of the longest sized subsequence. 
		 */
		for (int i = 0; i < mainList.size(); i++) {
			currentValue = mainList.get(i);
			
			// Check if current Value is greater than maxValue and if so add it to the currentSubList
			// If not move the subsequence into maxSubList and reset maxValue and currentSubList to prepare
			// to search for a possible new longer sublist continuing from the end index of the most recent
			// longest subsequence.
			if (currentValue > maxValue) {
				currentSubList.add(currentValue);
				maxValue = currentValue;
			} else {
				if (maxSubSize < currentSubList.size()) {
					maxSubList.clear();
					for (int j = 0; j < currentSubList.size(); j++) {
						maxSubList.add(currentSubList.get(j));
					}
					maxSubSize = currentSubList.size();
				}
				// Resets maxValue and clears the current sublist so that the it can start generating the next sublist.
				maxValue = -1;
				currentSubList.clear();
				i--;
			}
		}
		
		System.out.println("First longest non-disjointed sublist is: " + maxSubList + " with length: " + maxSubSize);

	}
}
