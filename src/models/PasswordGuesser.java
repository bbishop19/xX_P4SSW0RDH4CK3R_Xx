package models;

public interface PasswordGuesser {
	//all getNext functions get the next attempt from a guesser and increment its state
    String getNext();
}
