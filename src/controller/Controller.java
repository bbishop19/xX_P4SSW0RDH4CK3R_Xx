package controller;

import javafx.stage.Stage;
import models.*;
import view.View;

public abstract class Controller {
	public static CrackInfo windwardHack(String password){
		return crack(password, new WindwardHacker());
	}
	
	public static CrackInfo bruteForce(String password){
		return crack(password, new BruteForcer());
	}
	
	public static CrackInfo commonHack(String password){
		return crack(password, new CommonHacker());
	}
	
	public static CrackInfo crack(String password, PasswordGuesser guesser){
		String guess;
		boolean cracked = false;
		long time = System.currentTimeMillis();
		int attempts = 0;
		do {
			guess = guesser.getNext();
			attempts++;
			if(guess.equals(password)){
				cracked = true;
				break;
			}
		}while (guess != null);
		time = System.currentTimeMillis() - time;
		return new CrackInfo(cracked, time, attempts);
	}
}
