package models;

import java.util.ArrayList;

public class BruteForcer implements PasswordGuesser{
	private ArrayList<Integer> charInts = new ArrayList<Integer>();
	private char[] charset;
	private int[] currentGuesses = {0};
	private String guess = "";

	//add the charset's utf-8 hex codes to an arraylist and then cast to char for easy charset creation
	public BruteForcer(){
		for(int i = 0x20; i <= 0x7e; i++){
			charInts.add(i);
		}
		charset = new char[charInts.size()];
		for(int i = 0; i < charset.length; i++){
			charset[i] = (char)charInts.get(i).intValue();
		}
	}
	
	public String getNext(){
		guess = "";
		for(Integer i : currentGuesses){
			guess += charset[i];
		}
		increment(currentGuesses.length-1);
		return guess;
	}
	
	//increment the current index, if it's maxed increment the previous, if it's 0 increase the length being guessed
	public void increment(int index){
		if(currentGuesses[index] == charset.length-1){
			if(index == 0){
				currentGuesses = new int[currentGuesses.length+1];
			}
			else{
				currentGuesses[index] = 0;
				increment(index-1);
			}
		}
		else{
			currentGuesses[index]++;
		}
	}
}
