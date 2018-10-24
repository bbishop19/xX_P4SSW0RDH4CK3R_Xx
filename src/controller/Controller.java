package controller;

import java.util.ArrayList;

import models.PasswordGuesser;
import models.WindwardHacker;

public class Controller {
	ArrayList<PasswordGuesser> guessers = new ArrayList<PasswordGuesser>();
	public static void main(String[] args){
		WindwardHacker wwh = new WindwardHacker();
		String password = "Chair*2019";
		String guess;
		long time = System.currentTimeMillis();
		do {
			guess= wwh.getNext();
		}while (!(guess == null || guess.equals(password)));
		time = System.currentTimeMillis() - time;
		System.out.println(guess);
		System.out.println(time);
	}
}
