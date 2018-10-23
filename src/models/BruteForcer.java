package models;

import java.util.ArrayList;

public class BruteForcer implements PasswordGuesser{
	private ArrayList<Integer> charInts = new ArrayList<Integer>();
	private char[] charset;
	private int[] currentGuesses = {0};
	private String guess = "";

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
		if(currentGuesses[currentGuesses.length-1] == charset.length-1){
			currentGuesses[currentGuesses.length-1] = 0;
			incrementPrev(currentGuesses.length-1);
		}
		else{
			currentGuesses[currentGuesses.length-1]++;
		}
		return guess;
	}
	
	public void incrementPrev(int index){
		if(index == 0){
			currentGuesses = new int[currentGuesses.length+1];
		}
		else{
			currentGuesses[index-1]++;
		}
	}
}
